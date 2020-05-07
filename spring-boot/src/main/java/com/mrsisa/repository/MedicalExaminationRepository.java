package com.mrsisa.repository;


import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mrsisa.entity.examination.MedicalExamination;

public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long>{
	@Query(value = "SELECT * FROM medical_examination me WHERE me.clinic_id = :clinic_id and "
			+ "me.medical_examination_status = :status and date_time > :date", nativeQuery = true)
	Page<MedicalExamination> findByClinicId(Pageable page,@Param("clinic_id") Long id, 
			@Param("status") Integer status, @Param("date") Date date); 
}
