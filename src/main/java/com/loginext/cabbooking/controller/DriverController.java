package com.loginext.cabbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginext.cabbooking.model.Driver;
import com.loginext.cabbooking.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@GetMapping
	public Iterable<Driver> getAllUsers(){
		return driverService.getAllDrivers();
	}
}
