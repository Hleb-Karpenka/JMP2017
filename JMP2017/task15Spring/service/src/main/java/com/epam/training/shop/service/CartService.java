package com.epam.training.shop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import com.epam.training.shop.model.CartContent;
import com.epam.training.shop.repository.filter.Filter;

public interface CartService extends BasicService<CartContent, Long>  {

	List<CartContent> getCustomerCartContent(Long customerId);

	Boolean addProductToCart(Long productId, Long customerId, Integer amount);

	void clearCustomerCartContent(Long id);

	public List<CartContent> findAll(Filter filter, Pageable page);

	public Long count(Filter filter);

	public Integer getTotalPriceCart(Long customerId);

}
