package com.loginext.cabbooking.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Driver {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long driverId;
	private String name;
	private double latitude;
	private double longitude;
	@Enumerated(EnumType.STRING)
	private Status status;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "driver")
	private Booking booking;
	
	public Driver() {
		
	}
	
	public Driver(Long id, String name, double latitude, double longitude, Status status, Booking booking) {
		super();
		this.driverId = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
		this.booking = booking;
	}
	
	public Long getId() {
		return driverId;
	}
	public void setId(Long id) {
		this.driverId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
}
