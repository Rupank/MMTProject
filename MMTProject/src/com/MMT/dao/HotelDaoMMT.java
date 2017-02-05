package com.MMT.dao;

import java.io.IOException;
import java.util.ArrayList;

import com.MMT.bean.Hotel;

public interface HotelDaoMMT {
	ArrayList<Hotel> displayHotel() throws IOException, ClassNotFoundException;
	Hotel searchHotel(int hid) throws IOException, ClassNotFoundException;
	boolean updateHotel(int hid, Hotel newhotel)  throws IOException, ClassNotFoundException;
	boolean addHotel(Hotel h)  throws IOException, ClassNotFoundException;
	boolean deleteHotel(int hid)  throws IOException, ClassNotFoundException;
}
