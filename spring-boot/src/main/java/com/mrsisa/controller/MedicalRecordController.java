package com.mrsisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.entity.MedicalRecord;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.service.patient.MedicalRecordService;
import com.mrsisa.service.patient.PatientService;

@RestController
@RequestMapping("medical-record")
public class MedicalRecordController {

	@Autowired
	MedicalRecordService medicalRecordService;
	
	@Autowired
	PatientService patientService;
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public ResponseEntity<MedicalRecord> getOne(@PathVariable Integer id) throws ResourceNotFoundException{		
		return new ResponseEntity<MedicalRecord>(medicalRecordService.findOne(id), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "patient/{id}", method = RequestMethod.GET) 
	public ResponseEntity<MedicalRecord> getByUserId(@PathVariable Integer id) throws ResourceNotFoundException{		
		return new ResponseEntity<MedicalRecord>(patientService.getMedicalRecord(id), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "patient", method = RequestMethod.GET) 
	public ResponseEntity<MedicalRecord> getByUserId() throws ResourceNotFoundException{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		return new ResponseEntity<MedicalRecord>(patientService.getMedicalRecordByEmail(email), HttpStatus.OK);
	}
}
