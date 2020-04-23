package com.mrsisa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("patient")
public class Patient extends UserAccount{
	
	@Column(nullable = false, name="first_name")
	protected String firstName;
	
	@Column(nullable = false, name="last_name")
	protected String lastName;
	
	@Column(nullable = true, name="phone_number")
	protected String phoneNumber;
	
	@Column(nullable = false, name="address")
	protected String address;
	
	@Column(nullable = false, name="city")
	protected String city;
	
	@Column(nullable = false, name="country")
	protected String country;
	
	@Column(unique = true, nullable = false, length = 13, name="jmbg")
	protected String jmbg;
	
	@Column(unique = true, nullable = false, length = 11, name="lbo")
	protected String lbo;
	
	@Column(unique = true, nullable = false, length = 11, name="zk")
	protected String zk;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLbo() {
		return lbo;
	}

	public void setLbo(String lbo) {
		this.lbo = lbo;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getZk() {
		return zk;
	}

	public void setZk(String zk) {
		this.zk = zk;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
