package com.epam.training.shop.storefront.validator;

import com.epam.training.shop.service.CustomerService;
import com.epam.training.shop.facades.dto.CustomerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class CustomerCrDTOValidation implements Validator
{

	@Autowired
	private CustomerService customerService;

	@Override
	public boolean supports(Class<?> aClass)
	{
		return CustomerDTO.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors)
	{

		CustomerDTO customerForm = (CustomerDTO) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "validation.NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "validation.NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "validation.NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "validation.NotEmpty");

		if (customerForm.getLogin().length() < 6 || customerForm.getLogin().length() > 32)
		{
			errors.rejectValue("login", "validation.Size.userForm.username");
		}
		if (!customerService.loginIsAvailable(customerForm.getLogin()))
		{
			errors.rejectValue("login", "validation.Duplicate.userForm.username");
		}

		if (!customerService.emailIsAvailable(customerForm.getEmail())) {
			errors.rejectValue("email", "validation.Duplicate.userForm.email");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validation.NotEmpty");
		if (customerForm.getPassword().length() < 8 || customerForm.getPassword().length() > 32)
		{
			errors.rejectValue("password", "validation.Size.userForm.password");
		}

		if (!customerForm.getConfirmationPassword().equals(customerForm.getPassword()))
		{
			errors.rejectValue("confirmationPassword", "validation.Diff.userForm.passwordConfirm");
		}
	}
}