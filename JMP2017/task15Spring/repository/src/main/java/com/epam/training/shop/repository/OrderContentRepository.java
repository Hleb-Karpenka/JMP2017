package com.epam.training.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.epam.training.shop.model.Order;
import com.epam.training.shop.model.OrderContent;
import com.epam.training.shop.model.Product;

public interface OrderContentRepository extends JpaRepository<OrderContent, Long>,  JpaSpecificationExecutor<OrderContent> {

	List<Order> findByProductId(Long productId);
}
