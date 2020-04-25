package com.mrsisa.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.auth.AuthenticationRequest;
import com.mrsisa.auth.AuthenticationResponse;
import com.mrsisa.dto.PatientDTO;
import com.mrsisa.entity.Patient;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.registration.OnRegistrationCompleteEvent;
import com.mrsisa.exception.NotUniqueException;
import com.mrsisa.service.auth.AuthService;
import com.mrsisa.service.patient.PatientService;
import com.mrsisa.userdetails.CustomUserDetailsService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authenticationService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	CustomUserDetailsService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authenticationRequest, HttpServletRequest request){		
		String token = authenticationService.login(authenticationRequest.getEmail(), authenticationRequest.getPassword(), request);
		AuthenticationResponse response = new AuthenticationResponse(token);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> signup(@RequestBody @Valid PatientDTO patientDTO, final HttpServletRequest request) 
	throws NotUniqueException, ResourceNotFoundException{
		Patient patient=patientDTO.getPatient();	
		patientService.isUnique(patient);
		Patient createdPatient = patientService.save(patient);
		eventPublisher.publishEvent(new OnRegistrationCompleteEvent(createdPatient, request.getLocale(), getAppUrl(request)));
		return new ResponseEntity<Patient>(createdPatient, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET, produces = "text/html;charset=utf8")
    public ResponseEntity<?> confirmRegistration(@RequestParam("token") final String token) throws UnsupportedEncodingException {
        final String result = userService.validateVerificationToken(token);
        if (result.equals("valid")) {
            return ResponseEntity.ok("Vas nalog je aktiviran");
        }
        return ResponseEntity.ok("Greska: token-"+result);
    }
	
	
	private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
	
	
	
}