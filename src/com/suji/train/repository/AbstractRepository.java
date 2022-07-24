package com.suji.train.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> implements Repository<T> {
	
	protected List<T> entityList=new ArrayList<T>();
	private String fileName;
	protected AbstractRepository(String entityName)
	{
		this.fileName=entityName;
	}
	protected void saveToFile()
	{
		try
		{
			FileOutputStream f = new FileOutputStream(new File("D:\\suji workspace\\TrainTicketReservation\\src\\com\\suji\\train\\constants\\Files\\"+fileName+".txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(entityList);
			o.close();
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}
	@SuppressWarnings("unchecked")
	protected void loadFromFile()
	{
		try
		{
			File f=new File("D:\\suji workspace\\TrainTicketReservation\\src\\com\\suji\\train\\constants\\Files\\"+fileName+".txt");
			if(f.exists())
			{
				FileInputStream fiS = new FileInputStream(f);
				ObjectInputStream oiS = new ObjectInputStream(fiS);
				try {
					entityList=(List<T>) oiS.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				oiS.close();
				fiS.close();
			}
		}catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		}

	}

}
