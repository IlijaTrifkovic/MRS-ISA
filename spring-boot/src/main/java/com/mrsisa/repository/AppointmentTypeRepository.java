package com.mrsisa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mrsisa.entity.appointment.type.AppointmentType;

public interface AppointmentTypeRepository extends JpaRepository<AppointmentType, Long> {
	@Query(value = "SELECT * FROM appointment_type WHERE status", nativeQuery = true)
	Page<AppointmentType> findAll(Pageable pageable);
}
