package com.MMT.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import com.MMT.bean.User;
import com.MMT.dao.UserDaoImplMMT;
import com.MMT.dao.HotelBookingDaoImplMMT;
import com.MMT.bean.HotelBooking;

public class UserBlMMT {
	private HotelBookingDaoImplMMT hbd=new HotelBookingDaoImplMMT();
	public User checkLogin(String username,String password) throws FileNotFoundException, ClassNotFoundException, IOException  
	{
		UserDaoImplMMT udi=new UserDaoImplMMT();
		
		 User user=(User)udi.search(username);
		 if(user.getUserId().equals(username) && user.getUserpassword().equals(password))
			{				 
				return user;
			}
		
		
		 
		return null;
	}
	public ArrayList<HotelBooking> pastHbooking(String uid) throws ClassNotFoundException, IOException
	{
		
		return hbd.searchHotelBooking(uid);
	}
	public boolean register(User user) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		UserDaoImplMMT udi=new UserDaoImplMMT();
		
		if(udi.search(user.getUserId())==null){
			
			boolean tf=udi.addUser(user);
			if(tf==true)
			return true;
			else
				return false;
		}
		else
		{
			System.out.println("User Name already taken.Please select another user name.");
			return false;
		}
		
	}

}
