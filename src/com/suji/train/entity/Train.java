package com.suji.train.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Train implements Serializable {
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
String fStation;
String tStation;
String trainName;
long trainNumber;
List<String> stationList=new LinkedList<String>();
//HashMap<String,HashMap<String,Integer>> coach=new HashMap<String,HashMap<String,Integer>>();
List<Coach> coachList=new ArrayList<Coach>();

public List<Coach> getCoachList() {
	return coachList;
}
public void setCoachList(List<Coach> coachList) {
	this.coachList = coachList;
}
public List<String> getStationList() {
	return stationList;
}
public void setStationList(List<String> stationList) {
	this.stationList = stationList;
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
public String getTrainName() {
	return trainName;
}
public void setTrainName(String trainName) {
	this.trainName = trainName;
}
public long getTrainNumber() {
	return trainNumber;
}
public void setTrainNumber(long trainNumber) {
	this.trainNumber = trainNumber;
}


}
