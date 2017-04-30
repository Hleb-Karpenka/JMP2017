package com.epam.training.shop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import com.epam.training.shop.model.Order;
import com.epam.training.shop.model.OrderContent;
import com.epam.training.shop.repository.filter.Filter;

public interface OrderService extends BasicService<Order, Long> {
	
	Order createOrder(Order order);

	List<OrderContent> getOrderContentById(Long id);

	List<Order> findAll(Filter filter, Pageable page);

	List<Order> findAll(Pageable page);

	Long count(Filter filter);

	List<OrderContent> findAllContent(Filter filter, Pageable page);

	Long countContent(Filter filter);

	OrderContent editContent(OrderContent orderContent, Integer value);

	Integer countOrderTotalPrice(Long orderId);

	void deleteContent(OrderContent orderContent);
}
