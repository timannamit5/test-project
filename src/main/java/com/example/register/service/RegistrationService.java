package com.example.register.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.register.beans.Customer;
import com.example.register.dao.CustomerDAO;
import com.example.register.util.CustomerFieldValidator;
import com.example.register.util.Gender;

@Service
public class RegistrationService {
	
	@Autowired
	CustomerDAO dao;
	
	/**
	 * Validate and then insert user to db;
	 * @param customer
	 * @return list acknowledgement (String)
	 */
	public String insertCustomerToDB(Customer customer) {
		List<String> errors = this.validateCustomerFields(customer);
		if(errors.isEmpty()) {
			try{
				dao.insertCustomer(customer);
				return "Congratulations for registration"; 
			}catch (Exception e) {
				e.printStackTrace();
				return "Bad request";
			}
		}else {
			String response = "Please validate the following data ";
			for(String error: errors) {
				response += "\n" + error;
			}
			return response;
		}
	}
	
	/**
	 * 
	 * @param customer
	 * @return list of errors
	 */
	public List<String> validateCustomerFields(Customer customer) {
		List<String> errorList = new ArrayList<>();
		String email = customer.getEmail();
		String password = customer.getPassword();
		String firstName = customer.getFirstName();
		Date dob = customer.getDateOfBirth();
		Gender gender = customer.getGender();
		//credit card validation remains
		
		if(!CustomerFieldValidator.isEmailValid(email)) {
			errorList.add("Email is badly formatted");
		}
		
		if(!CustomerFieldValidator.isPasswordValid(password)) {
			errorList.add("Password should be minimum 6 characters long and should have at least a special character");
		}
		
		if(!CustomerFieldValidator.isAtleastEighteen(dob)) {
			errorList.add("You must be atleast 18 years old");
		}
		
		if(!CustomerFieldValidator.isGenderValid(gender)) {
			errorList.add("Please select gender from the given options");
		}
		
		if(!CustomerFieldValidator.isNameEntered(firstName)) {
			errorList.add("First Name can't be empty");
		}
		
		return errorList;
		
		
	}

}
