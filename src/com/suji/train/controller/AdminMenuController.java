package com.suji.train.controller;

import java.util.Scanner;

public class AdminMenuController {
	public void getMenus()
	{
		Scanner scanner=new Scanner(System.in);
		TrainController trainController=new TrainController();
		int choice;
		do {
			System.out.println("Enter your choice\n1.Train\n2.Station\n3.Logout");
			choice=scanner.nextInt();
			boolean lFlag= false;
			switch(choice)
			{
			case 1:
				do
				{
					System.out.println("Enter the choice\n1.Add Train\n2.Update Train\n3.Search Train \n4.Show All Train\n5.Back");
					choice=scanner.nextInt();
					switch(choice)
					{
					case 1:
						trainController.addtrain();
						break;
					case 2:
						
						break;
					case 3:
						trainController.getTrain();
						break;
					case 4:
						trainController.getAllTrain();
						break;
					case 5:
						lFlag=true;
						choice=2;
						break;

					}
					if(!lFlag)
					{
						System.out.println("Do you want to go to\n1.Train option\n2.Back");
						choice=scanner.nextInt();
					}
				}while(choice==1);
				break;
			case 2:
				do {
					lFlag=false;
				System.out.println("Enter the choice\n1.Add Station\n2.Delete Station\n"
						+ "3.Search Station\n4.Update Station\n5.Back");
				choice=scanner.nextInt();
				switch(choice)
				{
				case 1:

					break;
				case 2:

					break;
				case 3:

					break;
				case 4:
					break;
				case 5:
					lFlag=true;
					choice=2;
					break;
				}
				if(!lFlag)
				{
					System.out.println("Do you want to go to\n1.Station option\n2.Back");
					choice=scanner.nextInt();
				}
				}while(choice==1);
			break;
			case 3:
				System.out.println("*************Thank you for visiting us!!!!!*********************");
				System.out.println("***********************BYE!!!***********************************");
				break;
			}
		}while(choice!=3);
	}
}
