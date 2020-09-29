package com.example.register.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.register.beans.Customer;
import com.example.register.repo.CustomerRepository;

@Component
public class CustomerDAO {

	@Autowired
	CustomerRepository repo;
	
	public Customer insertCustomer(Customer customer) {
		return this.repo.insert(customer);
	}
}
