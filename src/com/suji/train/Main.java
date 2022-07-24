package com.suji.train;

import java.util.Scanner;
import java.util.Stack;

import com.suji.train.controller.Login.LoginController;
import com.suji.train.controller.Login.UserController;

public class Main {
	static Stack<Integer> pageNavigation=new Stack<Integer>();
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		char choice;
		System.out.println("******************************************************************");
		System.out.println("*WELCOME TO INDIAN RAILWAYS*");
		System.out.println("******************************************************************");
		do {
			System.out.println("Enter your Choice\n"
					+ "1.Login\n2.Sign Up\n3.Exit");
			choice=scanner.next().charAt(0);
			switch(choice)
			{
			case '1':
				LoginController.getExistingUserDetails();	
				break;
			case '2':

				UserController uController=new UserController();
				uController.addUser();
				System.out.println("User Account created Successfully\nLogin to see the menu");
				choice=1;
				break;
			case '3':
				System.out.println("Thank you!!!");
				System.exit(0);
				break;
			}
		}while(choice<=2);





		/*
		 * Train train=new Train(); System.out.println("Enter the From Station");
		 * train.setfStation(scanner.next());
		 * System.out.println("Enter the To Station");
		 * train.settStation(scanner.next());
		 * System.out.println("Enter the Train Name");
		 * train.setTrainName(scanner.next());
		 * System.out.println("Enter the Train Number");
		 * train.setTrainNumber(scanner.nextLong());
		 */

	}
}
