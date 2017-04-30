package com.epam.training.shop.service;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.epam.training.shop.model.CarBattery;
import com.epam.training.shop.model.Category;
import com.epam.training.shop.model.Customer;
import com.epam.training.shop.model.CustomerCredentials;
import com.epam.training.shop.model.Gender;
import com.epam.training.shop.model.Order;
import com.epam.training.shop.model.Product;
import com.epam.training.shop.model.ProductComment;
import com.epam.training.shop.model.Season;
import com.epam.training.shop.model.Tire;
import com.epam.training.shop.model.TireDestination;
import com.epam.training.shop.model.UserRole;
import com.epam.training.shop.repository.filter.Comparison;
import com.epam.training.shop.repository.filter.Condition;
import com.epam.training.shop.repository.filter.Filter;
import com.epam.training.shop.service.configuration.TestDataBaseConfig;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class ProductServiceTest {
	@Autowired
	CustomerService customerService;
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	GenericProductService<Tire> genericService;
	List<Product> productList = new ArrayList();
	Product product;


	
	@Test
	public void testService() {
		Assert.assertNotNull(productService);
	}

	@Before
	public void createProduct() {
		productService.deleteAllComment();
		customerService.deleteAll();
		productService.deleteAll();
		int count = 10;
		for (int i = 0; i < count; i++) {
			Tire tire = new Tire();
			tire.setName(i + "Product");
			tire.setManufacturer(i + "manufacturerProduct");
			tire.setModel(i + "modelProduct");
			tire.setImageURL("imageProduct ");
			tire.setDescription("description product Product");
			tire.setCountRecommended(i);
			tire.setAvailable(i + 10);
			Category category =categoryService.findOne(3L);
			tire.setCategory(category);
			tire.setCountOrder(3 * i);
			tire.setPrice(100000 * i);
			tire.setProfileHeight(22 + i * 2);
			tire.setProfileWidth(10 + i * 4);
			tire.setRimSize(4);
			tire.setSpikes(false);
			tire.setTireDestination(TireDestination.car);
			tire.setTireSeason(Season.summer);
			product = productService.save(tire);
			productList.add(product);
		}
	}

	@Test
	public void getProductWithFilter() {
		Filter filter = new Filter();
		filter.addCondition(
				new Condition.Builder().setComparison(Comparison.gt).setField("price").setValue(10000).build());
		final PageRequest page1 = new PageRequest(0, 22, Direction.DESC, "price");
		List<Product> productPages = productService.findAll(filter, page1);
		int countFirstFilter = productPages.size();
		Assert.assertFalse(productPages.isEmpty());
		filter.addCondition(
				new Condition.Builder().setComparison(Comparison.lt).setField("price").setValue(800000).build());
		productPages = productService.findAll(filter, page1);
		int countSecondFilter = productPages.size();
		Assert.assertTrue(countFirstFilter > countSecondFilter);
	}

	@Test
	public void addCommentForProduct() {
		customerService.deleteAll();
		Customer cTest = new Customer();
		CustomerCredentials cCredentials = new CustomerCredentials();
		cCredentials.setLogin("LOginUSer");
		cCredentials.setPassword("testPassword");
		cCredentials.setRole(UserRole.customer);
		cTest.setFirstName("testFirstName");
		cTest.setLastName("testLastName");
		cTest.setEmail("testing@gmail.com");
		cTest.setAddress("Gorkogo 89");
		cTest.setCity("Hrodno");
		cTest.setCountry("Belarus");
		cTest.setDateBirth(new Date(12 - 12 - 1002));
		cTest.setCreated(new Date());
		cTest.setGender(Gender.MALE);
		cTest.setZipCode("230010");
		cTest = customerService.registerCustomer(cTest, cCredentials);
		Random random = new Random();
		int index = random.nextInt(10);
		Product product = productService.findOne(productList.get(index).getId());
		ProductComment prComment = productService.addCommentForProduct(product.getId(), cTest.getId(),
				"Nice! comment test");
		Assert.assertNotNull(prComment);
	}

	@Test
	public void getCommentByProduct() {
		Customer cTest = new Customer();
		CustomerCredentials cCredentials = new CustomerCredentials();
		cCredentials.setLogin("LOginUSer");
		cCredentials.setPassword("testPassword");
		cCredentials.setRole(UserRole.customer);
		cTest.setFirstName("testFirstName");
		cTest.setLastName("testLastName");
		cTest.setEmail("testing@gmail.com");
		cTest.setAddress("Gorkogo 89");
		cTest.setCity("Hrodno");
		cTest.setCountry("Belarus");
		cTest.setDateBirth(new Date(12 - 12 - 1002));
		cTest.setCreated(new Date());
		cTest.setGender(Gender.MALE);
		cTest.setZipCode("230010");
		cTest = customerService.registerCustomer(cTest, cCredentials);
		Random random = new Random();
		int index = random.nextInt(10);
		Product product = productService.findOne(productList.get(index).getId());
		ProductComment prComment = productService.addCommentForProduct(product.getId(), cTest.getId(),
				"Nice! comment test");
		prComment = productService.addCommentForProduct(product.getId(), cTest.getId(), "Nice! comment test2");
		List<ProductComment> listComment = productService.getCommentByProductId(product.getId());
		Assert.assertFalse(listComment.isEmpty());
	}
	@Test
	public void deleteCommentById(){
		Customer cTest = new Customer();
		CustomerCredentials cCredentials = new CustomerCredentials();
		cCredentials.setLogin("LOginUSer");
		cCredentials.setPassword("testPassword");
		cCredentials.setRole(UserRole.customer);
		cTest.setFirstName("testFirstName");
		cTest.setLastName("testLastName");
		cTest.setEmail("testing@gmail.com");
		cTest.setAddress("Gorkogo 89");
		cTest.setCity("Hrodno");
		cTest.setCountry("Belarus");
		cTest.setDateBirth(new Date(12 - 12 - 1002));
		cTest.setCreated(new Date());
		cTest.setGender(Gender.MALE);
		cTest.setZipCode("230010");
		cTest = customerService.registerCustomer(cTest, cCredentials);
		Random random = new Random();
		int index = random.nextInt(10);
		Product product = productService.findOne(productList.get(index).getId());
		ProductComment prComment = productService.addCommentForProduct(product.getId(), cTest.getId(),
				"Nice! comment test");
		prComment = productService.addCommentForProduct(product.getId(), cTest.getId(), "Nice! comment test2");
        Long id = prComment.getId();
        productService.deleteCommentById(id);
        Assert.assertNull(productService.getCommentById(id));
	}

	@Test
	public void getCommentByCustomer() {
		Customer cTest = new Customer();
		CustomerCredentials cCredentials = new CustomerCredentials();
		cCredentials.setLogin("LOginUSer");
		cCredentials.setPassword("testPassword");
		cCredentials.setRole(UserRole.customer);
		cTest.setFirstName("testFirstName");
		cTest.setLastName("testLastName");
		cTest.setEmail("testing@gmail.com");
		cTest.setAddress("Gorkogo 89");
		cTest.setCity("Hrodno");
		cTest.setCountry("Belarus");
		cTest.setDateBirth(new Date(12 - 12 - 1002));
		cTest.setCreated(new Date());
		cTest.setGender(Gender.MALE);
		cTest.setZipCode("230010");
		cTest = customerService.registerCustomer(cTest, cCredentials);
		Random random = new Random();
		int index = random.nextInt(10);
		Product product = productService.findOne(productList.get(index).getId());
		ProductComment prComment = productService.addCommentForProduct(product.getId(), cTest.getId(),
				"Nice! comment test");
		prComment = productService.addCommentForProduct(product.getId(), cTest.getId(), "Nice! comment test2");
		List<ProductComment> listComment = productService.getCommentByCustomerId(cTest.getId());
		Assert.assertFalse(listComment.isEmpty());
	}
	@Test
	public void deleteProductById(){
		Random random = new Random();
		int index = random.nextInt(10);
		Long id = productList.get(index).getId();
		Product product = productService.findOne(id);
		productService.delete(id);
		Assert.assertNull(productService.findOne(id));
		
	}
	
	@Test
	public void getProductByCategory() {
		Filter filter = new Filter();
		filter.addCondition(
				new Condition.Builder().setComparison(Comparison.eq).setField("category").setValue(categoryService.findOne(3L)).build());
		final PageRequest page1 = new PageRequest(0, 22, Direction.DESC, "price");
		List<Product> productPages = productService.findAll(filter, page1);
	}
	
	/*@Test
	public void getProductByCategoryId(){
	    Category category  = categoryService.findOne(3L);
		List<Product> productList = productService.findProductByCategoryId(category.getId());
		Assert.assertFalse(productList.isEmpty());}
		*/
	
	@Test
	public void getProductByCategoryName(){
		List<Product> productList = productService.findProductByCategoryName("Летние");
		for (Product product : productList) {
			System.out.println(product);
		}
		//Assert.assertFalse(productList.isEmpty());
		
	}
	@Test
	public void genericTest(){
		Tire tire = genericService.findOne(1799L);
		System.out.println(tire);
	}

}
