package com.mrsisa.service.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.mrsisa.entity.UserAccount;
import com.mrsisa.security.DeviceProvider;
import com.mrsisa.security.TokenUtils;
import com.mrsisa.userdetails.CustomUserDetails;
import com.mrsisa.userdetails.CustomUserDetailsService;

@Service
public class AuthService {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenUtils tokenUtils;
	@Autowired
	private DeviceProvider deviceProvider;

	public String login(String email, String password, HttpServletRequest request) {
		// check if user exists
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		// find device
		Device device = deviceProvider.getCurrentDevice(request);
		return this.tokenUtils.generateToken(customUserDetailsService.loadUserByUsername(email), device);
	}
	
	public String generateToken(UserAccount account, HttpServletRequest request) {
		Device device = deviceProvider.getCurrentDevice(request);
		return this.tokenUtils.generateToken(new CustomUserDetails(account), device);
	}
	
	
}
