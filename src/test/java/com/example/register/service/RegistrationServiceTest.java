package com.example.register.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.register.beans.CreditCard;
import com.example.register.beans.Customer;
import com.example.register.dao.CustomerDAO;
import com.example.register.util.Gender;

@ExtendWith(MockitoExtension.class)
public class RegistrationServiceTest {
	
	//@Mock
	//CustomerDAO cDao;
	
	@Mock
	Customer customer;
	
	@InjectMocks
	RegistrationService regSer;
	
	@Test //invalid email
	void validityTest() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("p.com", "password*",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE, null);
		List<String> errorList = regSer.validateCustomerFields(customer);
		assertEquals(errorList.isEmpty(),true );
	}
	
	@Test //Invalid password
	void validityTest1() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("p.com", "password",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE, null);
		List<String> errorList = regSer.validateCustomerFields(customer);
		assertEquals(errorList.isEmpty(),true );
	}
	
	//Under 18
	@Test 
	void validityTest2() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1915");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("p.com", "password",new CreditCard(1234, 122, expDate), "first name", "last name", date, Gender.MALE, null);
		List<String> errorList = regSer.validateCustomerFields(customer);
		assertEquals(errorList.isEmpty(),true );
	}

	
//	@Test //Invalid Gender
//	void validityTest3() throws ParseException
//	{
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//		Date date = sdf.parse("12-12-1995");
//		Date expDate = sdf.parse("12-12-2021");
//		customer = new Customer("p.com", "password",new CreditCard(1234, 122, expDate), "first name", "last name", date, new Gender none, null);
//		List<String> errorList = regSer.validateCustomerFields(customer);
//		assertEquals(errorList.isEmpty(),true );
//	}

	
	@Test //No first name
	void validityTest4() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse("12-12-1995");
		Date expDate = sdf.parse("12-12-2021");
		customer = new Customer("p.com", "password",new CreditCard(1234, 122, expDate), "", "last name", date, Gender.MALE, null);
		List<String> errorList = regSer.validateCustomerFields(customer);
		assertEquals(errorList.isEmpty(),true );
	}

}
