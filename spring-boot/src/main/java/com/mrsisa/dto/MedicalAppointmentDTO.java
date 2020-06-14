package com.mrsisa.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrsisa.entity.Patient;
import com.mrsisa.entity.appointment.AppointmentStatus;
import com.mrsisa.entity.appointment.MedicalAppointment;
import com.mrsisa.entity.appointment.type.AppointmentType;
import com.mrsisa.entity.clinic.Room;

public class MedicalAppointmentDTO {
	private Long id;
	private AppointmentStatus appointmentStatus;
	@JsonFormat(pattern = "dd.MM.yyyy - HH:mm", timezone = "Europe/Belgrade")
	private Date dateTime;
	private Integer doctorGrade;
	private Integer clinicGrade;
	private int duration;
	private ClinicDTO clinic;
	private DoctorDTO doctor;
	private Patient patient;
	private AppointmentType appointmentType;
	private Room room;
	private float price;
	private float discount;

	public MedicalAppointmentDTO(MedicalAppointment medicalAppointment) {
		this.id = medicalAppointment.getId();
		this.appointmentStatus = medicalAppointment.getAppointmentStatus();
		this.dateTime = medicalAppointment.getDateTime();
		this.doctorGrade = medicalAppointment.getDoctorGrade();
		this.clinicGrade = medicalAppointment.getClinicGrade();
		this.clinic = new ClinicDTO(medicalAppointment.getClinic());
		this.doctor = new DoctorDTO(medicalAppointment.getDoctor());
		this.patient = medicalAppointment.getPatient();
		this.appointmentType = medicalAppointment.getAppointmentType();
		this.room = medicalAppointment.getRoom();
		this.price = medicalAppointment.getPrice();
		this.discount = medicalAppointment.getDiscount();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public ClinicDTO getClinic() {
		return clinic;
	}

	public void setClinicDTO(ClinicDTO clinic) {
		this.clinic = clinic;
	}

	public DoctorDTO getDoctor() {
		return doctor;
	}

	public void setDoctorDTO(DoctorDTO doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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

}
