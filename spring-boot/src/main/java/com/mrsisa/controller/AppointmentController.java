package com.mrsisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.entity.appointment.MedicalAppointment;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.service.appointment.MedicalAppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
	@Autowired
	private MedicalAppointmentService medicalAppointmentService;

	//getAll
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Page<MedicalAppointment>> getAll(Pageable pageable) {
		Page<MedicalAppointment> page = medicalAppointmentService.findAll(pageable);
		return new ResponseEntity<Page<MedicalAppointment>>(page, HttpStatus.OK);
	}
	
	
	//getByClinicID
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Page<MedicalAppointment>> getMedicalAppointment(Pageable pageable,@PathVariable Long id) throws ResourceNotFoundException {
		Page<MedicalAppointment> page=medicalAppointmentService.getFreeAppointmentsByClinicId(pageable, id);
		return new ResponseEntity<Page<MedicalAppointment>>(page, HttpStatus.OK);
	}
}
