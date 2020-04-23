package com.mrsisa.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.mrsisa.entity.Patient;


public class PatientDTO extends PatientUpdateDTO{	
	@NotBlank(message = "Email je obavezno polje.")
	@Email(message = "Email treba da ima format example@mail.com.")
	private String email;
	
	@NotBlank(message = "Jmbg je obavezno polje.")
	@Length(min = 13, max = 13, message = "JMBG treba da ima 13 cifara.")
	private String jmbg;
	
	@NotBlank(message = "LBO je obavezno polje")
	@Length(min = 11, max = 11, message = "LBO treba da ima 11 cifara.")
	private String lbo;
	
	@NotBlank(message = "ZK je obavezno polje")
	@Length(min = 11, max = 11, message = "Broj ZK treba da ima 11 cifara.")
	private String zk;
	
	@NotBlank(message="Lozinka je obavezno polje.")
	@Length(min = 8, max = 25, message = "Lozinka treba da ima izmedju 8 i 25 karaktera.")
	private String password;

	public Patient getPatient() {
		Patient pat=new Patient();
		pat.setFirstName(firstName);
		pat.setLastName(lastName);
		pat.setPhoneNumber(phoneNumber);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
