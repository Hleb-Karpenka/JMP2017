package com.epam.training.shop.facades.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epam.training.shop.facades.CustomerFacade;
import com.epam.training.shop.facades.dto.CustomerDTO;
import com.epam.training.shop.facades.dto.LoginDTO;
import com.epam.training.shop.model.Customer;
import com.epam.training.shop.model.CustomerCredentials;
import com.epam.training.shop.model.Gender;
import com.epam.training.shop.model.UserRole;
import com.epam.training.shop.repository.filter.Filter;
import com.epam.training.shop.service.CustomerService;


@Service
public class CustomerFacadeImpl implements CustomerFacade
{
	@Autowired
	CustomerService customerService;

	@Override
	public CustomerCredentials getCustomerByCredentials(LoginDTO loginDTO)
	{
		return customerService.getCustomerByCredentials(loginDTO.getUserName(), loginDTO.getPassword());
	}

	@Override
	public Customer registerCustomer(CustomerDTO customerDTO)
	{
		return customerService.registerCustomer(convertToCustomerModel(customerDTO), convertToCustomerCredentials(customerDTO));
	}

	@Override
	public List<Customer> find(Filter filter)
	{
		return customerService.find(filter);
	}

	@Override
	public Collection<? extends String> resolveRoles(Long id)
	{
		return customerService.resolveRoles(id);
	}

	@Override
	public Boolean loginIsAvailable(String login)
	{
		return customerService.loginIsAvailable(login);
	}

	@Override
	public Boolean emailIsAvailable(String email)
	{
		return customerService.emailIsAvailable(email);
	}

	@Override
	public List<Customer> findAll(Filter filter, Pageable page)
	{
		return customerService.findAll(filter, page);
	}

	@Override
	public Page<Customer> findAll(Pageable pageable)
	{
		return customerService.findAll(pageable);
	}

	@Override
	public Long count(Filter filter)
	{
		return customerService.count(filter);
	}


	private Customer convertToCustomerModel(CustomerDTO customerDTO)
	{
		Customer customer = new Customer();
		customer.setAddress(customerDTO.getAddress());
		customer.setCity(customerDTO.getCity());
		customer.setCountry(customerDTO.getCountry());
		customer.setDateBirth(customerDTO.getDateBirth());
		customer.setEmail(customerDTO.getEmail());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setGender(customerDTO.getGender());
		customer.setPhoto(customerDTO.getPhoto());
		customer.setZipCode(customerDTO.getZipCode());
		customer.setGender(Gender.UNKNOWN);
		customer.setCreated(new Date());
		return customer;
	}

	private CustomerCredentials convertToCustomerCredentials(CustomerDTO customerDTO)
	{
		CustomerCredentials customerCredentials = new CustomerCredentials();
		customerCredentials.setRole(UserRole.customer);
		customerCredentials.setPassword(customerDTO.getPassword());
		customerCredentials.setLogin(customerDTO.getLogin());
		return customerCredentials;
	}

}
