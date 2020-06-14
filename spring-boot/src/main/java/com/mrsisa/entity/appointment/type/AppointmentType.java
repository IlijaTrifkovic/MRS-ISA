package com.mrsisa.entity.appointment.type;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mrsisa.entity.Specialization;
import com.mrsisa.entity.appointment.MedicalAppointment;
import com.mrsisa.entity.clinic.Pricelist;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	
	@Column 
	private int duration;
	
	@Column
	private Boolean status;
	
	@Column
	private Type type;
	
	@OneToMany(mappedBy = "appointmentType", fetch = FetchType.LAZY)
	private Set<MedicalAppointment> medicalAppointments;
	
	@OneToMany(mappedBy = "appointmentType", fetch = FetchType.LAZY)
	private Set<Pricelist> priceList;
	
	@ManyToOne
	@JoinColumn
	private Specialization specialization;
	
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@JsonBackReference
	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	@JsonBackReference
	public Set<Pricelist> getPriceList() {
		return priceList;
	}

	public void setPriceList(Set<Pricelist> priceList) {
		this.priceList = priceList;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
