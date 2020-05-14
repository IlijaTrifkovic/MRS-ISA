package com.mrsisa.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mrsisa.entity.appointment.MedicalAppointment;

public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {
	Optional<MedicalAppointment> findById(Long id);

	@Query(value = "SELECT * FROM medical_appointment me WHERE me.clinic_id = :clinic_id and "
			+ "date_time > :date and (me.appointment_status = 0 OR me.appointment_status = 1)", nativeQuery = true)
	Page<MedicalAppointment> findByClinicId(Pageable page, @Param("clinic_id") Long id, @Param("date") Date date);

	@Query(value = "SELECT * FROM medical_appointment me WHERE me.patient_id = :patient_id", nativeQuery = true)
	Page<MedicalAppointment> findByPatientId(Pageable page, @Param("patient_id") Long id);

	@Query(value = "SELECT * FROM medical_appointment me WHERE id = :id and "
			+ "(me.appointment_status = 0 OR me.appointment_status = 1) and date_time > :date and "
			+ "me.patient_id IS NULL", nativeQuery = true)
	Optional<MedicalAppointment> findPreCreatedApp(@Param("id") Long id, @Param("date") Date date);
	
	
}
