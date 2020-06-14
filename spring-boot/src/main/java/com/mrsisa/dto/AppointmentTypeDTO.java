package com.mrsisa.dto;

import com.mrsisa.entity.appointment.type.AppointmentType;

public class AppointmentTypeDTO {
	private Long id;
	private String name;
	private String description;
	
	public AppointmentTypeDTO(AppointmentType at) {
		this.id = at.getId();
		this.name = at.getName();
		this.description = at.getDescription();
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
	
}
