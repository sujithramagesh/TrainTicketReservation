package com.suji.train.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import com.suji.train.constants.StationNames;
import com.suji.train.constants.TrainRoutes;

public class TrainRoutesRepository {
	private static TrainRoutesRepository trRepo;
	public static TrainRoutesRepository getInstance()
	{
		if(trRepo==null)
		{
			trRepo=new TrainRoutesRepository();
		}
		return trRepo;
	}

	public LinkedList<String> getTrainRoute(String fStation,String tStation)
	{
		LinkedList<String> sList=new LinkedList<String>();
		if(sList.size()>0)
			sList.clear();
		int fIndex = 0,tIndex = 0;
		ArrayList<String> trainRouteList=new ArrayList<String>();
		trainRouteList.addAll(TrainRoutes.kanyakumaritoChennai.keySet());

		fIndex=trainRouteList.indexOf(fStation);
		tIndex=trainRouteList.indexOf(tStation);
		if(fIndex<tIndex)
		{
			if(fIndex!=-1&&tIndex!=-1) {
				for(int i=fIndex;i<=tIndex;i++)
				{
					sList.add(trainRouteList.get(i));
				}
			}
		}


		return sList;
	}
	public void showTrainRoute(LinkedList<String> sList)
	{
		int index=1;
		System.out.println("SNo         Stations");
		for(String tRoute:sList)
		{

			for(Map.Entry<String, String> entry:StationNames.getStationName().entrySet())
			{
				if(tRoute.equals(entry.getKey()))
				{
					System.out.println(((index<10)?index+" .       ":index+" .      ")+entry.getValue()+"-"+entry.getKey());
				}
			}
			index++;
		}
	}
	public LinkedList<String> removeStationFromTrainRoute(ArrayList<Integer> choice,LinkedList<String> sList)
	{
		//LinkedList<String> lsList=new LinkedList<String>(sList);
		if(choice.size()>0)
		{
			for(int i:choice)
			{
				sList.remove(i-1);
			}

		}
		return sList;
	}
}
