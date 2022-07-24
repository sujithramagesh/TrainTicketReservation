package com.suji.train.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.suji.train.constants.CoachType;

public class Coach implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String coachCode;
String coachType;
int seatCount;


public Coach(String coachCode, CoachType coachType) {
	this.coachCode = coachCode;
	this.coachType = coachType.name();
	this.seatCount=coachType.getSeatCount();
}
public String getCoachType() {
	return coachType;
}
public void setCoachType(String coachType) {
	this.coachType = coachType;
}
public String getCoachCode() {
	return coachCode;
}
public int getSeatCount() {
	return seatCount;
}

}
