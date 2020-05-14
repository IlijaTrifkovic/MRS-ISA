package com.mrsisa.entity.appointment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrsisa.entity.Doctor;
import com.mrsisa.entity.Patient;
import com.mrsisa.entity.clinic.Clinic;
import com.mrsisa.entity.clinic.Room;

@Entity
public class MedicalAppointment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_generator")
	@SequenceGenerator(name = "exam_generator", sequenceName = "exam_seq")
	private Long id;

	@Column
	private AppointmentStatus appointmentStatus;

	@JsonFormat(pattern = "dd.MM.yyyy - HH:mm", timezone = "Europe/Belgrade")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	@Column
	private int duration;

	@Column
	private Integer doctorGrade;

	@Column
	private Integer clinicGrade;

	@ManyToOne
	@JoinColumn
	private Clinic clinic;

	@ManyToOne
	@JoinColumn
	private Doctor doctor;

	@ManyToOne
	@JoinColumn
	private Patient patient;

	@ManyToOne
	@JoinColumn
	private AppointmentType appointmentType;

	@ManyToOne
	@JoinColumn
	private Room room;

	@Column
	private float price;

	@Column
	private float discount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@JsonBackReference
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Integer getDoctorGrade() {
		return doctorGrade;
	}

	public void setDoctorGrade(Integer doctorGrade) {
		this.doctorGrade = doctorGrade;
	}

	public Integer getClinicGrade() {
		return clinicGrade;
	}

	public void setClinicGrade(Integer clinicGrade) {
		this.clinicGrade = clinicGrade;
	}

}
