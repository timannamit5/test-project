package com.example.register.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.register.beans.Customer;

@RestController
@RequestMapping("/api")
public class AppController {

	@PostMapping("/customer/register")
	public String registerCustomer(Customer customer) {
		return "";
	}
}
