package com.mrsisa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Clinic {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clinic_generator")
	@SequenceGenerator(name = "clinic_generator", sequenceName = "clinic_seq")
	private Long id;
	
	@Column(nullable = false, name="name")
	protected String name;
	
	@Column(name="description", columnDefinition="text")
	protected String description;
	
	@Column(nullable = false, name="address")
	protected String address;
	
	@Column(nullable = false, name="city")
	protected String city;
	
	@Column(nullable = false, name="country")
	protected String country;
	
	@Column(nullable = false, name="grade")
	protected float grade;
	
	@CreationTimestamp
	protected Date registrationDate;
	
	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
}
