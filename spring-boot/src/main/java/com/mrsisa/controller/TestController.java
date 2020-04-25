package com.mrsisa.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.dto.PatientDTO;

@RestController
public class TestController {
	
	@RequestMapping(value = "/public/hello", method = RequestMethod.GET)
	public ResponseEntity<String> response() {
		return ResponseEntity.ok("{\"message\":\"hello\"}");
	}
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public ResponseEntity<String> response2(@RequestBody @Valid PatientDTO patientDTO){
		return ResponseEntity.ok("{\"message\":\"hello\"}");
	}
	
	
}
