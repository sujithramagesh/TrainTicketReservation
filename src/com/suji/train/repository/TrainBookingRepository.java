package com.suji.train.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.suji.train.constants.CoachType;
import com.suji.train.entity.PassengerSeats;
import com.suji.train.entity.TrainBooking;

public class TrainBookingRepository extends AbstractRepository<TrainBooking> {

	private static TrainBookingRepository tbRepo;
	private TrainBookingRepository() {
		super(TrainBooking.class.getSimpleName());
		loadFromFile();
	}
	public static TrainBookingRepository getInstance()
	{
		if(tbRepo==null)
		{
			tbRepo=new TrainBookingRepository();
		}
		return tbRepo;
	}
	public void getSeatsForPassenger(PassengerSeats pSeats,CoachType cType,TrainBooking trainBooking)
	{
		boolean allTikcetsBooked = false;
		String coachCode;int aSeat,seatNo = 0;String seatLegend;
		HashMap<String,HashMap<String,Integer>> coachRemainingSeatMap=trainBooking.getCoachRemainingSeatMap();
		for(Map.Entry<String, HashMap<String,Integer>> oEntry:coachRemainingSeatMap.entrySet()){		
			if(oEntry.getKey().equals(cType.name())){
				for(Map.Entry<String, Integer> iEntry:oEntry.getValue().entrySet()){
					if(iEntry.getValue()!=0) {
						
						aSeat=iEntry.getValue();
							switch(cType){
							case SL:
								seatNo=CoachType.SL.getSeatCount()-aSeat+1;
								break;
							case S:
								seatNo=CoachType.S.getSeatCount()-aSeat+1;
								break;
							case AC1:
								seatNo=CoachType.AC1.getSeatCount()-aSeat+1;
								break;
							case AC2:
								seatNo=CoachType.AC2.getSeatCount()-aSeat+1;
								break;
							case AC3:
								seatNo=CoachType.AC3.getSeatCount()-aSeat+1;
								break;
							}
							oEntry.getValue().put(iEntry.getKey(), aSeat-1);
							seatLegend=getSeatLegend(seatNo, cType.name());
							//iEntry.setValue(aSeat);
							pSeats.setSeatNo(seatNo);
							pSeats.setSeatLegend(seatLegend);
							pSeats.setCoachCode(iEntry.getKey());
							//pSeats.setCoachType(cType.name());
							pSeats.setStatus("CNF");
							allTikcetsBooked = true;
							break;
						}
					}
					if(allTikcetsBooked)
					{
						break;
					}
				}
			}
			
		}


	public String getSeatLegend(int seatNo,String coachType)
	{
		int lSeatNo;String seatLegend = null;
		if(coachType.equals(CoachType.S.name())) {
			lSeatNo=seatNo%12;
			if(lSeatNo==0||lSeatNo==1||lSeatNo==6||lSeatNo==7)
				seatLegend="WS";			
			else if(lSeatNo==2||lSeatNo==5||lSeatNo==8||lSeatNo==11)
				seatLegend="MS";
			else if(lSeatNo==3||lSeatNo==4||lSeatNo==9||lSeatNo==10)
				seatLegend="AS";
		}
		else if(coachType.equals(CoachType.SL.name())||(coachType.equals(CoachType.AC3.name()))){
			lSeatNo=seatNo%8;
			if(lSeatNo==1||lSeatNo==4)
				seatLegend="LB";
			else if(lSeatNo==2||lSeatNo==5)
				seatLegend="MB";
			else if(lSeatNo==3||lSeatNo==6)
				seatLegend="UB";
			else if(lSeatNo==7)
				seatLegend="SLB";
			else if(lSeatNo==0)
				seatLegend="SUB";
		}
		else if(coachType.equals(CoachType.AC2.name())){
			lSeatNo=seatNo%6;
			if(lSeatNo==1||lSeatNo==3)
				seatLegend="LB";
			else if(lSeatNo==2||lSeatNo==4)
				seatLegend="UB";
			else if(lSeatNo==5)
				seatLegend="SLB";
			else if(lSeatNo==6)
				seatLegend="SUB";

		}
		else if(coachType.equals(CoachType.AC1.name())){
			lSeatNo=seatNo%4;
			if(lSeatNo==1||lSeatNo==3)
				seatLegend="LB";
			else if(lSeatNo==2||lSeatNo==4)
				seatLegend="UB";
		}
		return seatLegend;
	}
	@Override
	public void add(TrainBooking t) {
		boolean isTrainPresent=false;
		for(TrainBooking eList:entityList)
		{
			if(eList.getTrainNumber()==t.getTrainNumber()&&eList.getbDate().equals(t.getbDate()))
			{
				eList=t;
				isTrainPresent=true;
			}
		}	
		if(!isTrainPresent)
			entityList.add(t);
		saveToFile();

	}

	public List<TrainBooking> get(long tNumber) {
		List<TrainBooking> trainBookingList=new ArrayList<TrainBooking>();
		for(TrainBooking eList:entityList)
		{
			if(eList.getTrainNumber()==tNumber)
			{
				trainBookingList.add(eList);
			}
		}	
		return trainBookingList;
	}
	
	public List<TrainBooking> getByDate(String travelDate) {
		List<TrainBooking> trainBookingList=new ArrayList<TrainBooking>();
		for(TrainBooking eList:entityList)
		{
			if(travelDate.equals(eList.getbDate()))
			{
				trainBookingList.add(eList);
			}
		}	
		return trainBookingList;
	}
	
	public TrainBooking get(String date,long tNumber)
	{
		for(TrainBooking eList:entityList)
		{
			if(eList.getbDate().equals(date)&&eList.getTrainNumber()==tNumber)
			{
				return eList;
			}
		}	
		return null;
	}
	@Override
	public void update(String Name, TrainBooking t) {
		// TODO Auto-generated method stub

	}
	@Override
	public void delete(String Name) {
		// TODO Auto-generated method stub

	}
	@Override
	public TrainBooking get(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

}
