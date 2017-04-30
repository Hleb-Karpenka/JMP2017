package com.epam.training.shop.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.shop.model.Category;
import com.epam.training.shop.repository.CategoryRepository;
import com.epam.training.shop.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl extends BasicServiceImpl<Category, CategoryRepository, Long>
		implements CategoryService {

	private static Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

	@Override
	public Category findRoot() {
		Category root = repository.findByParentIsNull();
		if (root == null) {
			LOGGER.debug("No found any rootes");
		}
		return root;
	}

	@Override
	public List<Category> findByChildren(Category cat) {
		LOGGER.debug("Find child categories in " + cat);
		List<Category> childrenList = repository.findByParentIs(cat);
		if (childrenList.isEmpty()) {
			LOGGER.debug("No Found child categories in " + cat);
		}
		return childrenList;
	}
}
