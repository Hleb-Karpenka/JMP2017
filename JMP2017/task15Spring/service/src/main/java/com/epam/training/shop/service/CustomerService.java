package com.epam.training.shop.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.epam.training.shop.model.Customer;
import com.epam.training.shop.model.CustomerCredentials;
import com.epam.training.shop.repository.filter.CustomerFilter;
import com.epam.training.shop.repository.filter.Filter;

public interface CustomerService extends BasicService<Customer, Long> {

	CustomerCredentials getCustomerByCredentials(String login, String password);

	Customer registerCustomer(Customer customer, CustomerCredentials customerCredentials);

	List<Customer> find(Filter filter);

	Collection<? extends String> resolveRoles(Long id);

	Boolean loginIsAvailable(String login);

	Boolean emailIsAvailable(String email);

	public List<Customer> findAll(Filter filter, Pageable page);

	Page<Customer> findAll(Pageable pageable);

	public Long count(Filter filter);

	CustomerCredentials findByLogin(String login);
}
