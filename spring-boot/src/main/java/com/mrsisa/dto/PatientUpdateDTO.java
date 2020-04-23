package com.mrsisa.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.mrsisa.entity.Patient;


public class PatientUpdateDTO {
	@NotBlank(message = "Ime je obavezno polje.")
	@Length(min = 1, max = 20, message = "Ime treba da ima izmedju 1 i 20 karaktera.")
	protected String firstName;
	
	@NotBlank(message = "Prezime je obavezno polje.")
	@Length(min = 1, max = 20, message = "Prezime treba da ima izmedju 1 i 20 karaktera.")
	protected String lastName;

	@Length(min = 0, max = 20, message = "Broj telefona treba da ima do 20 karaktera.")
	protected String phoneNumber;
	
	@NotBlank(message = "Adresa je obavezno polje.")
	protected String address;
	
	@NotBlank(message = "Grad je obavezno polje.")
	protected String city;
	
	@NotBlank(message = "Drzava je obavezno polje.")
	protected String country;

	public Patient getPatient() {
		Patient pat=new Patient();
		pat.setFirstName(firstName);
		pat.setLastName(lastName);
		pat.setPhoneNumber(phoneNumber);
		pat.setAddress(address);
		pat.setCity(city);
		pat.setCountry(country);
		return pat;
	}
	
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
}
