package com.loginext.cabbooking.service.impl;

import java.util.Optional;
import java.util.PriorityQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginext.cabbooking.exceptions.BookingCannotBeCreatedException;
import com.loginext.cabbooking.exceptions.BookingNotFoundException;
import com.loginext.cabbooking.model.*;
import com.loginext.cabbooking.repository.BookingRepository;
import com.loginext.cabbooking.service.BookingService;
import com.loginext.cabbooking.service.DriverService;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepo;
	@Autowired
	private DriverService driverService;

	@Override
	public Booking addBooking(Booking booking) {
		PriorityQueue<Driver> driversDist = new PriorityQueue<Driver>(
				(a,b)->Double.compare(getDistance(booking.getCustLatitude(), booking.getCustLongitude(), a.getLatitude(), a.getLongitude()),
				getDistance(booking.getCustLatitude(), booking.getCustLongitude(), b.getLatitude(), b.getLongitude()))); 
		for(Driver d: driverService.getAllDrivers()) {
			if(d.getStatus().equals(Status.AVAILABLE))	//TODO: write a method in Driver to get all available drivers
				driversDist.offer(d);
		}
		Driver driver = Optional.ofNullable(driversDist.poll()).orElseThrow(BookingCannotBeCreatedException::new);
		driver.setStatus(Status.BUSY);
		booking.setDriver(driver);
		return bookingRepo.save(booking);
	}
	
	@Override
	public Iterable<Booking> getAllBookings() {
		return bookingRepo.findAll();
	}

	@Override
	public Booking getBookingById(Long id) {
		return bookingRepo.findById(id).orElseThrow(BookingNotFoundException::new);
	}

	@Override
	public Booking updateBooking(Long id, Booking booking) {
		Booking bookingToUpdate = bookingRepo.findById(id).orElseThrow(BookingNotFoundException::new);
		bookingToUpdate.setCustName(booking.getCustName());
		bookingToUpdate.setCustLatitude(booking.getCustLatitude());
		bookingToUpdate.setCustLongitude(booking.getCustLongitude());
		return bookingRepo.save(bookingToUpdate);
	}

	@Override
	public String deleteBookingById(Long id) {
		bookingRepo.delete(bookingRepo.findById(id).orElseThrow(BookingNotFoundException::new));
		return "{meassage: Booking deleted successfully!}";
	}

	private double getDistance(double lat1, double long1, double lat2, double long2) {
		
		long1 = Math.toRadians(long1); 
        long2 = Math.toRadians(long2); 
        lat1 = Math.toRadians(lat1); 
        lat2 = Math.toRadians(lat2); 
  
        // Haversine formula  
        double dlon = long2 - long1;  
        double dlat = lat2 - lat1; 
        double dist = Math.pow(Math.sin(dlat / 2), 2) 
                 + Math.cos(lat1) * Math.cos(lat2) 
                 * Math.pow(Math.sin(dlon / 2),2); 
              
        dist = 2 * Math.asin(Math.sqrt(dist)); 
  
        // Radius of earth in kilometers: 6371
        return dist * 6371; 
	}
}
