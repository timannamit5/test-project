package com.example.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.register.beans.Customer;
import com.example.register.dao.CustomerDAO;

@Service
public class RegistrationService {
	
	@Autowired
	CustomerDAO dao;
	
	public String insertCustomerToDB(Customer customer) {
		try{
			dao.insertCustomer(customer);
			return "Congratulations for registration"; 
		}catch (Exception e) {
			e.printStackTrace();
			return "Bad request";
		}
	}
	
	private String validateCustomerFields() {
		
	}

}
