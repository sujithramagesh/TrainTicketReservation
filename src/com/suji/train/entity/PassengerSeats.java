package com.suji.train.entity;

import java.io.Serializable;

public class PassengerSeats implements Serializable {
int seatNo;
String pName;
int pAge;
char pGender;
String coachCode; 
String seatLegend;
String status;

public int getSeatNo() {
	return seatNo;
}
public void setSeatNo(int seatNo) {
	this.seatNo = seatNo;
}
public String getSeatLegend() {
	return seatLegend;
}
public void setSeatLegend(String seatLegend) {
	this.seatLegend = seatLegend;
}
public String isStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getpName() {
	return pName;
}
public void setpName(String pName) {
	this.pName = pName;
}
public int getpAge() {
	return pAge;
}
public void setpAge(int pAge) {
	this.pAge = pAge;
}

public String getCoachCode() {
	return coachCode;
}
public void setCoachCode(String coachCode) {
	this.coachCode = coachCode;
}
public char getpGender() {
	return pGender;
}
public void setpGender(char pGender) {
	this.pGender = pGender;
}
public String getStatus() {
	return status;
}

}
