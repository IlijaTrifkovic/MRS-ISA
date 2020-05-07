package com.mrsisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
}
