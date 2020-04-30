package com.mrsisa.registration;

import java.util.UUID;

import com.mrsisa.entity.UserAccount;
import com.mrsisa.service.mail.MailService;
import com.mrsisa.userdetails.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    @Autowired
    private CustomUserDetailsService service;

    @Autowired
    private MailService mailService;
   

    @Override
    public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(final OnRegistrationCompleteEvent event) {
        final UserAccount user = event.getUser();
        final String token = UUID.randomUUID().toString();
        service.createVerificationTokenForUser(user, token);

        try {
        	mailService.sendVerificationLink(token, user.getEmail(), event);
        }catch (Exception e) {
        	e.printStackTrace();
		}
    }

    

}
