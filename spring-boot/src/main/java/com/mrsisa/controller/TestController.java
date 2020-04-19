package com.mrsisa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/public/hello", method = RequestMethod.GET)
	public ResponseEntity<String> response() {
		return ResponseEntity.ok("{'mars':'mars1'}");
	}
	
	@PreAuthorize("hasAnyRole('NURSE')")
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public ResponseEntity<String> response2(){
		return ResponseEntity.ok("{\"mars\":\"mars2\"}");
	}
	
}