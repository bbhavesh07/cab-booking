package com.loginext.cabbooking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginext.cabbooking.exceptions.DriverNotFoundException;
import com.loginext.cabbooking.model.Driver;
import com.loginext.cabbooking.repository.DriverRepository;
import com.loginext.cabbooking.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService{
	@Autowired
	private DriverRepository driverRepo;
	
	@Override
	public Driver addDriver(Driver driver) {
		return driverRepo.save(driver);
	}
	
	@Override
	public Iterable<Driver> getAllDrivers() {
		return driverRepo.findAll();
	}

	@Override
	public Driver getDriverById(Long id) {
		return driverRepo.findById(id).orElseThrow(DriverNotFoundException::new);
	}

	@Override
	public Driver updateDriver(Long id, Driver driver) {
		Driver driverToUpdate = driverRepo.findById(id).orElseThrow(DriverNotFoundException::new);
		driverToUpdate.setName(driver.getName());
		driverToUpdate.setLatitude(driver.getLatitude());
		driverToUpdate.setLongitude(driver.getLongitude());
		driverToUpdate.setStatus(driver.getStatus());
		return driverRepo.save(driverToUpdate);
	}

	@Override
	public String deleteDriverById(Long id) {
		driverRepo.delete(driverRepo.findById(id).orElseThrow(DriverNotFoundException::new));
		return "{meassage: Driver deleted successfully!}";
	}

}
