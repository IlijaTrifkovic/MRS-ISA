package com.mrsisa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mrsisa.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	Optional<Patient> findByEmail(String email);
	Optional<Patient> findByJmbg(String jmbg);
	Optional<Patient> findByLbo(String lbo);
	Optional<Patient> findByZk(String zk);
	Optional<Patient> findById(Long id);
}