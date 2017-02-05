package com.MMT.bl;

import java.io.IOException;

import com.MMT.bean.Admin;

import com.MMT.dao.AdminDaoMMT;

import com.MMT.dao.HotelDaoImplMMT;
import com.MMT.helper.AdminDataMMT;
import com.MMT.bean.Hotel;

import com.MMT.dao.AdminDaoImplMMT;

public class AdminBlMMT {
	private AdminDaoMMT ad=new AdminDaoImplMMT();
	private HotelDaoImplMMT hd=new HotelDaoImplMMT();
	private AdminDataMMT aData=new AdminDataMMT();
	public Admin alogin(String Username, String Password) throws ClassNotFoundException, IOException
	{
		
		Admin admin=aData.getAdmin();
		
		 if(admin.getAdminId().equals(Username) && admin.getAdminPassword().equals(Password))
			{
			 	
				return admin;
			}
		 
		return null;
	}
	public boolean insertHotel(Hotel h) throws ClassNotFoundException, IOException{		
		return hd.addHotel(h);		
	}
	public boolean deleteHotel(int hid) throws ClassNotFoundException, IOException{
		return hd.deleteHotel(hid);
	}
	public boolean modifyHotel(int hid, Hotel newhotel) throws ClassNotFoundException, IOException{
		return hd.updateHotel(hid, newhotel);
	}
}
