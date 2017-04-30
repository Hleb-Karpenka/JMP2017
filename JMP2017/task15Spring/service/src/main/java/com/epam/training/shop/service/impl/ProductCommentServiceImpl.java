package com.epam.training.shop.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.epam.training.shop.model.Product;
import com.epam.training.shop.model.ProductComment;
import com.epam.training.shop.repository.ProductCommentRepository;
import com.epam.training.shop.repository.filter.Filter;
import com.epam.training.shop.service.ProductCommentService;

public class ProductCommentServiceImpl extends BasicServiceImpl<ProductComment, ProductCommentRepository, Long>
		implements ProductCommentService {

	@Override
	public List<ProductComment> findAll(Filter filter, Sort sort) {
		return repository.findAll(filter, sort);
	}

}
