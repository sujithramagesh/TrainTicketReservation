package com.suji.train.repository;
import java.util.Date;

import com.suji.train.entity.User;
public class UserRepository extends AbstractRepository<User>{
	private static UserRepository uRepo;
	Date date=new Date();

	private UserRepository() {
		super(User.class.getSimpleName());
		loadFromFile();
		if(entityList.size()==0)
		{
			User user=new User();
			user.setuName("admin");
			user.setPassword("admin");
			user.setPhoneNumber(9876543210l);
			user.setEmailId("admin@gmail.com");
			entityList.add(user);
		}
	}
	public static UserRepository getInstance()
	{
		if(uRepo==null)
			uRepo=new UserRepository();
		return uRepo;
	}
	@Override
	public void add(User t) {
		entityList.add(t);
		saveToFile();

	}
	public boolean isUserNamePresent(String uName)
	{
		User user=new User();
		user=get(uName);
		if(user==null)
		{
			return false;
		}
		else
		{
			return true;
		}

	}
	public boolean isPasswordValid(String uName,String Password)
	{

		User user=new User();
		user=get(uName);
		if(user.getPassword().equals(Password))
		{
			return true;
		}
		else
			return false;
	}
	@Override
	public User get(String uName) {
		for(User user:entityList)
		{
			if(uName.equals(user.getuName()))
			{
				return user;

			}
		}
		return null;
	}

	@Override
	public void update(String UName, User t) {
		for(User user:entityList)
		{
			if(user.getuName().equals(UName))
			{
				//user.setCreationDate(date.);
				user.setPassword(t.getPassword());
				user.setEmailId(t.getEmailId());
				user.setPhoneNumber(t.getPhoneNumber());
			}
		}

	}

	@Override
	public void delete(String UName) {

		for(User user:entityList)
		{
			if(user.getuName().equals(UName))
			{
				entityList.remove(user);
			}
		}
	}

}

