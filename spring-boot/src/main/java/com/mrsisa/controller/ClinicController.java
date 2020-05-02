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

import com.mrsisa.entity.Clinic;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.service.clinic.ClinicService;

@RestController
@RequestMapping("clinic")
public class ClinicController {
	
	@Autowired
	ClinicService clinicService;
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Clinic>> getAll(Pageable pageable){
		Page<Clinic> page = clinicService.findAll(pageable);
		return new ResponseEntity<Page<Clinic>>(page, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Clinic> getOne(@PathVariable Long id) throws ResourceNotFoundException{		
		return new ResponseEntity<Clinic>(clinicService.findOne(id), HttpStatus.OK);
	}
	
	
	
}
