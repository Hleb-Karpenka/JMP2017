package com.epam.training.shop.service;

import java.util.List;

import com.epam.training.shop.model.Category;

public interface CategoryService  extends BasicService<Category, Long>{

	Category findRoot();

	List<Category> findByChildren(Category cat);

}
