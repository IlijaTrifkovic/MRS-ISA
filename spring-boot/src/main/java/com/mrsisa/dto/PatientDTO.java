package com.mrsisa.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.mrsisa.entity.Patient;


public class PatientDTO {
	@NotBlank(message = "Ime je obavezno polje.")
	@Length(min = 1, max = 20, message = "Ime treba da ima izmedju 1 i 20 karaktera.")
	private String firstName;
	
	@NotBlank(message = "Prezime je obavezno polje.")
	@Length(min = 1, max = 20, message = "Prezime treba da ima izmedju 1 i 20 karaktera.")
	private String lastName;
	
	@NotBlank(message = "Email je obavezno polje.")
	@Email(message = "Email treba da ima format example@mail.com.")
	private String email;
	
	@NotBlank(message = "Jmbg je obavezno polje.")
	@Length(min = 13, max = 13, message = "JMBG treba da ima 13 cifara.")
	private String jmbg;
	
	@NotBlank(message = "Jmbg je obavezno polje")
	@Length(min = 11, max = 11, message = "Licni broj osiguranika treba da ima 11 cifara.")
	private String lbo;
	
	@NotBlank(message = "ZK je obavezno polje")
	@Length(min = 11, max = 11, message = "Broj zdravstvene kartice treba da ima 11 cifara.")
	private String zk;
	
	@NotBlank(message = "Adresa je obavezno polje.")
	private String address;
	
	@NotBlank(message = "Grad je obavezno polje.")
	private String city;
	
	@NotBlank(message = "Drzava je obavezno polje.")
	private String country;
	
	@NotBlank(message="Lozinka je obavezno polje.")
	@Length(min = 8, max = 25, message = "Lozinka treba da ima izmedju 8 i 25 karaktera.")
	private String password;

	public Patient getPatient() {
		Patient pat=new Patient();
		pat.setFirstName(firstName);
		pat.setLastName(lastName);
		pat.setEmail(email);
		pat.setJmbg(jmbg);
		pat.setLbo(lbo);
		pat.setZk(zk);
		pat.setAddress(address);
		pat.setCity(city);
		pat.setCountry(country);
		pat.setPassword(password);
		pat.setActive(false);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getLbo() {
		return lbo;
	}

	public void setLbo(String lbo) {
		this.lbo = lbo;
	}

	public String getZk() {
		return zk;
	}

	public void setZk(String zk) {
		this.zk = zk;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
