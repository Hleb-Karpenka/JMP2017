package com.epam.training.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.training.shop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category findByName(String name);

	List<Category> findByParentIs(Category cat);

	Category findByParentIsNull();

	void delete(Category entity);

}
