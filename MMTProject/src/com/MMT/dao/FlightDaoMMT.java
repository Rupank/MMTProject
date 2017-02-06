package com.MMT.dao;

import java.util.ArrayList;

import com.MMT.bean.FlightBooking;

public interface FlightDaoMMT {
	int insertFlightBooking(FlightBooking fb);
	ArrayList<FlightBooking> searchFlightBooking(String userId);
	int cancelFlightBooking(String flightBookingId);
}
