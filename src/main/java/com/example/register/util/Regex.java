package com.example.register.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	public static final Pattern SPECIAL_CHAR_REGEX = Pattern.compile("[^a-zA-Z0-9]");

	public static boolean isEmail(String input) {
		Matcher matcher = EMAIL_REGEX.matcher(input);
		return matcher.find();
	}

	public static boolean hasASpecialChar(String input) {
		Matcher matcher = SPECIAL_CHAR_REGEX.matcher(input);
		return matcher.find();
	}

}
