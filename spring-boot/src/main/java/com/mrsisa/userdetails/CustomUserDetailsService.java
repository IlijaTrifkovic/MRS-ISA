package com.mrsisa.userdetails;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mrsisa.entity.UserAccount;
import com.mrsisa.registration.VerificationToken;
import com.mrsisa.repository.UserAccountRepository;
import com.mrsisa.repository.VerificationTokenRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserAccountRepository userAccountRepository;
	@Autowired
	private VerificationTokenRepository tokenRepository;
	
	
	public static final String TOKEN_INVALID = "Token nije validan.";
	public static final String TOKEN_EXPIRED = "Token je istekao.";
	public static final String TOKEN_VALID = "valid";
	
	 
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserAccount> optionalUser = userAccountRepository.findByEmail(email);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("User " + email  + " not found."));
		return optionalUser.map(CustomUserDetails::new).get();
	}
	
    public void createVerificationTokenForUser(final UserAccount user, final String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }
    
    public String validateVerificationToken(String token) {
        final VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken == null) {
            return TOKEN_INVALID;
        }

        final UserAccount user = verificationToken.getUser();
        final Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate()
            .getTime() - cal.getTime()
            .getTime()) <= 0) {
            tokenRepository.delete(verificationToken);
            return TOKEN_EXPIRED;
        }

        user.setActive(true);
        tokenRepository.delete(verificationToken);
        userAccountRepository.save(user);
        return TOKEN_VALID;
    }

}
