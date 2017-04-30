package com.epam.training.shop.service.impl;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.epam.training.shop.model.CartContent;
import com.epam.training.shop.model.Customer;
import com.epam.training.shop.model.Product;
import com.epam.training.shop.repository.CartContentRepository;
import com.epam.training.shop.repository.filter.Filter;
import com.epam.training.shop.service.CartService;
import com.epam.training.shop.service.CustomerService;
import com.epam.training.shop.service.ProductService;

@Service
@Transactional
public class CartServiceImpl extends BasicServiceImpl<CartContent, CartContentRepository, Long> implements CartService {
	private static Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

	@Autowired
	ProductService productService;
	@Autowired
	CustomerService customerService;

	@Override
	public void clearCustomerCartContent(Long id) {
		repository.clearCustomerCartContent(id);
		LOGGER.info("Cart by customer {} has been cleared", id);
	}
	@Override
	public Boolean addProductToCart(Long productId, Long customerId, Integer amount) {

		List<CartContent> contentCartCustomer = getCustomerCartContent(customerId);

		CartContent cartContent = new CartContent();
		Product product = productService.findOne(productId);
		Customer customer = customerService.findOne(customerId);
		if (product.getAvailable() == 0) {
			LOGGER.debug("Product is missing on the warehouse, id: " + product.getId());
			return false;
		}
		cartContent.setProduct(product);
		cartContent.setCustomer(customer);
		cartContent.setAmount(amount);
		cartContent.setDateAdd(new Date());
		cartContent.setPrice(product.getPrice() * amount);

		for (CartContent temp : contentCartCustomer) {
			boolean existItem = temp.getProduct().getId().equals(cartContent.getProduct().getId());
			if (existItem) {
				if (temp.getAmount() >= product.getAvailable()) {
					return false;
				}
				temp.setAmount(temp.getAmount() + amount);
				temp.setDateAdd(new Date());
				temp.setPrice(temp.getPrice() + product.getPrice() * amount);
				cartContent = repository.save(temp);
				LOGGER.info("Amount of items {} was changed for customer {} cart", product.getId(), customer.getId());
			}
		}
		cartContent = repository.save(cartContent);
		LOGGER.info("Item {} has been added to cart customer id:", product.getId(), customer.getId());
		return true;
	}

	@Override
	public List<CartContent> findAll(Filter filter, Pageable page) {
		if (filter.existCondition()) {
			return repository.findAll(filter, page).getContent();
		} else {
			return repository.findAll(page).getContent();
		}
	}

	@Override
	public Long count(Filter filter) {
		if (filter.existCondition()) {
			return repository.count(filter);
		} else {
			return repository.count();
		}
	}

	@Override
	public List<CartContent> getCustomerCartContent(Long customerId) {

		return repository.getCartContentByCustomerId(customerId);
	}

	@Override
	public CartContent save(CartContent cart) {
		return repository.saveAndFlush(cart);

	}

	@Override
	public Integer getTotalPriceCart(Long customerId) {
		List<CartContent> contentCartCustomer = getCustomerCartContent(customerId);
		Integer total = 0;
		for (CartContent cartContent : contentCartCustomer) {
			total = total + cartContent.getPrice();
		}
		return total;
	}
}
