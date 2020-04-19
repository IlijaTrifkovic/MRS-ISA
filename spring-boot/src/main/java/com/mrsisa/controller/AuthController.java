package com.mrsisa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.auth.AuthenticationRequest;
import com.mrsisa.auth.AuthenticationResponse;
import com.mrsisa.service.auth.AuthService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authenticationService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authenticationRequest, HttpServletRequest request){		
		String token = authenticationService.login(authenticationRequest.getEmail(), authenticationRequest.getPassword(), request);
		AuthenticationResponse response = new AuthenticationResponse(token);
		return ResponseEntity.ok(response);
	}
	
}