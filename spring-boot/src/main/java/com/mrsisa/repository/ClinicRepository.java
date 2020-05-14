package com.mrsisa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.entity.clinic.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long>{
//	@Query(value = "SELECT * from clinic", nativeQuery = true)
//	Page<Clinic> findById(Pageable page, Long id);
}
