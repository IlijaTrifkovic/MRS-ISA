package com.mrsisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.dto.AppointmentTypeDTO;
import com.mrsisa.entity.appointment.type.AppointmentType;
import com.mrsisa.service.appointment.AppointmentTypeService;

@RestController
@RequestMapping("appointment_type")
public class AppointmentTypeController {

	@Autowired
	private AppointmentTypeService appointmentTypeService;
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<AppointmentTypeDTO>> getAll(Pageable pageable){
		Page<AppointmentType> page = appointmentTypeService.findAll(pageable);
		Page<AppointmentTypeDTO> pageDto = page.map(obj -> new AppointmentTypeDTO(obj));
		return new ResponseEntity<Page<AppointmentTypeDTO>>(pageDto, HttpStatus.OK);
	}
	
}
