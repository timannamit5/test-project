package com.example.register.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class CustomerFieldValidator {

	private static final int MIN_EMAIL_LENGTH = 6;
	private static final int MIN_PASSWORD_LENGTH = 6;

	public static boolean isEmailValid(String email) {
		int length = email.length();
		return (length >= MIN_EMAIL_LENGTH && Regex.isEmail(email));
	}

	public static boolean isPasswordValid(String password) {
		int length = password.length();
		return (length >= MIN_PASSWORD_LENGTH && Regex.hasASpecialChar(password));
	}

	public static boolean isAtleastEighteen(Date dob) {
		LocalDate birthday = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate today = LocalDate.now();

		Period period = Period.between(birthday, today);
		int age = period.getYears();

		return (age >= 18);
	}

	public static boolean isGenderValid(Gender gender) {
		return gender.equals(Gender.FEMALE) || gender.equals(Gender.MALE) || gender.equals(Gender.TRANSGENDER);
	}
	
	public static boolean isNameEntered(String name) {
		return !name.isEmpty();
	}

}
