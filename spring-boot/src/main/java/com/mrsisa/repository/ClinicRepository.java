package com.mrsisa.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mrsisa.entity.clinic.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long>{
	
	@Query(value = "SELECT c.id, c.name, c.description, c.address, c.city, c.country, c.registration_date, "
			+ "AVG(m.clinic_grade) AS grade FROM clinic c "
			+ "LEFT JOIN medical_appointment m "
			+ "ON m.clinic_id = c.id "
			+ "WHERE c.id = :id "
			+ "GROUP BY c.id", nativeQuery = true)
	Clinic getOne(@Param("id") Long id);
	
	
	@Query(value = "SELECT c.id, c.name, c.description, c.address, c.city, c.country, c.registration_date, "
			+ "AVG(m.clinic_grade) AS grade FROM clinic c "
			+ "LEFT JOIN medical_appointment m "
			+ "ON m.clinic_id = c.id "
			+ "GROUP BY c.id", nativeQuery = true)
	Page<Clinic> getAll(Pageable pageable);
}
