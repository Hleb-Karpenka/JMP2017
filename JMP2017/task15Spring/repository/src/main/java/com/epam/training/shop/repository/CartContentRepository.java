package com.epam.training.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.epam.training.shop.model.CartContent;

public interface CartContentRepository extends JpaRepository<CartContent, Long>, JpaSpecificationExecutor<CartContent>{
	
	@Modifying
	@Query ("delete from CartContent  where customer.id=:param")
	void clearCustomerCartContent(@Param("param")Long id);
	
	@Modifying
	@Query ("FROM CartContent  WHERE customer.id=:param")   
	List<CartContent> getCartContentByCustomerId(@Param("param")Long id);


}
