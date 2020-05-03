package com.mrsisa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@DiscriminatorValue("patient")
public class Patient extends UserAccount{
	
	@Column(nullable = false, name="first_name")
	private String firstName;
	
	@Column(nullable = false, name="last_name")
	private String lastName;
	
	@Column(nullable = true, name="phone_number")
	private String phoneNumber;
	
	@Column(nullable = false, name="address")
	private String address;
	
	@Column(nullable = false, name="city")
	private String city;
	
	@Column(nullable = false, name="country")
	private String country;
	
	@Column(unique = true, nullable = false, length = 13, name="jmbg")
	private String jmbg;
	
	@Column(unique = true, nullable = false, length = 11, name="lbo")
	private String lbo;
	
	@Column(unique = true, nullable = false, length = 11, name="zk")
	private String zk;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_record_id", referencedColumnName = "id", unique = true)
	private MedicalRecord medicalRecord;	
	
	@JsonBackReference
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		if(this.medicalRecord==null)
			this.medicalRecord=new MedicalRecord();
		this.medicalRecord.setBloodType(medicalRecord.getBloodType());
		this.medicalRecord.setHeight(medicalRecord.getHeight());
		this.medicalRecord.setWeight(medicalRecord.getWeight());
		this.medicalRecord.setGender(medicalRecord.getGender());
		this.medicalRecord.setDateOfBirth(medicalRecord.getDateOfBirth());
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
