package com.mrsisa.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class PasswordDTO {
	@NotBlank(message = "Unesite staru lozinku.")
	@Length(min = 8, max = 25, message = "Lozinka treba da ima izmedju 8 i 25 karaktera.")
	private String oldPassword;
	
	@NotBlank(message = "Unesite novu lozinku.")
	@Length(min = 8, max = 25, message = "Lozinka treba da ima izmedju 8 i 25 karaktera.")
	private String newPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
