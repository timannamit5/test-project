package com.example.register.beans;

import java.util.Date;

import com.example.register.util.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
	
	private String email;
	private String password;
	private CreditCard creditCard;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Gender gender;
	private Boolean status;
	

}
