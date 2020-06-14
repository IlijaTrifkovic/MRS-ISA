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

import com.mrsisa.dto.DoctorDTO;
import com.mrsisa.entity.Doctor;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.service.clinic.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	//test
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Page<DoctorDTO>> getAll(Pageable pageable){
		Page<Doctor> page = doctorService.findAll(pageable);
		Page<DoctorDTO> pageDto = page.map(obj -> new DoctorDTO(obj));
		return new ResponseEntity<Page<DoctorDTO>>(pageDto, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DoctorDTO> getById(@PathVariable Long id) throws ResourceNotFoundException{
		DoctorDTO doctor = new DoctorDTO(doctorService.findOne(id));
		return new ResponseEntity<DoctorDTO>(doctor, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "clinic/{id}", method = RequestMethod.GET)
	public ResponseEntity<Page<DoctorDTO>> getAllByClinicId(Pageable pageable, @PathVariable Long id){
		Page<Doctor> page = doctorService.getDoctorListByClinicId(pageable, id);
		Page<DoctorDTO> pageDto = page.map(obj -> new DoctorDTO(obj));
		return new ResponseEntity<Page<DoctorDTO>>(pageDto, HttpStatus.OK);
	}
}
