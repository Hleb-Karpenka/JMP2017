package com.epam.training.shop.facades.dto;

import com.epam.training.shop.model.Gender;

import java.util.Date;


/**
 * Created by EPAM on 2017-02-27.
 */
public class CustomerDTO
{
	private String login;
	private String password;
	private String confirmationPassword;
	private String firstName;
	private String lastName;
	private String email;
	private Date created;
	private Date dateBirth;
	private Gender gender;
	private String country;
	private String city;
	private String address;
	private String zipCode;
	private byte[] photo;

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getCreated()
	{
		return created;
	}

	public void setCreated(Date created)
	{
		this.created = created;
	}

	public Date getDateBirth()
	{
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth)
	{
		this.dateBirth = dateBirth;
	}

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public byte[] getPhoto()
	{
		return photo;
	}

	public void setPhoto(byte[] photo)
	{
		this.photo = photo;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getConfirmationPassword()
	{
		return confirmationPassword;
	}

	public void setConfirmationPassword(String confirmationPassword)
	{
		this.confirmationPassword = confirmationPassword;
	}
}
