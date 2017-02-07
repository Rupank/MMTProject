package com.MMT.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.MMT.bean.Hotel;
import com.MMT.bean.HotelRoom;


public class HotelDaoImplMMT implements HotelDaoMMT {

	@Override
	public int insertHotel(Hotel h) throws ClassNotFoundException, SQLException {
		Connection con=null;
		//Registering Driver - Connect
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connect to database
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system", "sapient123");
		
		String hotelId=h.getHotelId();
		String hotelName=h.getHotelName();
		String hotelLocation=h.getHotelLocation();
		String hotelInfo=h.getHotelInfo();
	
		//Query
		Statement stmt=con.createStatement();
		//System.out.println("b4 insert hotel");
		int rows=stmt.executeUpdate("INSERT INTO Hotel (hotelId,hotelName,hotelLocation,hotelInfo) VALUES ("+hotelId+",'"+hotelName+"','"+hotelLocation+"','"+hotelInfo+"')");
		//Process Results
		//System.out.println("a4 insert hotel");
		
		ArrayList<HotelRoom> rl=h.getHotelRoom();
		int rows2=0;
		
		for(HotelRoom room:rl)
		{
			Statement stmt2=con.createStatement();
			//System.out.println("b4 insert room");
			rows2=stmt2.executeUpdate("INSERT INTO HotelRoom (hotelId,hotelRoomNo,hotelRoomType,hotelRoomPrice,hotelRoomStatus) VALUES ("+hotelId+","+room.getHotelRoomNo()+",'"+room.getHotelRoomType()+"',"+room.getHotelRoomPrice()+",'"+room.getHotelRoomStatus()+"')");
			//System.out.println("a4 insert room");
		}
		if(rows>0 && rows2>0)
		{
			con.close();
			return rows;
		}
		else 
		{	con.close();
		return 0;
		}
		
	}



	@Override
	public int deleteHotel(String hotelId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHotel(String hotelId, Hotel newhotel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Hotel> displayHotel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel searchHotel(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
