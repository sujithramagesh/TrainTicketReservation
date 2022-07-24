package com.suji.train.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.suji.train.constants.CoachType;
import com.suji.train.constants.StationNames;
import com.suji.train.entity.Coach;
import com.suji.train.entity.PassengerSeats;
import com.suji.train.entity.Train;
import com.suji.train.entity.TrainBooking;
import com.suji.train.entity.User;
import com.suji.train.entity.UserBooking;
import com.suji.train.repository.TrainBookingRepository;
import com.suji.train.repository.TrainRepository;
import com.suji.train.repository.UserBookingRepository;
import com.suji.train.repository.UserRepository;

public class BookingController {
	public static void bookTickets()
	{

		User user=new User();
		//UserRepository uRepo=new UserRepository();
		UserBooking uBooking=new UserBooking();
		TrainRepository tRepo=TrainRepository.getInstance();
		TrainBooking trainBooking=new TrainBooking();
		HashMap<Long,UserBooking> userPnrBookingHashMap=new HashMap<Long,UserBooking>();
		//		HashMap<Long,HashMap<String,HashMap<Long,UserBooking>>> userPnrBookingHashMap=new HashMap<Long,HashMap<String,HashMap<Long,UserBooking>>>();
		//HashMap<String,HashMap<Long,UserBooking>> userDateBookingHashMap=new HashMap<String,HashMap<Long,UserBooking>>();
		//HashMap<Long,UserBooking> userTrainBookingHashMap=new HashMap<Long,UserBooking>();
		TrainBookingRepository tbRepo=TrainBookingRepository.getInstance();
		HashMap<String,HashMap<Long,TrainBooking>> trainBookingHashMap=new HashMap<String, HashMap<Long,TrainBooking>>();

		ArrayList<PassengerSeats> pSeatsList=new ArrayList<PassengerSeats>();
		UserBookingRepository ubRepo= UserBookingRepository.getInstance();
		long pnrNumber=ubRepo.getPNRNumber()+1;
		Scanner scanner=new Scanner(System.in);
		StationNames.showStationNames();
		System.out.print("Choose From station Code:");
		String fStation=scanner.next();
		System.out.print("Choose to station Code:");
		String tStation=scanner.next();
		System.out.print("Date(dd/mm/yyyy):");
		String tDate=scanner.next();
		boolean isValidDate=false,isValidDateFormat=true;
		do {
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date d = null;
			do {
				isValidDateFormat=true;
				try {
					d = sdf.parse(tDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("Please give date in proper format(dd/MM/yyyy)");
					isValidDateFormat=false;
					tDate=scanner.next();
				}


			}while(!isValidDateFormat);
			Date today=new Date();
			long dateDiff=d.getTime()-today.getTime();
			if(dateDiff<0)
			{
				System.out.println("Cannot give a past date");
				System.out.println("Please enter a valid date");
				tDate=scanner.next();
			}
			else if(dateDiff/(1000*60*60*60*24)>60)
			{
				System.out.println("You can book tickets only 60 days prior to journey");
				tDate=scanner.next();
			}
			else
			{
				isValidDate=true;
			}
		}while(!isValidDate);
		List<TrainBooking> trainBookingList=tbRepo.getByDate(tDate);
		HashMap<Long,TrainBooking> trainNumberBookingMap=new HashMap<Long, TrainBooking>();
		if(trainBookingList.size()!=0)
		{
			for(TrainBooking trainBookingIterator:trainBookingList)
			{
				trainNumberBookingMap.put(trainBookingIterator.getTrainNumber(), trainBookingIterator);
				trainBookingHashMap.put(trainBookingIterator.getbDate(), trainNumberBookingMap);
			}
		}
		int index=1,option;
		HashMap<String, HashMap<String, Integer>> coachRemainingSeatMap=new HashMap<String, HashMap<String,Integer>>();
		System.out.println("***************************************************************");
		System.out.println("SNo  |Train Number | Train Name     | S | SL | AC3 | AC2 | AC1 ");
		System.out.println("***************************************************************");
		List<Train> trainList=tRepo.getTrains(fStation,tStation);
		for (Train train : trainList) {

			System.out.print(index+"    | "+train.getTrainNumber()+"\t   |"+train.getTrainName()+" \t|");
			HashMap<String,Integer> seatMap= tRepo.getTotalSeats(train);
			TrainBooking trainBookingbyDate=trainNumberBookingMap.get(train.getTrainNumber());
			if(trainBookingbyDate==null)
			{
				for(CoachType cTypeVal:CoachType.values())
				{
					System.out.print(seatMap.get(cTypeVal.name())+"  |");
				}
			}
			else
			{

				for(String s : new String[]{"S","SL", "AC3", "AC2", "AC1"})
				{
					int sum=0;
					for(int i:trainBookingbyDate.getCoachRemainingSeatMap().get(s).values())
					{
						sum+=i;
					}
					System.out.print(sum+"  |");
				}
			}
			index++;
			System.out.println();
		}
		System.out.println("***************************************************************");
		System.out.print("Select the train:");
		option=scanner.nextInt();
		scanner.nextLine();
		Train train=trainList.get(option-1);
		long trainNumber=train.getTrainNumber();


		if(!trainBookingHashMap.containsKey(tDate))//::TODO  Need to check train
		{
			trainBooking.setbDate(tDate);
			trainBooking.setTrainName(train.getTrainName());
			trainBooking.setTrainNumber(train.getTrainNumber());
			trainBooking.setfStation(train.getfStation());
			trainBooking.settStation(train.gettStation());

			List<Coach> coachList=train.getCoachList();
			for(Coach coach:coachList) {
				if(!coachRemainingSeatMap.containsKey(coach.getCoachType())) {
					coachRemainingSeatMap.put(coach.getCoachType(), new HashMap<String, Integer>());
				}
				coachRemainingSeatMap.get(coach.getCoachType()).put(coach.getCoachCode(), coach.getSeatCount());
			}

			trainNumberBookingMap.put(trainNumber, trainBooking);
			trainBooking.setCoachRemainingSeatMap(coachRemainingSeatMap);
			trainBookingHashMap.put(tDate, trainNumberBookingMap);
		}
		trainBooking=trainBookingHashMap.get(tDate).get(trainNumber);

		index=1;
		for(CoachType cTypeVal:CoachType.values())
		{
			if(coachRemainingSeatMap.containsKey(cTypeVal.name()))
			{

			}
			System.out.println(index+"."+cTypeVal+"-");
			index++;
		}
		System.out.print("Please select your CoachType:");
		option=scanner.nextInt();
		scanner.nextLine();
		CoachType coachType=CoachType.getByIndex(option-1);
		System.out.print("Enter the number of seats:");
		int nOfSeats=scanner.nextInt();
		scanner.nextLine();
		System.out.println("------------------");
		System.out.println("Enter Seat Details");
		System.out.println("-------------------");
		for(int i=0;i<nOfSeats;i++)
		{
			PassengerSeats pSeats=new PassengerSeats();
			/* pSeats.setCoachType(coachType.name()); */
			System.out.println("Seat "+(i+1));
			System.out.print("Passenger Name:");
			String pName=scanner.nextLine();
			pSeats.setpName(pName);
			System.out.print("Passenger Age :");
			int pAge=scanner.nextInt();
			scanner.nextLine();
			pSeats.setpAge(pAge);
			System.out.print("Passenger Gender(M/F/T):");
			char pGender=scanner.next().charAt(0);
			scanner.nextLine();
			pSeats.setpGender(pGender);
			tbRepo.getSeatsForPassenger(pSeats,coachType,trainBooking);
			pSeatsList.add(pSeats);
		}

		//uBooking.setuName(User.getuName());
		uBooking.setTdate(tDate);
		uBooking.setfStation(fStation);
		uBooking.settStation(tStation);
		uBooking.setNoOfSeats(nOfSeats);
		uBooking.setTrainNumber(trainNumber);
		uBooking.setPnrNumber(pnrNumber);
		uBooking.setCoachType(coachType.name());
		uBooking.setpSeatsArrayList(pSeatsList);

		/*
		 * userTrainBookingHashMap.put(uBooking.getTrainNumber(), uBooking);
		 * userDateBookingHashMap.put(uBooking.getTdate(), userTrainBookingHashMap);
		 */
		userPnrBookingHashMap.put(uBooking.getPnrNumber(),uBooking);
		uBooking.setFare(uBooking.generateFare()*nOfSeats);
		tbRepo.add(trainBooking);
		ubRepo.add(uBooking);
		System.out.println("Ticket booked successfully");
		System.out.println("Your PNR Number is:"+uBooking.getPnrNumber());
		System.out.println("Travel Fare:"+uBooking.getFare());
		System.out.println("To View Ticket");
		showTicket(uBooking.getPnrNumber());
	}

	public static void showTicket(long pnrNumber)
	{
		UserBookingRepository ubRepo = UserBookingRepository.getInstance();
		UserBooking userBooking=new UserBooking();
		if(pnrNumber==0)
		{
			Scanner scanner=new Scanner(System.in);
			System.out.print("Enter the PNR Number:");
			pnrNumber=scanner.nextLong();
		}
		userBooking=ubRepo.get(pnrNumber);
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t\t\tJourney Cum Reservation Ticket");
		System.out.println();
		System.out.printf("%-7s %s\n",userBooking.getCoachType(),userBooking.getfStation(),userBooking.gettStation());
		System.out.println("------------------------------------------------------------------");
		System.out.println("\tCoach\tSeat\tBerth\tSex\tAge");
		System.out.println("------------------------------------------------------------------");
		ubRepo.showPassengerdetails(userBooking.getpSeatsArrayList());
		System.out.println("Total Fare ");
		System.out.println(userBooking.getFare());
		System.out.println("------------------------------------------------------------------");
		System.out.println();
		System.out.println();

	}
	public static void cancelTicket() {
		UserBookingRepository ubRepo = UserBookingRepository.getInstance();
		TrainBookingRepository tbRepository=TrainBookingRepository.getInstance();
		TrainBooking trainBooking=new TrainBooking();
		UserBooking userBooking=new UserBooking();
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the PNR Number:");
		long pnrNumber=scanner.nextLong();
		userBooking=ubRepo.get(pnrNumber);
		showTicket(pnrNumber);
		Scanner sc=new Scanner(System.in);
		System.out.println("Are you sure you want to cancel Ticket?\n1.Yes\n2.No");
		String choice=sc.nextLine();
		if(choice.length()==1&&Character.isDigit(choice.charAt(0)))
		{
			switch(choice)
			{
			case "1":
				List<TrainBooking> trainBookingList=tbRepository.getByDate(userBooking.getTdate());
				for(TrainBooking tList:trainBookingList)
				{
					if(tList.getTrainNumber()==userBooking.getTrainNumber())
					{
						for(PassengerSeats pList:userBooking.getpSeatsArrayList())
						{
							for(Map.Entry<String, HashMap<String,Integer>> outMap:tList.getCoachRemainingSeatMap().entrySet())
							{
								for(Map.Entry<String, Integer> mapEntry:outMap.getValue().entrySet())
								{
									if(mapEntry.getKey().equals(pList.getCoachCode()))
									{
										outMap.getValue().put(pList.getCoachCode(), mapEntry.getValue()+1);
									}
								}
							}
						}
					}
				}
				break;
			case "2":
				break;

			}
		}



	}

}
