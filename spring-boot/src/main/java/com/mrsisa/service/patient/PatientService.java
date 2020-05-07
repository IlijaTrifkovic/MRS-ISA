package com.mrsisa.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.AuthorityService;
import com.mrsisa.crud.CRUDService;
import com.mrsisa.dto.PatientUpdateDTO;
import com.mrsisa.entity.Authority;
import com.mrsisa.entity.Patient;
import com.mrsisa.entity.UserAccount;
import com.mrsisa.entity.examination.MedicalExamination;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.exception.NotUniqueException;
import com.mrsisa.repository.PatientRepository;
import com.mrsisa.repository.UserAccountRepository;
import com.mrsisa.service.clinic.MedicalExaminationService;

import java.util.Optional;

@Service
public class PatientService extends CRUDService<Patient, Long> {
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserAccountRepository userAccountRepository;
	@Autowired
	private MedicalExaminationService medicalExaminationService;
	
	@Autowired
	
	public PatientService(PatientRepository repo) {
		super(repo);
	}
	
	private boolean isJmbgUnique(String jmbg)  {return !(((PatientRepository) repo).findByJmbg(jmbg).isPresent());}
	
	private boolean isZkUnique(String zk){return !(((PatientRepository) repo).findByZk(zk).isPresent());}
	
	private boolean isLboUnique(String lbo){return !(((PatientRepository) repo).findByLbo(lbo).isPresent());}
	
	private boolean isEmailUnique(String email){return !(((PatientRepository) repo).findByEmail(email).isPresent());}
	
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
		if(!isEmailUnique(p.getEmail())) throw new NotUniqueException("EMAIL");
		return true;
	}
	
	public Patient updatePatient(PatientUpdateDTO patientDTO) throws ResourceNotFoundException{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email=auth.getName();
		Patient p=findByEmail(email);
		p.setFirstName(patientDTO.getFirstName());
		p.setLastName(patientDTO.getLastName());
		p.setPhoneNumber(patientDTO.getPhoneNumber());
		p.setAddress(patientDTO.getAddress());
		p.setCity(patientDTO.getCity());
		p.setCountry(patientDTO.getCountry());
		
		return super.save(p);
	}
	
	public UserAccount changePassword(String email, String oldPassword, String newPassword) throws ResourceNotFoundException {
		UserAccount user = findByEmail(email);
		if (!passwordEncoder.matches(oldPassword, user.getPassword()))
			return null;
		user.setPassword(passwordEncoder.encode(newPassword));
		userAccountRepository.save(user);
		return user;
	}
	
	public void saveMedicalRecord(Patient patient) {
		super.save(patient);
	}
	
	public MedicalExamination reserveMedicalExamination(Long examinationId) throws ResourceNotFoundException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email=auth.getName();
		Patient patient=findByEmail(email);
		MedicalExamination medicalEx = medicalExaminationService.reserveMedicalExamination(examinationId, patient);
		return medicalEx;
	}
	
	public Page<MedicalExamination> getAllMedicalExamination(Pageable pageable) throws ResourceNotFoundException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email=auth.getName();
		Long id=findByEmail(email).getId();
		Page<MedicalExamination> medicalEx = medicalExaminationService.getMedicalExaminationByPatientId(pageable, id);
		return medicalEx;
	}
	
}
