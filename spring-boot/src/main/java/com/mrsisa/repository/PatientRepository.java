package com.mrsisa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mrsisa.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Optional<Patient> findByEmail(String email);
	Optional<Patient> findById(int id);
}