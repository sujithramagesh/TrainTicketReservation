package com.suji.train.constants;

public enum DaysOfWeek {
	MONDAY("M"),
	TUESDAY("T"),
	WEDNESDAY("W"),
	THURSDAY("TH"),
	FRIDAY("F"),
	SATURDAY("SA"),
	SUNDAY("S");
	public final String dofweek;
	DaysOfWeek(String dayName) {
		this.dofweek=dayName;
	}
	public String getDayCode()
	{
		return dofweek;
	}
	/*
	 * public static void main(String[] args) { for(DaysOfWeek
	 * dow:DaysOfWeek.values()) { System.out.println(dow.getDayCode()); } }
	 */
}
