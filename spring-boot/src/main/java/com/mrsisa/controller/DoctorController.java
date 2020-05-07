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

import com.mrsisa.entity.Doctor;
import com.mrsisa.service.clinic.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	//test
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Page<Doctor>> getAll(Pageable pageable){
		Page<Doctor> page = doctorService.findAll(pageable);
		return new ResponseEntity<Page<Doctor>>(page, HttpStatus.OK);
	}
}
