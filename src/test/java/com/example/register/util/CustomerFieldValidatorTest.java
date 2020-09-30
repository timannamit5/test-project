package com.example.register.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.register.beans.CreditCard;
import com.example.register.beans.Customer;

@ExtendWith(MockitoExtension.class)
public class CustomerFieldValidatorTest {
	
	@InjectMocks
	CustomerFieldValidator cValidator = new CustomerFieldValidator();
	
	//@Mock // Here we need to interact with the Data console : the console which will access data from the db. 
	// The data model can be mocked using the @Mock. 
	@Mock
	Customer customer;

	//valid password and valid id
	@Test
	void validityTest1() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("abc@gmail.com", "password*",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE, null);
		assertEquals(cValidator.isAtleastEighteen(customer.getDateOfBirth()),true );
		assertEquals(cValidator.isEmailValid(customer.getEmail()),true) ;
		assertEquals((cValidator.isPasswordValid(customer.getPassword())), true);
	}
	
	//invlaid password
	@Test
	void validityTest2() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("abc@gmail.com", "password",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE, null);
		assertEquals(cValidator.isAtleastEighteen(customer.getDateOfBirth()),true );
		assertEquals(cValidator.isEmailValid(customer.getEmail()),true) ;
		assertEquals((cValidator.isPasswordValid(customer.getPassword())), true);	}
	
	//invalid id
	@Test
	void validityTest3() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("df", "password*",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE, null);
		assertEquals(cValidator.isAtleastEighteen(customer.getDateOfBirth()),true );
		assertEquals(cValidator.isEmailValid(customer.getEmail()),true) ;
		assertEquals((cValidator.isPasswordValid(customer.getPassword())), true);	}
	
	//invalid date of birth
	@Test
	void validityTest4() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-2015");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("abc@gmail.com", "password*",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE, null);
		assertEquals(cValidator.isAtleastEighteen(customer.getDateOfBirth()),true );
		assertEquals(cValidator.isEmailValid(customer.getEmail()),true) ;
		assertEquals((cValidator.isPasswordValid(customer.getPassword())), true);	}

}
