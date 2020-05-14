package com.mrsisa.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.dto.PasswordDTO;
import com.mrsisa.dto.PatientUpdateDTO;
import com.mrsisa.dto.auth.AuthenticationResponse;
import com.mrsisa.entity.Patient;
import com.mrsisa.entity.UserAccount;
import com.mrsisa.entity.appointment.MedicalAppointment;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.service.auth.AuthService;
import com.mrsisa.service.patient.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;
	@Autowired
	private AuthService authService;

	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/profile", method = RequestMethod.GET)
	public ResponseEntity<Patient> getProfile() throws ResourceNotFoundException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		return new ResponseEntity<Patient>(patientService.findByEmail(email), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/profile", method = RequestMethod.POST)
	public ResponseEntity<Patient> updateProfile(@RequestBody @Valid PatientUpdateDTO patientDTO)
			throws ResourceNotFoundException {
		Patient updatePatient = patientService.updatePatient(patientDTO);
		return new ResponseEntity<Patient>(updatePatient, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ResponseEntity<?> passwordChange(@RequestBody @Valid PasswordDTO passwordDTO, HttpServletRequest request)
			throws ResourceNotFoundException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		UserAccount user = patientService.changePassword(email, passwordDTO.getOldPassword(),
				passwordDTO.getNewPassword());
		if (user != null) {
			String token = authService.generateToken(user, request);
			return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(token), HttpStatus.OK);
		} else
			return new ResponseEntity<String>("{\"details\":\"Pogresna lozinka.\"}", HttpStatus.BAD_REQUEST);
	}

	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/appointment/{id}", method = RequestMethod.GET)
	public ResponseEntity<MedicalAppointment> scheduleAppointment(@PathVariable Long id)
			throws ResourceNotFoundException, MessagingException, IOException {
		MedicalAppointment medicalAppointment = patientService.scheduleAppointment(id);
		return new ResponseEntity<MedicalAppointment>(medicalAppointment, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/appointment", method = RequestMethod.GET)
	public ResponseEntity<Page<MedicalAppointment>> getMedicalAppointment(Pageable pageable)
			throws ResourceNotFoundException {
		Page<MedicalAppointment> page = patientService.getAllMedicalAppointments(pageable);
		return new ResponseEntity<Page<MedicalAppointment>>(page, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/appointment/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> cancelAppointment(@PathVariable Long id) throws ResourceNotFoundException, MessagingException, IOException{
		if(patientService.cancelAppointment(id))
			return new ResponseEntity<String>("{\"message\":\"Pregled je otkazan.\"}", HttpStatus.OK);
		return new ResponseEntity<String>("{\"message\":\"Nije moguce otkazati pregled.\"}", HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/appointment/doctor-grade", method = RequestMethod.PUT)
	public ResponseEntity<?> setDoctorGrade(@RequestParam Long id, @RequestParam int grade) throws ResourceNotFoundException{
		if(patientService.setDoctorGrade(id, grade))
			return new ResponseEntity<String>("{\"message\":\"Doktor je ocijenjen.\"}", HttpStatus.OK);
		return new ResponseEntity<String>("{\"message\":\"Nije moguce ocijeniti doktora.\"}", HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/appointment/clinic-grade", method = RequestMethod.PUT)
	public ResponseEntity<?> setClinicGrade(@RequestParam Long id, @RequestParam int grade) throws ResourceNotFoundException{
		if(patientService.setClinicGrade(id, grade))
			return new ResponseEntity<String>("{\"message\":\"Klinika je ocijenjena.\"}", HttpStatus.OK);
		return new ResponseEntity<String>("{\"message\":\"Nije moguce ocijeniti kliniku.\"}", HttpStatus.OK);
	}
}
