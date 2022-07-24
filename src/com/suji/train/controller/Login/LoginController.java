package com.suji.train.controller.Login;
import java.util.Scanner;
import com.suji.train.authenticator.UserAuthenticator;
import com.suji.train.controller.AdminMenuController;
import com.suji.train.controller.UserMenuController;
import com.suji.train.entity.User;
public class LoginController {
	

	public static void getExistingUserDetails()

	{
		 String uName;
		 AdminMenuController adminController=new AdminMenuController();
		UserAuthenticator uAuth=new UserAuthenticator();
		User user=new User();
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the username:");
		uName=scanner.next();
		boolean isUserNameValid,isPasswordValid;
		isUserNameValid=uAuth.authenticate(uName);
		while(!isUserNameValid) {
			System.out.print("User Name not found\nPlease enter a valid user name:");
			uName=scanner.next();
			isUserNameValid=uAuth.authenticate(uName);
		}

		System.out.print("Enter the password :");
		String password=scanner.next();
		isPasswordValid=uAuth.authenticate(uName,password);
		while(!isPasswordValid) {
			System.out.print("Password is incorrect\nPlease enter the correct password:");
			password=scanner.next();
			isPasswordValid=uAuth.authenticate(uName,password);
		}
		System.out.println("*********Logged in successfully*********");
		if(uName.equalsIgnoreCase("admin"))
		{
			adminController.getMenus();
		}
		else
		{
			UserMenuController.getMenu();
		}
	}
}
