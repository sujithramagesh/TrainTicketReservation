package com.suji.train.repository;

import java.util.ArrayList;

import com.suji.train.entity.PassengerSeats;
import com.suji.train.entity.UserBooking;

public class UserBookingRepository extends AbstractRepository<UserBooking>{
	private static UserBookingRepository ubRepo;
	protected UserBookingRepository() {
		super(UserBooking.class.getSimpleName());
		loadFromFile();
	}
	public static UserBookingRepository getInstance()
	{
		if(ubRepo==null)
		{
			ubRepo=new UserBookingRepository();
		}
		return ubRepo;
	}

	@Override
	public void add(UserBooking t) {
		// TODO Auto-generated method stub

		entityList.add(t);
		saveToFile();
	}
	public Long getPNRNumber() {
		long pnrNumber;
		if(entityList.size()>0)
		{
			UserBooking uBooking=entityList.get(entityList.size()-1);
			pnrNumber=uBooking.getPnrNumber();
		}
		else
			pnrNumber=1000000000l;

		return pnrNumber;
	}
	public void showPassengerdetails(ArrayList<PassengerSeats> pList)
	{
		for(PassengerSeats pSeats:pList)
		{
			System.out.println("\t"+pSeats.getCoachCode()+"\t"+pSeats.getSeatNo()+"\t"
					+pSeats.getSeatLegend()+"\t"+pSeats.getpGender()
					+"\t"+pSeats.getpAge());
		}
	}
	@Override
	public UserBooking get(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public UserBooking get(long pnrNumber) {
		for(UserBooking userBooking:entityList)
		{
			if(userBooking.getPnrNumber()==pnrNumber)
			{
				return userBooking;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(String name, UserBooking t) {
		// TODO Auto-generated method stub

	}
	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub

	}
}
