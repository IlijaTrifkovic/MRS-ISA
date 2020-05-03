package com.mrsisa.dto;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;

import com.mrsisa.entity.BloodType;
import com.mrsisa.entity.Gender;
import com.mrsisa.entity.MedicalRecord;

public class MedicalRecordDTO {

	private BloodType bloodType ;
	
	@NumberFormat
	private float height;

	@NumberFormat
	private float weight;

	private Gender gender;
	
	@Past(message = "Datum rodjenja nije validan")
	private Date dateOfBirth;
	
	public MedicalRecord getMedicalRecord() {
		MedicalRecord medicalRecord=new MedicalRecord();
		medicalRecord.setBloodType(this.getBloodType());
		medicalRecord.setDateOfBirth(this.getDateOfBirth());
		medicalRecord.setGender(this.getGender());
		medicalRecord.setHeight(this.getHeight());
		medicalRecord.setWeight(this.getWeight());
		return medicalRecord;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth){
		this.dateOfBirth=dateOfBirth;
	}
	
}
