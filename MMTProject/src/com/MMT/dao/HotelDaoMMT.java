package com.MMT.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.MMT.bean.Hotel;

public interface HotelDaoMMT {
	int insertHotel(Hotel h) throws ClassNotFoundException, SQLException  ;
	int deleteHotel(String hotelId)throws SQLException ;
	int updateHotel(String hotelId, Hotel newhotel)throws SQLException ;
	ArrayList<Hotel> displayHotel() throws SQLException ;
	Hotel searchHotel(String hotelId) throws SQLException ;
//	ArrayList<HotelRoom> displayAvailableRooms(int hid)  throws IOException, ClassNotFoundException;
}
