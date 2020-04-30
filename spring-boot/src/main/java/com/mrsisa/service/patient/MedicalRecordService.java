package com.mrsisa.service.patient;

import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.MedicalRecord;
import com.mrsisa.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService extends CRUDService<MedicalRecord, Integer> {
	
	public MedicalRecordService(MedicalRecordRepository repo) {
		super(repo);
	}
	
}
