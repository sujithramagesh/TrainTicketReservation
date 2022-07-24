package com.suji.train.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import com.suji.train.constants.CoachType;
import com.suji.train.constants.TrainRoutes;

public class UserBooking implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String uName;
long trainNumber;
String fStation;
String tStation;
String tdate;
int noOfSeats;
long pnrNumber;
double fare;
String coachType;
ArrayList<PassengerSeats> pSeatsArrayList;
public String getuName() {
	return uName;
}
public void setuName(String uName) {
	this.uName = uName;
}
public long getTrainNumber() {
	return trainNumber;
}
public void setTrainNumber(long trainNumber) {
	this.trainNumber = trainNumber;
}
public String getfStation() {
	return fStation;
}
public void setfStation(String fStation) {
	this.fStation = fStation;
}
public String gettStation() {
	return tStation;
}
public void settStation(String tStation) {
	this.tStation = tStation;
}
public String getTdate() {
	return tdate;
}
public void setTdate(String tdate) {
	this.tdate = tdate;
}
public int getNoOfSeats() {
	return noOfSeats;
}
public void setNoOfSeats(int noOfSeats) {
	this.noOfSeats = noOfSeats;
}
public long getPnrNumber() {
	return pnrNumber;
}
public void setPnrNumber(long pnrNumber) {
	this.pnrNumber = pnrNumber;
}
public ArrayList<PassengerSeats> getpSeatsArrayList() {
	return pSeatsArrayList;
}
public void setpSeatsArrayList(ArrayList<PassengerSeats> pSeatsArrayList) {
	this.pSeatsArrayList = pSeatsArrayList;
}
public String getCoachType() {
	return coachType;
}
public void setCoachType(String coachType) {
	this.coachType = coachType;
}

public void setFare(double fare) {
	this.fare = fare;
}
public double getFare() {
	return fare;
}
public double generateFare() {
	int reservationCharge= CoachType.getByCoachType(coachType).reservationCharge;
	double baseFare=(TrainRoutes.kanyakumaritoChennai.get(gettStation())-TrainRoutes.kanyakumaritoChennai.get(getfStation())*0.48);
	double totalFare=baseFare+reservationCharge;
	double gST=(5*totalFare)/100;
	return totalFare+gST;
}

}
