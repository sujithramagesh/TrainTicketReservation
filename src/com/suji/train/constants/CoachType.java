package com.suji.train.constants;

public enum CoachType {
S(108,"D",15),SL(72,"S",20),AC3(64,"B",40),AC2(46,"A",50),AC1(22,"H",60);
	public final int seatCount;
	public final String coachCode;
	public final int reservationCharge;
	CoachType(int seatCount,String coachCode,int reservationCharge) {
		this.seatCount=seatCount;
		this.coachCode=coachCode;
		this.reservationCharge=reservationCharge;
	}
	public static CoachType getByIndex(int index)
	{
		for(CoachType cType:CoachType.values())
		{
			if(cType.ordinal()==index) {
				return cType;
			}
		}
		return null;
		
	}
	public static CoachType getByCoachType(String coachType)
	{
		for(CoachType cType:CoachType.values())
		{
			if(cType.name().equals(coachType)) {
				return cType;
			}
		}
		return null;
		
	}
	public int getSeatCount()
	{
		return seatCount;
	}
	public String getCoachCode()
	{
		return coachCode;
	}
	public int getReservationCharge()
	{
		return reservationCharge;
	}
	
}
