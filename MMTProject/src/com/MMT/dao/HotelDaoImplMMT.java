package com.MMT.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.MMT.bean.Hotel;

import com.MMT.helper.MyAppendObjectOutputStream;

public class HotelDaoImplMMT implements HotelDaoMMT {
	@Override
	public boolean updateHotel(int hid, Hotel newhotel) throws IOException, ClassNotFoundException{
		int count=0;
		File file=new File("HotFile");
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		File file1=new File("NewHotFile");
		ObjectOutputStream oos=null;
		FileOutputStream  fos=null;
		if(!file1.exists()){
			fos=new FileOutputStream(file1);
			oos=new ObjectOutputStream(fos);
		}
		//else{
		//	fos=new FileOutputStream(file1,true);
		//	oos=new MyAppendObjectOutputStream(fos);
		//}
	while(fis.available()>0){
			Hotel hotel=(Hotel)ois.readObject();
			if(hotel.getHotelId()==hid){
				oos.writeObject(newhotel);
				count=1;
				continue;			
			}
			else
			{
				oos.writeObject(hotel);
			}
		}
		if(count!=1)
		{
			ois.close();
			fis.close();
			oos.close();
			fos.close();
			file.delete();
			file1.renameTo(file);
			return false;
		}
		ois.close();
		fis.close();
		oos.close();
		fos.close();
		file.delete();
		file1.renameTo(file);
		return true;
	}
	@Override
	public ArrayList<Hotel> displayHotel()throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		File file=new File("HotFile");
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		ArrayList<Hotel> hotList=new ArrayList<Hotel>();
		
		while(fis.available()>0){
			Hotel hotel=(Hotel)ois.readObject();
			
			hotList.add(hotel);
		}
		ois.close();
		fis.close();
		return hotList;
		
	}
	@Override
	public Hotel searchHotel(int hid) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file=new File("HotFile");
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		while(fis.available()>0){
			Hotel hotel=(Hotel)ois.readObject();
			if(hotel.getHotelId()==hid){
				ois.close();
				fis.close();
				return hotel;
			}
		}
		ois.close();
		fis.close();
		
		
		return null;
	}
	@Override
	public boolean addHotel(Hotel h)  throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		File file=new File("HotFile");
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
		oos.writeObject(h);
		oos.close();
		fos.close();
		return true;
		
	}

	@Override
	public boolean deleteHotel(int hid) throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		File file=new File("HotFile");
		File tempFile=new File("Temp");
		
		FileOutputStream fos=new FileOutputStream(tempFile);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		
		
		while(fis.available()>0){
			Hotel hotel=(Hotel)ois.readObject();
			
			if(hotel.getHotelId()!=hid)
				oos.writeObject(hotel);
		}
				
		
	
		
		oos.close();
		fos.close();
		ois.close();
		fis.close();
		
		file.delete();
		tempFile.renameTo(file);
		tempFile.delete();
		
		return false;
	}
}
