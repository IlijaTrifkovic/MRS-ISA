package com.mrsisa.entity;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mrsisa.entity.appointment.MedicalAppointment;
import com.mrsisa.entity.clinic.Clinic;

@Entity
@DiscriminatorValue("doctor")
public class Doctor extends UserAccount{
	
	private Float grade;
	
	/****************************/
	@ManyToOne
	@JoinColumn
	private Specialization specialization;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	private Set<MedicalAppointment> medicalAppointment;

	@ManyToOne
	@JoinColumn
	private Clinic clinic;
	
	/****************************/
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	private Set<Calendar> calendar;

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	@JsonBackReference
	public Set<MedicalAppointment> getMedicalAppointment() {
		return medicalAppointment;
	}

	public void setMedicalExamination(Set<MedicalAppointment> medicalAppointment) {
		this.medicalAppointment = medicalAppointment;
	}
	
	@JsonBackReference
	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	public Float getGrade() {
		medicalAppointment = getMedicalAppointment();
		int sum=0;
		int i=0;
		for (MedicalAppointment appointment : medicalAppointment) {
			Integer grade = appointment.getDoctorGrade();
			if(grade != null) {
				sum += grade;
				i++;
			}
		}
		if(i>0)
			grade = (float)sum/i;
		return grade;
	}
	
	public void setGrade(Float grade) {
		this.grade=grade;
	}
	
}
