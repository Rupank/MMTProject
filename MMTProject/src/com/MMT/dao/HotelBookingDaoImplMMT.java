package com.MMT.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.MMT.bean.HotelBooking;
import com.MMT.helper.MyAppendObjectOutputStream;

public class HotelBookingDaoImplMMT {
	public boolean insertHotelBook(HotelBooking hb) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file=new File("HotBookFile");
		ObjectOutputStream oos=null;
		FileOutputStream  fos=null;
		if(!file.exists()){
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
		}
		else{
			fos=new FileOutputStream(file,true);
			oos=new MyAppendObjectOutputStream(fos);
		}
		oos.writeObject(hb);
		oos.close();
		fos.close();
		return true;
	}
	public ArrayList<HotelBooking> searchHotelBooking(String uid) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file=new File("HotBookFile");
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		ArrayList<HotelBooking> li=new ArrayList<HotelBooking>();
		while(fis.available()>0){
			HotelBooking hotelb=(HotelBooking)ois.readObject();
			if(hotelb.getUserId().equals(uid)){
				
				li.add(hotelb);
			}
		}
		ois.close();
		fis.close();
		
		
		return li;
	}
}
