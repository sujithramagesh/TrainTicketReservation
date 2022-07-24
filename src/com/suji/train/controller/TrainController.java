package com.suji.train.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.suji.train.constants.CoachType;
import com.suji.train.entity.Coach;
import com.suji.train.entity.Train;
import com.suji.train.repository.TrainRepository;
import com.suji.train.repository.TrainRoutesRepository;
public class TrainController {
	
public void addtrain()

{
	TrainRepository tRepo=TrainRepository.getInstance();
	Train train=new Train();
	TrainRoutesRepository trRepo=TrainRoutesRepository.getInstance();
	Scanner scanner= new Scanner(System.in);
	HashMap<String,Integer> coachSeatMap=new HashMap<String,Integer>();
	System.out.print("Enter Train Number:");
	long tNumber=scanner.nextLong();
	scanner.nextLine();
	boolean isTrainNumberExist=tRepo.isTrainNumberExist(tNumber);
	while(isTrainNumberExist)
	{
		System.out.println("The Train Number already exist\n"
				+ "Please enter different Train number");
		System.out.print("Enter the Train number:");
		tNumber=scanner.nextLong();
		scanner.nextLine();
		isTrainNumberExist=tRepo.isTrainNumberExist(tNumber);
	}
	System.out.print("Enter Train Name:");
	String tName=scanner.nextLine();
	boolean isTrainNameExist=tRepo.isTrainNameExist(tName);
	while(isTrainNameExist)
	{
		System.out.println("The Train Number already exist\n"
				+ "Please enter different Train number");
		System.out.print("Enter the Train number:");
		tNumber=scanner.nextLong();
		scanner.nextLine();
		isTrainNameExist=tRepo.isTrainNameExist(tName);
	}
	train.setTrainName(tName);
	train.setTrainNumber(tNumber);
	System.out.print("Enter the from station code:");
	train.setfStation(scanner.next());
	System.out.print("Enter the to station code:");
	train.settStation(scanner.next());
	ArrayList<Integer> choice = new ArrayList<Integer>();
	System.out.println("Please select the station that are not in the route");
	LinkedList<String> sList=trRepo.getTrainRoute(train.getfStation(), train.gettStation());
	trRepo.showTrainRoute(sList);
	System.out.println("Please enter 0 to stop selecting");
	while(true)
	{
		int input=scanner.nextInt();
		if(input==0)
			break;
		choice.add(input);
	}
	train.setStationList(trRepo.removeStationFromTrainRoute(choice,sList));
	
	List<Coach> coachList=new ArrayList<Coach>();
	int cCount=0;
	System.out.println("Enter the Coach count");
	for(CoachType ctype:CoachType.values())
	{
		System.out.print(ctype.name()+": ");
		cCount=scanner.nextInt();
		for(int i=1;i<=cCount;i++)
		{
			Coach coach=new Coach(ctype.getCoachCode()+i,ctype);
			/* coachSeatMap.put(ctype.getCoachCode(), ctype.getSeatCount()); */
			coachList.add(coach);
			
		}
		train.setCoachList(coachList);
//		train.getCoach().put(ctype.name(),coachSeatMap);
		
	}
	
	tRepo.add(train);
	System.out.println("Record added successfully");
}
public void getTrain()
{
	
	TrainRepository tRepo=TrainRepository.getInstance();
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter the Train Number");
	long tNumber=scanner.nextLong();
	/*
	 * System.out.println("Enter the Train Name"); String tName=scanner.next();
	 */
	boolean isTrainNumberExist=tRepo.isTrainNumberExist(tNumber);
	while(!isTrainNumberExist)
	{
		System.out.println("");
		System.out.println("The Train name and number doesn't exist.\n"
				+ "Please enter the valid details");
		tNumber=scanner.nextLong();
		scanner.nextLine();
		//tName=scanner.next();
		isTrainNumberExist=tRepo.isTrainNumberExist(tNumber);
	}
	showTrainDetails(tRepo.get(tNumber));
	
}
public void deleteTrainDetails()
{
	
}
public void showTrainDetails(Train train)
{
	TrainRepository tRepo=TrainRepository.getInstance();
	System.out.print("Train Number     : "+train.getTrainNumber());
	System.out.println("\t\tTrain Name       : "+train.getTrainName());
	System.out.print("From Station     : "+train.getfStation());
	System.out.println("\t\t\tTo Station       : "+train.gettStation());
	System.out.println("Train Station List");
	tRepo.showList(train.getStationList());
	System.out.println("Available Coaches");
	System.out.println("***********************************");
	System.out.println("Coach type |Coach Name | Seat Count");
	tRepo.showCoachList(train.getCoachList());
	System.out.println("***********************************");
	//tRepo.showMap(train.getCoach());
	
}
public void getAllTrain() {
	TrainRepository tRepo=TrainRepository.getInstance();
	List<Train> train=tRepo.get();
	for(Train trainIt:train)
	{
		showTrainDetails(trainIt);
	}
}
}
