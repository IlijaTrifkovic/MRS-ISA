package com.mrsisa.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.Patient;
import com.mrsisa.entity.medical_record.MedicalRecord;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService extends CRUDService<MedicalRecord, Integer> {
	
	@Autowired
	private PatientService patientService;
	
	public MedicalRecordService(MedicalRecordRepository repo) {
		super(repo);
	}
	
	public MedicalRecord getMedicalRecord(long id) throws ResourceNotFoundException{
		MedicalRecord medicalRecord=patientService.findOne(id).getMedicalRecord();
		return medicalRecord;
	}
	
	public MedicalRecord getMedicalRecordByEmail(String email) throws ResourceNotFoundException{
		MedicalRecord medicalRecord=patientService.findByEmail(email).getMedicalRecord();
		return medicalRecord;
	}
	
	public void setMedicalRecord(long id,MedicalRecord medicalRecord) throws ResourceNotFoundException{
		Patient patient=patientService.findOne(id);
		patient.setMedicalRecord(medicalRecord);
		patientService.saveMedicalRecord(patient);
	}
	
}
