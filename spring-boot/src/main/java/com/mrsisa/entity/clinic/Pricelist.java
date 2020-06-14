package com.mrsisa.entity.clinic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mrsisa.entity.appointment.type.AppointmentType;

@Entity
public class Pricelist {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pricelist_generator")
	@SequenceGenerator(name = "pricelist_generator", sequenceName = "price_seq", initialValue = 100)
	private Long id;

	@Column
	private Float price;

	@JsonIgnore
	@Column
	private Boolean active;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private AppointmentType appointmentType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Clinic clinic;

	@JsonIgnore
	@CreationTimestamp
	private Date registrationDate;

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
