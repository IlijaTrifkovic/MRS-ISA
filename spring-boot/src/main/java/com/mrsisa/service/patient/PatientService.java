package com.mrsisa.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.AuthorityService;
import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.Authority;
import com.mrsisa.entity.Patient;
import com.mrsisa.repository.PatientRepository;

@Service
public class PatientService extends CRUDService<Patient, Integer> {
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthorityService authorityService;
	
	
	public PatientService(PatientRepository repo) {
		super(repo);
	}
	
	@Override
	public Patient save(Patient patient) {
		patient.setPassword(encoder.encode(patient.getPassword()));
		Authority authority = authorityService.findByName("PATIENT");
		patient.getUserAuthorities().add(authority);
		return super.save(patient);
	}
}
