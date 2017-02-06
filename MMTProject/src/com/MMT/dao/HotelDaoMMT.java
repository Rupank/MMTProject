package com.MMT.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.MMT.bean.Hotel;

public interface HotelDaoMMT {
	int insertHotel(Hotel h)  ;
	int deleteHotel(String hotelId);
	int updateHotel(String hotelId, Hotel newhotel);
	ArrayList<Hotel> displayHotel() ;
	Hotel searchHotel(String hotelId) ;
//	ArrayList<HotelRoom> displayAvailableRooms(int hid)  throws IOException, ClassNotFoundException;
}
