package com.loginext.cabbooking.service;

import com.loginext.cabbooking.model.Driver;

public interface DriverService {
	Driver addDriver(Driver Driver);
	Iterable<Driver> getAllDrivers();
	Driver getDriverById(Long id);
	Driver updateDriver(Long id, Driver Driver);
	String deleteDriverById(Long id);
}
