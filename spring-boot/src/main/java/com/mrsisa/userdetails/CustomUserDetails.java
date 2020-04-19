package com.mrsisa.userdetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mrsisa.entity.UserAccount;


public class CustomUserDetails extends UserAccount implements UserDetails {
	private static final long serialVersionUID = -7409628553986490588L;
	private Boolean isApi = false;
	
	public CustomUserDetails(UserAccount account) {
		super();
		//this. = account.getId();
		this.email = account.getEmail();
		this.active = account.getActive();
		this.password = account.getPassword();
		this.lastPasswordChangeDate = account.getLastPasswordChangeDate();
		this.registrationDate = account.getRegistrationDate();
		this.firstName=account.getFirstName();
		this.lastName=account.getLastName();
		this.address=account.getAddress();
		this.city=account.getCity();
		this.country=account.getCountry();
		this.lbo=account.getLbo();
		this.authorities=account.getUserAuthorities();
	}
	
	public CustomUserDetails() {
		this.active = true;
		this.isApi=true;
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
		if(!isApi) {
			return super.getUserAuthorities()
					.stream()
					.map(authority -> new SimpleGrantedAuthority("ROLE_" + authority.getAuthority()))
					.collect(Collectors.toSet());
		}
		else {
			List<SimpleGrantedAuthority> auth = new ArrayList<SimpleGrantedAuthority>();
			auth.add(new SimpleGrantedAuthority("ROLE_API"));
			return auth;
		}
		
	}	
		
}