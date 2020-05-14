package com.mrsisa.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.dto.PatientUpdateDTO;
import com.mrsisa.entity.Authority;
import com.mrsisa.entity.Patient;
import com.mrsisa.entity.UserAccount;
import com.mrsisa.entity.appointment.MedicalAppointment;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.exception.NotUniqueException;
import com.mrsisa.repository.PatientRepository;
import com.mrsisa.repository.UserAccountRepository;
import com.mrsisa.service.appointment.MedicalAppointmentService;
import com.mrsisa.service.auth.AuthorityService;
import com.mrsisa.service.mail.MailService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.mail.MessagingException;

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
	private MedicalAppointmentService medicalAppointmentService;
	@Autowired
	private MailService mailService;
	
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
	
	public MedicalAppointment scheduleAppointment(Long examinationId) throws ResourceNotFoundException, MessagingException, IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email=auth.getName();
		Patient patient=findByEmail(email);
		MedicalAppointment medicalEx=null;
		try {
			medicalEx = medicalAppointmentService.scheduleAppointment(examinationId, patient);
			String date=new SimpleDateFormat("dd.MM.yyyy").format(medicalEx.getDateTime());
			String time=new SimpleDateFormat("HH:mm").format(medicalEx.getDateTime());
			mailService.sendMessage(email, "Uspješno ste zakazali pregled za datum "+date
					+ " u "+time+" h.<br> Za više detalja pogledajte istoriju pregleda na našem sajtu.");
		}catch (Exception e) {
			mailService.sendMessage(email, "Nije moguće izvršiti rezervaciju u traženom terminu.");
			throw new ResourceNotFoundException(examinationId+"");
		}
		return medicalEx;
	}
	
	public Page<MedicalAppointment> getAllMedicalAppointments(Pageable pageable) throws ResourceNotFoundException {
		Long id=getPatIdFromAuth();
		Page<MedicalAppointment> medicalEx = medicalAppointmentService.getMedicalExaminationByPatientId(pageable, id);
		return medicalEx;
	}
	
	public boolean cancelAppointment(Long appointmentid) throws ResourceNotFoundException, MessagingException, IOException {
		Long patientId=getPatIdFromAuth();
		String email=getPatEmailFromAuth();
		MedicalAppointment medicalAp = medicalAppointmentService.cancelAppointment(appointmentid, patientId);
		if(medicalAp!=null) {
			String date=new SimpleDateFormat("dd.MM.yyyy").format(medicalAp.getDateTime());
			String time=new SimpleDateFormat("HH:mm").format(medicalAp.getDateTime());
			mailService.sendMessage(email, "Uspješno ste otkazali pregled u klinici '"+medicalAp.getClinic().getName()+"'"
					+ " za datum "+date+" u "+time+".");
			return true;
		}
		mailService.sendMessage(email, "Pregled nije moguće otkazati");
		return false;
	}

	public boolean setDoctorGrade(Long id, int grade) throws ResourceNotFoundException {
		Long patientId=getPatIdFromAuth();
		if(medicalAppointmentService.setDoctorGrade(id, grade, patientId))
			return true;
		return false;
	}
	
	public boolean setClinicGrade(Long id, int grade) throws ResourceNotFoundException {
		Long patientId=getPatIdFromAuth();
		if(medicalAppointmentService.setClinicGrade(id, grade, patientId))
			return true;
		return false;
	}
	
	public Long getPatIdFromAuth() throws ResourceNotFoundException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email=auth.getName();
		return findByEmail(email).getId();
	}
	
	public String getPatEmailFromAuth() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
	
}
