package com.suji.train.controller.Login;

import java.util.Scanner;

import com.suji.train.authenticator.UserAuthenticator;
import com.suji.train.entity.User;
import com.suji.train.repository.UserRepository;
import com.suji.train.utility.LoginValidations;

public class UserController {
	public static String uName;

	public void addUser() {
		User user = new User();
		UserRepository uRepo = UserRepository.getInstance();
		UserAuthenticator uAuth = new UserAuthenticator();
		boolean isUserNameAlreadyTaken;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the User Name");
		uName = scanner.next();
		isUserNameAlreadyTaken = uRepo.isUserNamePresent(uName);
		while (isUserNameAlreadyTaken) {
			System.out.println("User Name already taken.\nPlease enter a valid user name");
			uName = scanner.next();
			isUserNameAlreadyTaken = uRepo.isUserNamePresent(uName);
		}
		user.setuName(uName);
		System.out.print(
				"Enter the password\n*Password should contain atleast one capital letter \n*Password should contain numbers and alphabets\n*Password should have maximum of 6 charachters\n");
		user.setPassword(scanner.next());
		boolean isValid = LoginValidations.isValidPassword(user.getPassword());
		while (!isValid) {
			System.out.println("Enter a valid password");
			user.setPassword(scanner.next());
			isValid = LoginValidations.isValidPassword(user.getPassword());
		}
		System.out.print("Enter the Phone Number");
		user.setPhoneNumber(scanner.nextLong());
		isValid = LoginValidations.isValidPhoneNumber(user.getPhoneNumber());
		while (!isValid) {
			System.out.println("Enter a valid PhoneNumber");
			user.setPhoneNumber(scanner.nextLong());
			isValid = LoginValidations.isValidPhoneNumber(user.getPhoneNumber());
		}
		System.out.println("Enter the Email Id");
		user.setEmailId(scanner.next());
		isValid = LoginValidations.isValidEmailId(user.getEmailId());
		while (!isValid) {
			System.out.println("Enter a valid Email Id");
			user.setEmailId(scanner.next());
			isValid = LoginValidations.isValidEmailId(user.getEmailId());

		}
		user.setCreationDate(System.currentTimeMillis());
		uRepo.add(user);

	}

	/*
	 * public void updateUser() { Scanner scanner=new Scanner(System.in);
	 * 
	 * System.out.println("Enter the user Name"); user.setuName(scanner.next());
	 * boolean isUserNameValid; isUserNameValid=uAuth.authenticate(user.getuName());
	 * while(!isUserNameValid) {
	 * System.out.println("User Name not found\nPlease enter a valid user name");
	 * user.setuName(scanner.next());
	 * isUserNameValid=uAuth.authenticate(user.getuName()); }
	 * 
	 * System.out.
	 * println("What you want to update?\n1.Password\n2.Phone Number\n3.Email Id");
	 * char choice=scanner.next().charAt(0); switch(choice) { case '1':
	 * System.out.println("Enter the new password"); String
	 * nPassword=scanner.next();
	 * 
	 * break; case '2': System.out.println(""); break; case '3': break; } }
	 */

}
