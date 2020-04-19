package com.mrsisa.userdetails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mrsisa.entity.UserAccount;
import com.mrsisa.repository.UserAccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserAccount> optionalUser = userAccountRepository.findByEmail(email);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("User " + email  + " not found."));
		return optionalUser.map(CustomUserDetails::new).get();
	}

}
