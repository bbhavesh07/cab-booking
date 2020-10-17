package com.loginext.cabbooking.service;

import com.loginext.cabbooking.model.Booking;;

public interface BookingService {
	Booking addBooking(Booking Booking);
	Iterable<Booking> getAllBookings();
	Booking getBookingById(Long id);
	Booking updateBooking(Long id, Booking Booking);
	String deleteBookingById(Long id);
}
