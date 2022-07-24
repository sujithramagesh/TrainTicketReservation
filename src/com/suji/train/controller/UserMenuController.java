package com.suji.train.controller;

import java.util.Scanner;

public class UserMenuController {
	public static void getMenu()
	{
		int choice = 0;
		Scanner scanner=new Scanner(System.in);
		do {
		System.out.println("Enter the option");
		System.out.println("1.Book Tickets\n2.Cancel Tickets\n3.Print Tickets\n4.Search Train\n5.Logout");
		if(choice!=5)
			choice=scanner.nextInt();
		switch(choice)
		{
		case 1:
			BookingController.bookTickets();
			break;
		case 2:
			BookingController.cancelTicket();
			break;
		case 3:
			BookingController.showTicket(0);
			break;
		case 4:
			
			break;
		case 5:
			System.out.println("*************Thank you for visiting us!!!!!*********************");
			System.out.println("***********************BYE!!!***********************************");
			break;
		}
		if(choice!=5)
		{
		System.out.println("Do you want to go back to...\n1.User Menus\n2.Logout");
		choice=scanner.nextInt();
		if(choice==2)
			System.out.println("*************Thank you for visiting us!!!!!*********************");
		System.out.println("***********************BYE!!!***********************************");
		}
		}while(choice==1);
	}
}
