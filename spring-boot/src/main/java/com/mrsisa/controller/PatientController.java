package com.mrsisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.entity.Patient;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.service.patient.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "patient/profile", method = RequestMethod.GET)
	public ResponseEntity<Patient> getProfile() throws ResourceNotFoundException{
		System.out.println("DA");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("NE");
		String email=auth.getName();
		System.out.println(email+" :mail");
		return new ResponseEntity<Patient>(patientService.findByEmail(email), HttpStatus.OK);
	}
}
