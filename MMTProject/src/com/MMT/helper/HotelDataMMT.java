package com.MMT.helper;

import java.util.ArrayList;
import java.util.Scanner;

import com.MMT.bean.Hotel;

import com.MMT.bean.HotelRoom;

public class HotelDataMMT {
	private Hotel hotel=new Hotel();
	private Scanner sc;
	public void input(){
		sc = new Scanner(System.in);
		System.out.println("Enter Hotel id : ");
		hotel.setHotelId(sc.nextInt());
		System.out.println("Enter Hotel Name : ");
		hotel.setHotelName(sc.next());
		System.out.println("Enter Hotel Location: ");
		hotel.setHotelLocation(sc.next());
		System.out.println("Enter Hotel Info : ");
		hotel.setHotelInfo(sc.next());
		ArrayList<HotelRoom> hr=new ArrayList<HotelRoom>();
		
		
		
		String more="Y";
		int hroom=1;
		
		while(more.toUpperCase().equals("Y"))
		{
			
			System.out.println("Enter Deatails for Room No :"+hroom);
			
			HotelRoom room=new HotelRoom();
			room.setHotelRoomNo(hroom);
			System.out.println("Enter Room Type : ");
			room.setHotelRoomType(sc.next());
			System.out.println("Enter Room Price : ");
			room.setHotelRoomPrice(sc.nextDouble());
			
			room.setHotelRoomStatus("Avail");
			
			hr.add(room);
			
			System.out.println("Enter More Rooms Y/N");
			more=sc.next();
			hroom+=1;
			
			
		}
		hotel.setHotelRoom(hr);
		
		
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
