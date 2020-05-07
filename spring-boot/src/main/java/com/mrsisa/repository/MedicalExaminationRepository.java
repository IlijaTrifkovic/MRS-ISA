package com.mrsisa.repository;


import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mrsisa.entity.examination.MedicalExamination;

public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long>{
	Optional<MedicalExamination> findById(Long id);
	
	@Query(value = "SELECT * FROM medical_examination me WHERE me.clinic_id = :clinic_id and "
			+ "me.medical_examination_status = :status and date_time > :date and "
			+ "me.patient_id IS NULL", nativeQuery = true)
	Page<MedicalExamination> findByClinicId(Pageable page, @Param("clinic_id") Long id, 
			@Param("status") Integer status, @Param("date") Date date); 
	
	@Query(value = "SELECT * FROM medical_examination me WHERE me.patient_id = :patient_id", nativeQuery = true)
	Page<MedicalExamination> findByPatientId(Pageable page, @Param("patient_id") Long id); 
	
	@Query(value = "SELECT * FROM medical_examination me WHERE id = :id and "
			+ "me.medical_examination_status = :status and date_time > :date and "
			+ "me.patient_id IS NULL", nativeQuery = true)
	Optional<MedicalExamination> findById(@Param("id") Long id,@Param("date") Date date ,@Param("status") int status);

}
