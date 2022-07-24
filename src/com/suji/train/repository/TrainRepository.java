package com.suji.train.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.suji.train.constants.StationNames;
import com.suji.train.entity.Coach;
import com.suji.train.entity.Train;

public class TrainRepository extends AbstractRepository<Train> {
	
	private static TrainRepository tRepo;
	private TrainRepository() {
		super(Train.class.getSimpleName());
		loadFromFile();
	}
	public static TrainRepository getInstance()
	{
		if(tRepo==null)
		{
			tRepo=new TrainRepository();
		}
		return tRepo;
	}

	@Override
	public void add(Train t) {
		entityList.add(t);
		saveToFile();
		
	}
	public HashMap<String,Integer> getTotalSeats(Train train)
	{
		HashMap<String,Integer> seats=new HashMap<String, Integer>();
		for(Coach coach:train.getCoachList())
		{
			if(seats.containsKey(coach.getCoachType()))
			{
				seats.put(coach.getCoachType(), seats.get(coach.getCoachType())+coach.getSeatCount());
			}
			else
			{
				seats.put(coach.getCoachType(), coach.getSeatCount());
			}
		}
		return seats;
	}
	
	public boolean isTrainNameNumberExist(String tName,long tNumber)
	{
		Train t=get(tNumber,tName);
		if(t==null)
		{
			return false;
		}
		else
			return true;
		
	}
	public boolean isTrainNameExist(String tName)
	{
		Train t=get(tName);
		if(t==null)
		{
			return false;
		}
		else
			return true;
	}
	public boolean isTrainNumberExist(long tNumber)
	{
		Train t=get(tNumber);
		if(t==null)
		{
			return false;
		}
		else
			return true;
	}
	public Train get(long tNumber,String tName) {
		for(Train train:entityList)
		{
			if(tName.equals(train.getTrainName())&&tNumber==train.getTrainNumber())
			{
				return train;
			}	
		}
		return null;
	}
	public List<Train> get()
	{
		return entityList;
	}
	public Train get(long tNumber) {
		for(Train train:entityList)
		{
			if(tNumber==train.getTrainNumber())
			{
				return train;
			}
		}
		return null;
	
	}
	@Override
	public void update(String Name, Train t) {
		
	}

	@Override
	public void delete(String Name) {
		// TODO Auto-generated method stub
		
	}
	public List<Train> getTrains(String fStation,String tStation)
	{
		List<Train> trains=new ArrayList<Train>();
		for(Train train:entityList)
		{
			
			if(train.getStationList().contains(fStation)&&train.getStationList().contains(tStation))
			{
				trains.add(train);
			}
		}
		return trains;
		
	}
	@Override
	public Train get(String tName) {
		for(Train train:entityList)
		{
			if(tName.equals(train.getTrainName()))
			{
				return train;
			}
		}
		return null;
	}
	public void showCoachList(List<Coach> list)
	{
		for(Coach c:list)
		{
			System.out.println(c.getCoachType()+"     |     "+c.getCoachCode()+"     |     "+c.getSeatCount());
		}
	}
	public void showList(List<String> list)
	{
		int index=1;
		System.out.println("---------------------------------------------------------------------");
		for(String i:list)
		{
			for(Map.Entry<String, String> entry:StationNames.getStationName().entrySet())
			{
				if(i.equals(entry.getKey()))
				{
					System.out.println("|"+((index<10)?index+"  | ":index+" | ")+entry.getValue()+"-"+entry.getKey());
				}
			}
			index++;
		}
		System.out.println("---------------------------------------------------------------------");
	}
	public void showMap(HashMap<String, HashMap<String,Integer>> hm)
	{
		System.out.println(hm.toString());
		for(Map.Entry<String, HashMap<String,Integer>> entry:hm.entrySet())
		{
			String coachType=entry.getKey();
			//System.out.println(coachType+entry.getValue().toString());
			
			  for(Map.Entry<String, Integer> nesEntry:entry.getValue().entrySet()) {
			  System.out.println(coachType+"|"+nesEntry.getKey()+"|"+nesEntry.getValue());
			  }
			 
		}
	}


}
