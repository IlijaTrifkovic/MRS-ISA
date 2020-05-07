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

import com.mrsisa.entity.examination.MedicalExamination;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.service.clinic.MedicalExaminationService;

@RestController
@RequestMapping("examination")
public class MedicalExaminationController {
	@Autowired
	private MedicalExaminationService medicalExaminationService;

	//getAll
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Page<MedicalExamination>> getAll(Pageable pageable) {
		Page<MedicalExamination> page = medicalExaminationService.findAll(pageable);
		return new ResponseEntity<Page<MedicalExamination>>(page, HttpStatus.OK);
	}
	
	
	//getByClinicID
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Page<MedicalExamination>> getMedicalExamination(Pageable pageable,@PathVariable Long id) throws ResourceNotFoundException {
		Page<MedicalExamination> page=medicalExaminationService.getFreeMedicalExaminationByClinicId(pageable, id);
		return new ResponseEntity<Page<MedicalExamination>>(page, HttpStatus.OK);
	}
	

}
