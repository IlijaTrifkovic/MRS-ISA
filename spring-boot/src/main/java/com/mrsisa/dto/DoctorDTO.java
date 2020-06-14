package com.mrsisa.dto;

import com.mrsisa.entity.Doctor;
import com.mrsisa.entity.Specialization;

public class DoctorDTO {
	protected Long id;
	protected String email;
	private String firstName;
	private String lastName;
	private Float grade;
	private Specialization specialization;
	private ClinicDTO clinic;

	public DoctorDTO(Doctor doctor) {
		this.id = doctor.getId();
		this.email = doctor.getEmail();
		this.firstName = doctor.getFirstName();
		this.lastName = doctor.getLastName();
		this.grade = doctor.getGrade();
		this.specialization = doctor.getSpecialization(); 
	//	this.clinic = new ClinicDTO(doctor.getClinic());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public ClinicDTO getClinic() {
		return clinic;
	}

	public void setClinicDTO(ClinicDTO clinic) {
		this.clinic = clinic;
	}

}
