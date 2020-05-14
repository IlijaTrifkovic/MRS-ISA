package com.mrsisa.service.auth;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.Authority;
import com.mrsisa.entity.UserAccount;
import com.mrsisa.repository.AuthorityRepository;
import com.mrsisa.security.DeviceProvider;
import com.mrsisa.security.TokenUtils;
import com.mrsisa.userdetails.CustomUserDetails;
import com.mrsisa.userdetails.CustomUserDetailsService;


@Service
public class AuthorityService extends CRUDService<Authority, Integer>{
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenUtils tokenUtils;
	@Autowired
	private DeviceProvider deviceProvider;
	
	@Autowired
	public AuthorityService(AuthorityRepository repo) {
		super(repo);
	}
	
	public Authority findByName(String name) {
		Authority ret = null;
		Optional<Authority> authority = ((AuthorityRepository)repo).findByName(name);
		if(authority.isPresent()) {
			ret = authority.get();
		}
		else {
			Authority auth = new Authority();
			auth.setName(name);
			ret = save(auth);
		}
		return ret;
	}
	
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
