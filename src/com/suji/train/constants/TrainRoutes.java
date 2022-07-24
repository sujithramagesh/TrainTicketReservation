package com.suji.train.constants;

import java.util.LinkedHashMap;

public class TrainRoutes {
	/*
	 * LinkedList<String> trainRoute=new LinkedList<String>(){{
	 * addAll(nellaiExpressRoute); addAll(vaigaiExpressRoute);
	 * addAll(kanyakumariExpressRoute); }};
	 */
	/*
	 * LinkedList<String> nellaiExpressRoute=new LinkedList<String>() {{
	 * add("12631"); add("TEN"); add("CVP"); add("SRT"); add("VPT"); add("MDU");
	 * add("SDN"); add("DG"); add("TPJ"); add("VRI"); add("VM"); add("TMV");
	 * add("MLMR"); add("CGL"); add("TBM"); add("MS"); }}; LinkedList<String>
	 * vaigaiExpressRoute=new LinkedList<String>() {{ add("12635"); add("MDU");
	 * add("SDN"); add("DG"); add("TPJ"); add("ALU"); add("VRI"); add("VM");
	 * add("TMV"); add("MLMR"); add("CGL"); add("TBM"); add("MS");
	 * 
	 * }};
	 */
	
public static LinkedHashMap<String,Integer> kanyakumaritoChennai=new LinkedHashMap<String,Integer>() {{
	put("CAPE",0);
	put("NCJ",16);
	put("VLY",47);
	put("TEN",89);
	put("CVP",154);
	put("SRT",175);
	put("VPT",202);
	put("MDU",245);
	put("SDN",311);
	put("DG",406);
	put("TPJ",529);
	put("VRI",583);
	put("VM",620);
	put("TMV",651);
	put("MLMR",686);
	put("CGL",717);
	put("TBM",735);
	put("MS",742);
}};
}
