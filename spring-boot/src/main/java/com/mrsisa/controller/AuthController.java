package com.mrsisa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.auth.AuthenticationRequest;
import com.mrsisa.auth.AuthenticationResponse;
import com.mrsisa.dto.PatientDTO;
import com.mrsisa.entity.Patient;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.exception.NotUniqueException;
import com.mrsisa.service.auth.AuthService;
import com.mrsisa.service.patient.PatientService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authenticationService;
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authenticationRequest, HttpServletRequest request){		
		String token = authenticationService.login(authenticationRequest.getEmail(), authenticationRequest.getPassword(), request);
		AuthenticationResponse response = new AuthenticationResponse(token);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.PUT)
	public ResponseEntity<Patient> signup(@RequestBody @Valid PatientDTO patientDTO) 
	throws NotUniqueException, ResourceNotFoundException{
		Patient patient=patientDTO.getPatient();	
		patientService.isUnique(patient);
		Patient createdPatient = patientService.save(patient);
		return new ResponseEntity<Patient>(createdPatient, HttpStatus.OK);
	}
	
}