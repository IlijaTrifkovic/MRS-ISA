package com.mrsisa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medical_record_generator")
	@SequenceGenerator(name = "medical_record_generator", sequenceName = "medical_record_seq")
	private Integer id;
	
	@Column
	protected BloodType bloodType ;
	
	@Column(nullable = false)
	protected float height;
	
	@Column(nullable = false)
	protected float weight;
	
	@Column(nullable = false)
	protected Gender gender;
	
	@Column(nullable = false)
	protected Date dateOfBirth;
	
	public Date getDateofBirth() {
		return dateOfBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateOfBirth = dateofBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}


}
