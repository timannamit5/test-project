package com.example.register.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.register.beans.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
}
