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
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nurse_id_generator")
	@SequenceGenerator(name = "nurse_id_generator", sequenceName = "nurse_id_generator_seq")
    private Long id;

	@Column(nullable = false, name="first_name")
	protected String firstName;
	
	@Column(nullable = false, name="last_name")
	protected String lastName;
	
	@Column(unique = true, nullable = false, name="email")
	protected String email;
	
	@Column(unique = true, nullable = false, length = 11, name="lbo")
	protected String lbo;
	
	@Column(nullable = false, name="address")
	protected String address;
	
	@Column(nullable = false, name="city")
	protected String city;
	
	@Column(nullable = false, name="country")
	protected String country;
	
	@JsonIgnore
	@Column(nullable = false, name="password")
	protected String password;

	@Column(nullable = false, name="active")
	protected Boolean active = true;

	@JsonIgnore
	@Column(name="last_password_change_date")
	protected Timestamp lastPasswordChangeDate;


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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLbo() {
		return lbo;
	}

	public void setLbo(String lbo) {
		this.lbo = lbo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
			System.out.println("BRATE KAKO NULL!");
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
