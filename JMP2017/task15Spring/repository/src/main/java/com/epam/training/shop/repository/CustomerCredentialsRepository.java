package com.epam.training.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.epam.training.shop.model.Customer;
import com.epam.training.shop.model.CustomerCredentials;

public interface CustomerCredentialsRepository extends JpaRepository<CustomerCredentials, Long>, JpaSpecificationExecutor<CustomerCredentials> {
	CustomerCredentials findByLoginAndPassword(String login, String password);
	CustomerCredentials findByLogin(String login);
}
