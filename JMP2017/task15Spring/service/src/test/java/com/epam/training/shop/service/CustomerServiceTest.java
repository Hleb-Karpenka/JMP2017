package com.epam.training.shop.service;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import com.epam.training.shop.model.CartContent;
import com.epam.training.shop.model.Customer;
import com.epam.training.shop.model.CustomerCredentials;
import com.epam.training.shop.model.Gender;
import com.epam.training.shop.model.Order;
import com.epam.training.shop.model.UserRole;
import com.epam.training.shop.repository.filter.Comparison;
import com.epam.training.shop.repository.filter.Condition;
import com.epam.training.shop.repository.filter.CustomerFilter;
import com.epam.training.shop.repository.filter.Filter;
import com.epam.training.shop.service.configuration.TestDataBaseConfig;
import junit.framework.Assert;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class CustomerServiceTest {

	@Resource
	private CustomerService customerService;
	Customer customer;
	List<Customer> customerList = new ArrayList();;
	int count = 3;

	@Before
	public void createCustomer() {
		customerService.deleteAll();

		for (int i = 0; i < count; i++) {
			Customer cTest = new Customer();
			CustomerCredentials cCredentials = new CustomerCredentials();
			cCredentials.setLogin(String.format("%stestUser", i));
			cCredentials.setPassword("testPassword");
			cCredentials.setRole(UserRole.customer);
			cTest.setFirstName(i + "testFirstName");
			cTest.setLastName("testLastName");
			cTest.setEmail(String.format("%stestEmail@ya.ru", i));
			Random x = new Random();
			int s = x.nextInt(6);
			cTest.setAddress("Gorkogo " + s);
			cTest.setCity("Hrodno");
			cTest.setCountry("Belarus " + s);
			cTest.setDateBirth(new Date(12 - 12 - 2000));
			cTest.setCreated(new Date());
			cTest.setGender(Gender.UNKNOWN);
			cTest.setZipCode("230020");
			customer = customerService.registerCustomer(cTest, cCredentials);
			customerList.add(customer);
		}
	}

	@Test
	public void getCustomer() {
		Random random = new Random();
		int randomIndex = random.nextInt(count);
		customer = customerList.get(randomIndex);
		customer = (customerService.findOne(customer.getId()));
	}

	@Test
	public void updateCustomer() {
		String firstNameUpd = "testUserUpdateName";
		String loginUpd = "testLoginUPDATE";
		Random random = new Random();
		int randomIndex = random.nextInt(count);
		customer = customerList.get(randomIndex);
		customer.getCustomerCredentials().setLogin(loginUpd);
		customer.setFirstName(firstNameUpd);
		customerService.saveAndFlush(customer);
		Assert.assertEquals(firstNameUpd, customerService.findOne(customer.getId()).getFirstName());
		Assert.assertEquals(loginUpd, customerService.findOne(customer.getId()).getCustomerCredentials().getLogin());
	}

	@Test
	public void getCustomerByCredentials() {
		CustomerCredentials getCustomer = customerService.getCustomerByCredentials("0testUser", "testPassword");
		Assert.assertNotNull(getCustomer);
	}

	@Test
	public void deleteCustomer() {
		Random random = new Random();
		int randomIndex = random.nextInt(count);
		customer = customerList.get(randomIndex);
		customerService.delete(customer.getId());
		Assert.assertNull(customerService.findOne(customer.getId()));
	}

	@Test
	public void findAll() {
		List<Customer> list = customerService.findAll();
		Assert.assertFalse(list.isEmpty());
	}

	@Test
	public void findAllSort() {
		Sort sort = new Sort(Sort.Direction.ASC, "firstName");
		List<Customer> list = customerService.findAll();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		Assert.assertFalse(list.isEmpty());
	}

	@Test
	public void count() {
		Long count1 = customerService.count();
		Long count2 = (long) customerList.size();
		System.out.println("count1 = " + count1 + " ,count2 = " + count2);
		Assert.assertEquals(count1, count2);
	}

}
