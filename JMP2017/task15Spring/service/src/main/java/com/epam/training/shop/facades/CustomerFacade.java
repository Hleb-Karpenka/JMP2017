package com.epam.training.shop.facades;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.epam.training.shop.facades.dto.CustomerDTO;
import com.epam.training.shop.facades.dto.LoginDTO;
import com.epam.training.shop.model.Customer;
import com.epam.training.shop.model.CustomerCredentials;
import com.epam.training.shop.repository.filter.Filter;


public interface CustomerFacade
{
	CustomerCredentials getCustomerByCredentials(LoginDTO loginDTO);

	Customer registerCustomer(CustomerDTO customerDTO);

	List<Customer> find(Filter filter);

	Collection<? extends String> resolveRoles(Long id);

	Boolean loginIsAvailable(String login);

	Boolean emailIsAvailable(String email);

	public List<Customer> findAll(Filter filter, Pageable page);

	Page<Customer> findAll(Pageable pageable);

	public Long count(Filter filter);
}
