package com.MMT.dao;

import java.io.IOException;
import java.util.ArrayList;

import com.MMT.bean.HotelBooking;

public interface HotelBookingDaoMMT {
	boolean insertHotelBook(HotelBooking hb) throws IOException, ClassNotFoundException;
	ArrayList<HotelBooking> searchHotelBooking(String uid) throws IOException, ClassNotFoundException;
	boolean cancelHotelBooking(int hbId) throws IOException, ClassNotFoundException;
}
