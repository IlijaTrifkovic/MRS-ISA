package com.mrsisa.entity;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mrsisa.entity.medical_record.MedicalRecord;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_generator_seq", initialValue = 100)
	protected Long id;

	@Column(unique = true, nullable = false, name = "email")
	protected String email;

	@JsonIgnore
	@Column(nullable = false, name = "password")
	protected String password;

	@Column(nullable = false, name = "active")
	protected Boolean active = false;

	@JsonIgnore
	@Column(name = "last_password_change_date")
	protected Timestamp lastPasswordChangeDate;

	@JsonIgnore
	@CreationTimestamp
	protected Date registrationDate;

	@ManyToMany(fetch = FetchType.EAGER)
	protected Set<Authority> authorities;

	@Column(nullable = false, name = "first_name")
	private String firstName;

	@Column(nullable = false, name = "last_name")
	private String lastName;

	@Column(nullable = true, name = "phone_number")
	private String phoneNumber;

	@Column(nullable = false, name = "address")
	private String address;

	@Column(nullable = false, name = "city")
	private String city;

	@Column(nullable = false, name = "country")
	private String country;

	@Column(unique = true, nullable = false, length = 13, name = "jmbg")
	private String jmbg;

	@Column(unique = true, nullable = false, length = 11, name = "lbo")
	private String lbo;

	@Column(unique = true, nullable = false, length = 11, name = "zk")
	private String zk;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "medical_record_id", referencedColumnName = "id", unique = true)
	private MedicalRecord medicalRecord;

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

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getLbo() {
		return lbo;
	}

	public void setLbo(String lbo) {
		this.lbo = lbo;
	}

	public String getZk() {
		return zk;
	}

	public void setZk(String zk) {
		this.zk = zk;
	}

	@JsonBackReference
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
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
