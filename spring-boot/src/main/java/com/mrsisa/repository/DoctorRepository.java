package com.mrsisa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mrsisa.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query(value = "SELECT * FROM user_account u " + "WHERE u.clinic_id = :id ", nativeQuery = true)
	Page<Doctor> getByCliniId(Pageable page, @Param("id") Long id);
}
