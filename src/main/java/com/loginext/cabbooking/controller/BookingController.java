package com.loginext.cabbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginext.cabbooking.model.Booking;
import com.loginext.cabbooking.service.BookingService;

@RestController
@RequestMapping("/book")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping
    public ResponseEntity<?> getBestDriver(@RequestBody Booking booking) {

        return ResponseEntity.ok(bookingService.addBooking(booking).getDriver());
    }
}
