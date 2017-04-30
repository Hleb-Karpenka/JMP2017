package com.epam.training.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.training.shop.model.Category;

public interface CategoryRepositoryCustom {
	
	void addCategory (Category parent, Category child);

	

}
