package com.suji.train.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidations {
	public static boolean isValidPassword(String password)
	{

		String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+".{6,6}$";
		Pattern p=Pattern.compile(regex);
		if(password==null)
		{
			return false;
		}
		Matcher m=p.matcher(password);
		return m.matches();
	}
	public static boolean isValidPhoneNumber(long phoneNumber)
	{

		String regex = "^[6-9]\\d{9}$";
		Pattern p=Pattern.compile(regex);
		if(phoneNumber==0)
		{
			return false;
		}
		Matcher m=p.matcher(Long.toString(phoneNumber));
		return m.matches();
	}
	public static boolean isValidEmailId(String emailId)
	{

		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		Pattern p=Pattern.compile(regex);
		if(emailId==null)
		{
			return false;
		}
		Matcher m=p.matcher(emailId);
		return m.matches();
	}
}
