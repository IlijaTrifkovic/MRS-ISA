package com.mrsisa.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_generator_seq")
    protected Long id;
	
	@Column(unique = true, nullable = false, name="email")
	protected String email;
	
	@JsonIgnore
	@Column(nullable = false, name="password")
	protected String password;

	@Column(nullable = false, name="active")
	protected Boolean active = false;

	@JsonIgnore
	@Column(name="last_password_change_date")
	protected Timestamp lastPasswordChangeDate;

	@JsonIgnore
	@CreationTimestamp
	protected Date registrationDate;
	
	@ManyToMany(fetch = FetchType.EAGER)
	protected Set<Authority> authorities;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		this.lastPasswordChangeDate = new Timestamp(System.currentTimeMillis());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public Timestamp getLastPasswordChangeDate() {
		return lastPasswordChangeDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastPasswordChangeDate(Timestamp lastPasswordChangeDate) {
		this.lastPasswordChangeDate = lastPasswordChangeDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	@JsonIgnore
	public Set<Authority> getUserAuthorities() {
		if (authorities == null) {
			authorities = new HashSet<>();
		}
		return authorities;
	}
	
	public String getUsername() {
		return this.getEmail(); 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
