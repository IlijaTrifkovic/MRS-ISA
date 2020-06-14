package com.mrsisa.entity;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mrsisa.entity.appointment.MedicalAppointment;

@Entity
@DiscriminatorValue("patient")
public class Patient extends UserAccount{
	
	/**********************/
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<MedicalAppointment> medicalAppointment;
	
	@JsonBackReference
	public Set<MedicalAppointment> getMedicalAppointment() {
		return medicalAppointment;
	}

	public void setMedicalAppointment(Set<MedicalAppointment> medicalAppointment) {
		this.medicalAppointment = medicalAppointment;
	}

	/**********************/

}
