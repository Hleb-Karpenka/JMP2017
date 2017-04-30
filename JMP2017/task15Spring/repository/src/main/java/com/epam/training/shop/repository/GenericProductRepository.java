package com.epam.training.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.epam.training.shop.model.Product;

public interface GenericProductRepository<T extends Product> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}
