package com.mrsisa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mrsisa.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	@Query(value="SELECT u.id, u.first_name, u.last_name, u.phone_number, u.email, u.jmbg, u.lbo, u.zk, u.address, u.city, u.country, u.password, u.active, u.last_password_change_date, u.registration_date, u.clinic_id, u.specialization_id, u.medical_record_id, "
			+ "AVG(m.doctor_grade) AS grade "
			+ "FROM user_account u "
			+ "LEFT JOIN medical_appointment m "
			+ "ON m.doctor_id = u.id "
			+ "WHERE u.clinic_id = :id "
			+ "GROUP BY u.id ", nativeQuery=true)
	Page<Doctor> getByCliniId(Pageable page, @Param("id") Long id);
}
