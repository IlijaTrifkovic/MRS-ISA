package com.mrsisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.entity.medical_record.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer>{
}
