package com.example.register.util;

public class CustomerFieldValidator {
	
	private static final int MIN_EMAIL_LENGTH = 6;
	
	public static boolean isEmailValid(String email) {
		int length = email.length();
		
		return (length >= MIN_EMAIL_LENGTH) ? true : false;
	}

}
