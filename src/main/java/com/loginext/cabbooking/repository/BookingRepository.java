package com.loginext.cabbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.loginext.cabbooking.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long>{

}
