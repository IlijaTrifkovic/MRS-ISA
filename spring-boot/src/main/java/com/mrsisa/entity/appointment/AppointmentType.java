package com.mrsisa.entity.appointment;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class AppointmentType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_type_generator")
	@SequenceGenerator(name = "exam_type_generator", sequenceName = "exam_type_seq")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column
	private String description;

	@OneToMany(mappedBy = "appointmentType")
	private Set<MedicalAppointment> medicalAppointments;

	@JsonBackReference
	public Set<MedicalAppointment> getMedicalAppointments() {
		return medicalAppointments;
	}

	public Long getId() {
		return id;
	}

	public void setMedicalAppointments(Set<MedicalAppointment> medicalAppointments) {
		this.medicalAppointments = medicalAppointments;
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
}
