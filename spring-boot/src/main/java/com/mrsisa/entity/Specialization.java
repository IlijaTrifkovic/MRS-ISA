package com.mrsisa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Specialization {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spec_generator")
	@SequenceGenerator(name = "spec_generator", sequenceName = "spec_seq", initialValue = 15)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialization")
	private Set<Doctor> doctor;

	@JsonBackReference
	public Set<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(Set<Doctor> doctor) {
		this.doctor = doctor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Specialization other = (Specialization) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
