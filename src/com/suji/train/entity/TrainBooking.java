package com.suji.train.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class TrainBooking implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long trainNumber;
	String trainName;
	String bDate;
	String fStation;
	String tStation;
	HashMap<String,HashMap<String,Integer>> coachRemainingSeatMap=new HashMap<String,HashMap<String,Integer>>();
	public long getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(long l) {
		this.trainNumber = l;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String tDate) {
		this.bDate = tDate;
	}
	public HashMap<String, HashMap<String, Integer>> getCoachRemainingSeatMap() {
		return coachRemainingSeatMap;
	}
	public void setCoachRemainingSeatMap	(HashMap<String, HashMap<String, Integer>> coachRemainingSeatMap) {	
		this.coachRemainingSeatMap = coachRemainingSeatMap;
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
	
}
 