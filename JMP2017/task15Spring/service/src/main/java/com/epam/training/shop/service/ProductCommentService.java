package com.epam.training.shop.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.epam.training.shop.model.ProductComment;
import com.epam.training.shop.repository.filter.Filter;

public interface ProductCommentService extends BasicService<ProductComment, Long> {
	
	List<ProductComment> findAll(Filter filter, Sort sort);

}
