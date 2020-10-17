package com.loginext.cabbooking.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderId;
	private String custName;
	private double custLatitude;
	private double custLongitude;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driverId", unique = true)
	@JsonIgnore
	private Driver driver;
	
	public Booking() {
		
	}
	
	public Booking(Long orderId, String custName, double custLatitude, double custLongitude, Driver driver) {
		super();
		this.orderId = orderId;
		this.custName = custName;
		this.custLatitude = custLatitude;
		this.custLongitude = custLongitude;
		this.driver = driver;
	}

	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public double getCustLatitude() {
		return custLatitude;
	}
	public void setCustLatitude(double custLatitude) {
		this.custLatitude = custLatitude;
	}
	public double getCustLongitude() {
		return custLongitude;
	}
	public void setCustLongitude(double custLongitude) {
		this.custLongitude = custLongitude;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
}
