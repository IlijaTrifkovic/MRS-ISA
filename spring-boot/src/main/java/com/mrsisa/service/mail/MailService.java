package com.mrsisa.service.mail;

import org.springframework.stereotype.Service;

import com.mrsisa.config.HtmlResponse;
import com.mrsisa.registration.OnRegistrationCompleteEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendVerificationLink(String token, String email, final OnRegistrationCompleteEvent event)
			throws MessagingException, IOException{
		
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true,"UTF-8");
		 
	    helper.setTo(email);
	    
	    helper.setSubject("Aktivacija naloga");
	    helper.setText("<span style=\"color:black;\">"
	    		 		+"<h1><span style=\"color:rgb(15, 146, 113);\">KLINIČKI</span> centar</h1>"
	    		 		+"<p>Poštovani,</p>"
	    		 		+"<p>Vaš nalog možete aktvirati klikom na link:<br>"
	    		 		+"<a href='"+event.getAppUrl() + "/registrationConfirm?token=" + token+"'>aktiviraj nalog</a></p>"
	    		 		+"<p>U slučaju da niste poslali zahtjev za registraciju, ignorišite ovu poruku.</p>"
	    		 		+"<br>Srdačan pozdrav,<br>Klinički centar<br>"
	    		 		+"<a href=\""+HtmlResponse.CLIENT_URL+"\">"+HtmlResponse.CLIENT_URL+"</a>"
	    		 		+"</span"
	    		 		,true);
	     

	    javaMailSender.send(msg);
	}
}
