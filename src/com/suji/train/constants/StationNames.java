package com.suji.train.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StationNames {
public static HashMap<String,String> stationName=new HashMap<String,String>(){{
	put("CAPE","Kanyakumari");
	put("NCJ","Nagercoil Junction");
	put("VLY","VALLIYUR");
	put("TEN", "Tirunelveli");
	put("CVP","Kovilpatti");
	put("SRT","Satur");
	put("VPT","Virudunagar JN");
	put("MDU", "Madurai JN");
	put("DG","Dindigul JN");
	put("TPJ","Tiruchirapalli");
	put("VRI","Vridhachalam JN");
	put("VM","Villupuram JN");
	put("TMV","Tindivanam");
	put("MLMR","Melmaruvattur");
	put("CGL","Chengalpattu");
	put("TBM","Tambaram");
	put("MBM","Mambalam");
	put("CBE","Coimbatore");
	put("SA","Salem");
	put("ED","Erode Junction");
	put("DG", "Dindigul Junction");
	put("TJ", "Thanjavur Junction");
	put("MS","Chennai Egmore");
}};
public static void showStationNames()
{
	System.out.println("-------------------------------------------------");
	System.out.printf("%-20s | %s\n","Station Name","Station Code             |");
	System.out.println("-------------------------------------------------");
	for(Map.Entry<String, String> hm: StationNames.stationName.entrySet())
	{
		
		System.out.printf("%-20s |  %s\n",hm.getValue(),hm.getKey());
		
	}
	System.out.println("-------------------------------------------------");
}
public static HashMap<String, String> getStationName() {
	return stationName;
}

public static void setStationName(HashMap<String, String> stationName) {
	StationNames.stationName = stationName;
}

}
