package com.mrsisa.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.AuthorityService;
import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.Authority;
import com.mrsisa.entity.Patient;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.exception.NotUniqueException;
import com.mrsisa.repository.PatientRepository;


import java.util.Optional;

@Service
public class PatientService extends CRUDService<Patient, Integer> {
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	
	public PatientService(PatientRepository repo) {
		super(repo);
	}
	
	private boolean isJmbgUnique(String jmbg)  {
		Optional<Patient> optionalPatient=((PatientRepository) repo).findByJmbg(jmbg);
		if (optionalPatient.isPresent()) 
			return false;
		return true;
	}
	
	private boolean isZkUnique(String zk){
		Optional<Patient> optionalPatient=((PatientRepository) repo).findByZk(zk);
		if (optionalPatient.isPresent()) 
			return false;
		return true;
	}
	
	private boolean isLboUnique(String lbo){
		Optional<Patient> optionalPatient=((PatientRepository) repo).findByLbo(lbo);
		if (optionalPatient.isPresent())
			return false;
		return true;
	}
	
	private boolean isEmailUnique(String email){
		Optional<Patient> optionalPatient=((PatientRepository) repo).findByEmail(email);
		if (optionalPatient.isPresent())
			return false;
		return true;
	}
	
	public Patient findByEmail(String email) throws ResourceNotFoundException {
		Optional<Patient> optionalPatient=((PatientRepository) repo).findByEmail(email);
		if (optionalPatient.isPresent()) {
			return optionalPatient.get();
		}
		throw new ResourceNotFoundException(email+"");
	}
	
	@Override
	public Patient save(Patient patient){
		patient.setPassword(encoder.encode(patient.getPassword()));
		Authority authority = authorityService.findByName("PATIENT");
		patient.getUserAuthorities().add(authority);
		return super.save(patient);
	}
	
	public boolean isUnique(Patient p) throws NotUniqueException{
		if(!isJmbgUnique(p.getJmbg())) throw new NotUniqueException("JMBG");
		if(!isLboUnique(p.getLbo())) throw new NotUniqueException("LBO");
		if(!isZkUnique(p.getZk())) throw new NotUniqueException("ZK");
		if(!isEmailUnique(p.getEmail())) throw new NotUniqueException("Email");
		return true;
	}
}
