package com.mrsisa.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendar_generator")
	@SequenceGenerator(name = "calendar_generator", sequenceName = "cal_seq", initialValue = 15)
	private Long id;
	
	@Column
	private LocalDate date;
	
	@Column
	private LocalTime startTime;
	
	@Column
	private LocalTime endTime;
	
	@ManyToOne
	@JoinColumn
	private Doctor doctor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
}
