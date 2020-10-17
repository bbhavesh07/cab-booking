package com.loginext.cabbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.loginext.cabbooking.model.Driver;
import com.loginext.cabbooking.model.Status;
import com.loginext.cabbooking.repository.DriverRepository;

@SpringBootApplication
public class CabBookingApplication implements CommandLineRunner{
	
	//for test purpose
	@Autowired
	private DriverRepository driverRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);
	}
	
	@Override
    public void run(String... args) {
		driverRepo.save(new Driver(1L, "D1", 58.32, -1.72, Status.AVAILABLE, null));
		driverRepo.save(new Driver(2L, "D2", 60.32, -3.72, Status.AVAILABLE, null));
		driverRepo.save(new Driver(3L, "D3", 65.32, -1.72, Status.AVAILABLE, null));
		driverRepo.save(new Driver(4L, "D4", 75.32, -2.72, Status.AVAILABLE, null));
		driverRepo.save(new Driver(5L, "D5", 53.32, -1.72, Status.AVAILABLE, null));
    }

}
