package com.epam.training.shop.service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.epam.training.shop.model.CartContent;
import com.epam.training.shop.model.Category;
import com.epam.training.shop.model.Customer;
import com.epam.training.shop.model.CustomerCredentials;
import com.epam.training.shop.model.Gender;
import com.epam.training.shop.model.Product;
import com.epam.training.shop.model.Season;
import com.epam.training.shop.model.Tire;
import com.epam.training.shop.model.TireDestination;
import com.epam.training.shop.model.UserRole;
import com.epam.training.shop.service.configuration.TestDataBaseConfig;
import junit.framework.Assert;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class CartServiceTest {

	@Resource
	private CartService cartService;

	@Resource
	private CustomerService customerService;

	@Autowired
	CategoryService categoryService;

	@Resource
	private ProductService productService;

	public Product createProduct() {
		Tire tire = new Tire();
		tire.setName("Product");
		tire.setManufacturer("manufacturerProduct");
		tire.setModel("modelProduct");
		tire.setImageURL("imageProduct ");
		tire.setDescription("description product Product");
		tire.setCountRecommended(777);
		tire.setAvailable(10);
		Category category = categoryService.findOne(3L);
		tire.setCategory(category);
		tire.setCountOrder(34);
		tire.setPrice(2000000);
		tire.setProfileHeight(105);
		tire.setProfileWidth(80);
		tire.setRimSize(4);
		tire.setSpikes(false);
		tire.setTireDestination(TireDestination.car);
		tire.setTireSeason(Season.summer);
		return productService.save(tire);
	}

	public Customer createCustomer() {
		CustomerCredentials customerCredentials = new CustomerCredentials();
		Customer customer = new Customer();
		customerCredentials.setLogin(String.format("testUser"));
		customerCredentials.setPassword("testPassword");
		customerCredentials.setRole(UserRole.customer);
		customer.setFirstName("testFirstName");
		customer.setLastName("testLastName");
		customer.setEmail(String.format("testEmail@ya.ru"));
		customer.setAddress("Gorkogo 89");
		customer.setCity("Hrodno");
		customer.setCountry("Belarus");
		customer.setDateBirth(new Date(1970, 1, 1));
		customer.setCreated(new Date());
		customer.setGender(Gender.UNKNOWN);
		customer.setZipCode("230020");
		customer.setCustomerCredentials(customerCredentials);
		return customerService.save(customer);
	}

	CartContent createCart() {
		Product product = createProduct();
		Long productId = product.getId();
		Customer customer = createCustomer();
		Long customerId = customer.getId();
		Random random = new Random();
		int amount = random.nextInt(10);
		CartContent cartContent = new CartContent();
		cartContent.setCustomer(customer);
		cartContent.setProduct(product);
		cartContent.setAmount(0);
		cartContent.setDateAdd(new Date());
		cartContent.setPrice(0);
		cartContent = cartService.save(cartContent);
		return cartContent;
	}

	@Test
	public void addToCartAndChangeAmount() {
		CartContent cartContent = createCart();
		Long productId = cartContent.getProduct().getId();
		Long customerId = cartContent.getCustomer().getId();
		Assert.assertNotNull(cartContent);
		cartService.addProductToCart(productId, customerId, 3);
		CartContent cartContentUpd = cartService.findOne(cartContent.getId());
		Assert.assertEquals(3, (int) cartContentUpd.getAmount());
		cartService.delete(cartContent.getId());
		customerService.delete(customerId);
	}

	@Test
	public void getAndClearCustomerCart() {
		CartContent cartContent = createCart();
		Long productId = cartContent.getProduct().getId();
		Long customerId = cartContent.getCustomer().getId();
		List<CartContent> list = cartService.getCustomerCartContent(customerId);
		Assert.assertNotNull(list);
		for (CartContent cartContent2 : list) {
			System.out.println(cartContent2);
		}
		cartService.clearCustomerCartContent(customerId);
		list = cartService.getCustomerCartContent(customerId);
		Assert.assertTrue(list.isEmpty());
		productService.delete(productId);
		customerService.delete(customerId);
	}

	@Test
	public void deleteItemFromCart() {
		CartContent cartContent = createCart();
		Long productId = cartContent.getProduct().getId();
		Long customerId = cartContent.getCustomer().getId();
		Long cartId = cartContent.getId();
		cartService.delete(cartId);
		Assert.assertNull(cartService.findOne(cartId));
		productService.delete(productId);
		customerService.delete(customerId);

	}

}
