package com.MMT.bl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.MMT.dao.HotelDaoImplMMT;

import com.MMT.dao.HotelBookingDaoImplMMT;

import com.MMT.bean.HotelBooking;

import com.MMT.bean.HotelRoom;

import com.MMT.bean.Hotel;

public class HotelBlMMT {
	HotelDaoImplMMT hd=new HotelDaoImplMMT();
	HotelBookingDaoImplMMT hbd=new HotelBookingDaoImplMMT();
	public boolean hotelBooking(int hid,String uid,int rno) throws ClassNotFoundException, IOException
	{
		Hotel hotel=new Hotel();
		hotel=hd.searchHotel(hid);
		ArrayList<HotelRoom> room=new ArrayList<HotelRoom>();
		room=hotel.getHotelRoom();
		int count=0;
		int index=0;
		HotelRoom rnew=new HotelRoom();
		for(HotelRoom r:room)
		{
			count++;
			if(r.getHotelRoomNo()==rno)
			{
				index=count;
				if(r.getHotelRoomStatus().equals("not"))
				{
					return false;
				}
				else
				{
					rnew.setHotelRoomNo(r.getHotelRoomNo());
					rnew.setHotelRoomPrice(r.getHotelRoomPrice());
					rnew.setHotelRoomStatus("not");
					rnew.setHotelRoomType(r.getHotelRoomType());
					}
			}
		}
		room.set(index-1, rnew);
		hotel.setHotelRoom(room);
		hd.updateHotel(hid, hotel);
		long hbid=(long) (new Date()).getTime();
		HotelBooking hb=new HotelBooking();
		//hb.setHotelCheckInDate(hotelCheckInDate);
		//hb.setHotelCheckOutDate(hotelCheckOutDate);
		hb.setHotelBookingId(hbid);
		hb.setUserId(uid);
		hb.setRoomNo(rno);
		hbd.insertHotelBook(hb);
		return true;
	}
	public ArrayList<Hotel> searchResult() throws ClassNotFoundException, IOException
	{
		return hd.displayHotel();
	}
	public Hotel displayHotel(int hid) throws ClassNotFoundException, IOException
	{
		return hd.searchHotel(hid);
	}
	public ArrayList<HotelRoom> availableRooms(int hid) throws ClassNotFoundException, IOException
	{
		ArrayList<HotelRoom> hrooms=new ArrayList<HotelRoom>();
		
		Hotel hotel=new Hotel();
		
		hotel=hd.searchHotel(hid);
		
		ArrayList<HotelRoom> room=new ArrayList<HotelRoom>();
	
		room=hotel.getHotelRoom();
		
		for(HotelRoom r:room)
		{
			if(r.getHotelRoomStatus().equals("Avail"))
			{
				hrooms.add(r);
			}
		}
	
		
		return hrooms;
	}
}
