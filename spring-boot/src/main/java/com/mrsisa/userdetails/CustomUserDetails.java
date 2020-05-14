package com.mrsisa.userdetails;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mrsisa.entity.UserAccount;

public class CustomUserDetails extends UserAccount implements UserDetails {
	private static final long serialVersionUID = -7409628553986490588L;

	public CustomUserDetails(UserAccount account) {
		super();
		this.id = account.getId();
		this.email = account.getEmail();
		this.active = account.getActive();
		this.password = account.getPassword();
		this.lastPasswordChangeDate = account.getLastPasswordChangeDate();
		this.registrationDate = account.getRegistrationDate();
		this.authorities = account.getUserAuthorities();
	}

	public CustomUserDetails() {
		this.active = true;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return super.getActive();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return super.getUserAuthorities().stream()
				.map(authority -> new SimpleGrantedAuthority("ROLE_" + authority.getAuthority()))
				.collect(Collectors.toSet());

	}

}
