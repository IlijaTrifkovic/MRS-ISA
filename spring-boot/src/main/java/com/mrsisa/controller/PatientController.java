package com.mrsisa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.dto.PasswordDTO;
import com.mrsisa.dto.PatientUpdateDTO;
import com.mrsisa.dto.auth.AuthenticationResponse;
import com.mrsisa.entity.Patient;
import com.mrsisa.entity.UserAccount;
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
}
