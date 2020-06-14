package com.mrsisa.dto;

import com.mrsisa.entity.clinic.Clinic;

public class ClinicDTO {
	private Long id;
	private Float grade;
	private String name;
	private String description;
	private String address;
	private String city;
	private String country;

	public ClinicDTO(Clinic clinic) {
		this.id = clinic.getId();
		this.grade = clinic.getGrade();
		this.name = clinic.getName();
		this.description = clinic.getDescription();
		this.address = clinic.getAddress();
		this.city = clinic.getCity();
		this.country = clinic.getCountry();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
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
