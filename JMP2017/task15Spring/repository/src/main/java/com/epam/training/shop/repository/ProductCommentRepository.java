package com.epam.training.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.epam.training.shop.model.Product;
import com.epam.training.shop.model.ProductComment;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long>,  JpaSpecificationExecutor<ProductComment>{

    List<ProductComment> getByProductId(Long id);
    List<ProductComment> getByCustomerId(Long id);
	
}
