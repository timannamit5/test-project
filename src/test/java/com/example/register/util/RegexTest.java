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
public class RegexTest {

	@Mock
	Customer customer;
	
	@InjectMocks
	Regex regex = new Regex();
	
	@Test //valid email and valid password
	void validityTest1() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("abc@gmail.com", "password*",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE, null);
		assertEquals(regex.hasASpecialChar(customer.getPassword()), true);
		assertEquals(regex.isEmail(customer.getEmail()), true);
	}
	
	@Test //valid email and invalid password
	void validityTest2() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("abc@gmail.com", "password",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE, null);
		assertEquals(regex.hasASpecialChar(customer.getPassword()), true);
		assertEquals(regex.isEmail(customer.getEmail()), true);	}
	
	@Test //invalid email and valid password
	void validityTest3() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("abc.com", "password*",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE, null);
		assertEquals(regex.hasASpecialChar(customer.getPassword()), true);
		assertEquals(regex.isEmail(customer.getEmail()), true);
	}
	
	@Test //invalid email and invalid password
	void validityTest4() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("abc.com", "password",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE, null);
		assertEquals(regex.hasASpecialChar(customer.getPassword()), true);
		assertEquals(regex.isEmail(customer.getEmail()), true);
	}
	
	
	
	
	
	
}
