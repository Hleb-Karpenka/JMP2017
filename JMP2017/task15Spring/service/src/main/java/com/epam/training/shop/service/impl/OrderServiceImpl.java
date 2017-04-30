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
import com.epam.training.shop.model.Order;
import com.epam.training.shop.model.OrderContent;
import com.epam.training.shop.model.Product;
import com.epam.training.shop.model.StatusOrder;
import com.epam.training.shop.repository.CartContentRepository;
import com.epam.training.shop.repository.OrderContentRepository;
import com.epam.training.shop.repository.OrderRepository;
import com.epam.training.shop.repository.ProductRepository;
import com.epam.training.shop.repository.filter.Filter;
import com.epam.training.shop.service.CustomerService;
import com.epam.training.shop.service.OrderService;
import com.epam.training.shop.service.exeption.ServiceException;

@Service
@Transactional
public class OrderServiceImpl extends BasicServiceImpl<Order, OrderRepository, Long> implements OrderService {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	MailService mail;
	@Autowired
	OrderContentRepository orderContentRepository;
	@Autowired
	CustomerService customerService;
	@Autowired
	CartContentRepository cartContentRepository;
	@Autowired
	ProductRepository productRepository;

	@Override
	public Order createOrder(Order order) {
		Customer customer = customerService.findOne(order.getCustomer().getId());
		order.setStartDate(new Date());
		order.setStatus(StatusOrder.Making);
		List<CartContent> cartContent = customer.getCartContent();
		if (cartContent.isEmpty()) {
			throw new ServiceException(String.format("Cart of customer has id: %s is empty", customer.getId()));
		}
		repository.save(order);
		transferFromCartToOrder(order, cartContent);
		order.setStatus(StatusOrder.Pending);
		List<OrderContent> orderContent = getOrderContentById(order.getId());
		//mail.sendOrderConfirmationMail(order);
		LOGGER.debug(String.format("Order %s has been created", order.getId()));
		return order;
	}

	
	private void transferFromCartToOrder(Order order, List<CartContent> cartContent) {
		Integer priceTotal = 0;
		for (CartContent item : cartContent) {
			OrderContent orderContent = new OrderContent();
			orderContent.setProduct(item.getProduct());
			orderContent.setAmount(item.getAmount());
			Integer price = orderContent.getProduct().getPrice() * orderContent.getAmount();
			orderContent.setPrice(price);
			orderContent.setOrder(order);
			changeProductData(item, orderContent);
			orderContentRepository.save(orderContent);
			priceTotal = priceTotal + price;
		}
		cartContentRepository.clearCustomerCartContent(order.getCustomer().getId());
	}

	private void changeProductData(CartContent item, OrderContent orderContent) {
		Product product = productRepository.findOne(item.getProduct().getId());
		Integer currentAvailable = product.getAvailable();
		product.setAvailable(currentAvailable - orderContent.getAmount());
		Integer currentCountOrder = product.getCountOrder() + orderContent.getAmount();
		product.setCountOrder(currentCountOrder++);
		productRepository.save(product);
		LOGGER.debug(
				String.format("Product %s was update in order %s", product.getId(), orderContent.getOrder().getId()));
	}
	@Override
	public List<OrderContent> getOrderContentById(Long id) {

		return repository.findOne(id).getOrderContent();
	}

	@Override
	public void delete(Long id) {
		LOGGER.info(String.format("Delete order id: ", id));
		Order order = repository.findOne(id);
		if (order == null) {
			LOGGER.info(String.format("Order id: %s not found", id));
		} else {
			StatusOrder statusOrder = order.getStatus();
			boolean deleteOrderCondition = statusOrder.equals(StatusOrder.Cancelled)
					|| statusOrder.equals(StatusOrder.Pending);
			if (deleteOrderCondition) {
				repository.delete(id);
				LOGGER.info(String.format("Order id: %s has been deleted", id));
			} else {
				throw new ServiceException("This order can not be deleted, cause - order has status confirmed");
			}
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
	public List<Order> findAll(Filter filter, Pageable page) {
		if (filter.existCondition()) {
			return repository.findAll(filter, page).getContent();
		} else {
			return repository.findAll(page).getContent();
		}
	}

	@Override
	public List<Order> findAll(Pageable page) {
		return repository.findAll(page).getContent();
	}

	@Override
	public List<OrderContent> findAllContent(Filter filter, Pageable page) {
		return orderContentRepository.findAll(filter, page).getContent();
	}

	@Override
	public Long countContent(Filter filter) {
		if (filter.existCondition()) {
			return orderContentRepository.count(filter);
		} else {
			return orderContentRepository.count();
		}
	}

	@Override
	public OrderContent editContent(OrderContent orderContent, Integer amount) {
		Product product = orderContent.getProduct();
		Integer currentOrderContentAmount = orderContent.getAmount();
		Integer currentAvailableProduct = product.getAvailable();
		Integer difference = amount - currentOrderContentAmount;
		if (difference > 0) {
			product.setAvailable(currentAvailableProduct - difference);
		} else {
			product.setAvailable(currentAvailableProduct - difference);
		}
		productRepository.saveAndFlush(product);
		LOGGER.debug(String.format("Amount product %s was changed, order %s", product.getId(),
				orderContent.getOrder().getId()));
		orderContent.setAmount(amount);
		orderContent.setPrice(orderContent.getProduct().getPrice() * amount);
		orderContent = orderContentRepository.saveAndFlush(orderContent);
		LOGGER.debug(String.format("Order content %s was changed, order %s", orderContent.getId(),
				orderContent.getOrder().getId()));
		Order order = repository.findOne(orderContent.getOrder().getId());
		countOrderTotalPrice(order.getId());
		return orderContent;
	}

	@Override
	public void deleteContent(OrderContent orderContent) {
		Product product = orderContent.getProduct();
		product.setAvailable(product.getAvailable() + orderContent.getAmount());
		productRepository.saveAndFlush(product);
		orderContentRepository.delete(orderContent.getId());
	}

	@Override
	public Integer countOrderTotalPrice(Long orderId) {
		Integer summ = 0;
		Order order = repository.findOne(orderId);
		List<OrderContent> listContent = order.getOrderContent();
		for (OrderContent content : listContent) {
			summ = summ + content.getPrice();
		}
		order.setTotalPrice(summ);
		repository.saveAndFlush(order);
		return summ;
	}

}
