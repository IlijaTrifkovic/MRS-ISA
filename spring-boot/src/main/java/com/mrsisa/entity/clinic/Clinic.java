package com.mrsisa.entity.clinic;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mrsisa.entity.Doctor;
import com.mrsisa.entity.examination.MedicalExamination;

@Entity
public class Clinic {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clinic_generator")
	@SequenceGenerator(name = "clinic_generator", sequenceName = "clinic_seq")
	private Long id;
	
	@Column(nullable = false, name="name")
	private String name;
	
	@Column(name="description", columnDefinition="text")
	private String description;
	
	@Column(nullable = false, name="address")
	private String address;
	
	@Column(nullable = false, name="city")
	private String city;
	
	@Column(nullable = false, name="country")
	private String country;
	
	@Column(nullable = false, name="grade")
	private float grade;

	
	/******************************/
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinic")
	private Set<Doctor> doctor;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinic")
	private Set<MedicalExamination> medicalExamination;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinic")
	private Set<Room> room;
	/******************************/
	
	@CreationTimestamp
	private Date registrationDate;
	
	public float getGrade() {
		return grade;
	}

	@JsonBackReference
	public Set<Doctor> getDoctors() {
		return doctor;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctor = doctors;
	}

	@JsonBackReference
	public Set<MedicalExamination> getMedicalExaminations() {
		return medicalExamination;
	}

	public void setMedicalExaminations(Set<MedicalExamination> medicalExaminations) {
		this.medicalExamination = medicalExaminations;
	}

	@JsonBackReference
	public Set<Room> getRooms() {
		return room;
	}

	public void setRooms(Set<Room> rooms) {
		this.room = rooms;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clinic other = (Clinic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
