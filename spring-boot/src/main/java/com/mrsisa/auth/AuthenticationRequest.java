package com.mrsisa.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class AuthenticationRequest {
	@NotBlank(message = "Email je obavezno polje.")
	@Email(message = "Email treba da ima format example@mail.com.")
	private String email;

	@NotBlank(message="Lozinka je obavezno polje.")
	@Length(min = 8, max = 25, message = "Lozinka treba da ima izmedju 8 i 25 karaktera.")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
