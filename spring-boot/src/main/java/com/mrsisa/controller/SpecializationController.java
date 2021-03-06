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

import com.mrsisa.entity.Specialization;
import com.mrsisa.service.clinic.SpecializationService;

@RestController
@RequestMapping("specialization")
public class SpecializationController {
	@Autowired
	private SpecializationService specializationService;
	
	//test
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Page<Specialization>> getAll(Pageable pageable){
		Page<Specialization> page = specializationService.findAll(pageable);
		return new ResponseEntity<Page<Specialization>>(page, HttpStatus.OK);
	}
	
}
