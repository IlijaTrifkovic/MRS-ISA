package com.mrsisa.service.clinic;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.Patient;
import com.mrsisa.entity.examination.MedicalExamination;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.repository.MedicalExaminationRepository;


@Service
public class MedicalExaminationService extends CRUDService<MedicalExamination, Long>{

	private final int STATUS_FREE=0;
	
	public MedicalExaminationService(MedicalExaminationRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	
	@SuppressWarnings("deprecation")
	public Page<MedicalExamination> getFreeMedicalExaminationByClinicId(Pageable pageable,Long id) throws ResourceNotFoundException{
		Date currentDate = new Date();
		currentDate.setHours(currentDate.getHours()+24);
		Page<MedicalExamination> page= ((MedicalExaminationRepository)repo).findByClinicId(pageable, id, STATUS_FREE, currentDate);
		return page;
	}
	
	public Page<MedicalExamination> getMedicalExaminationByPatientId(Pageable pageable, Long id) throws ResourceNotFoundException{
		Page<MedicalExamination> page=((MedicalExaminationRepository)repo).findByPatientId(pageable, id);
		return page;
	}
	
	public MedicalExamination reserveMedicalExamination(Long medExId, Patient patient) throws ResourceNotFoundException {
		MedicalExamination medicalEx = findFreeExaminationById(medExId);
		medicalEx.setPatient(patient);
		return super.save(medicalEx);
	}

	
	public Page<MedicalExamination> findAllByPatientId(Pageable pageable, Long id) throws ResourceNotFoundException{
		Page<MedicalExamination> page = ((MedicalExaminationRepository)repo).findByPatientId(pageable, id);
		return page;
	}
	
//	private MedicalExamination findById(Long id) throws ResourceNotFoundException{
//		Optional<MedicalExamination> optional=((MedicalExaminationRepository)repo).findById(id);
//		if(optional.isPresent())
//			return optional.get();
//		throw new ResourceNotFoundException(id+"");
//	}
	
	@SuppressWarnings("deprecation")
	private MedicalExamination findFreeExaminationById(Long id) throws ResourceNotFoundException{
		Date date = new Date();
		date.setHours(date.getHours()+24);
		Optional<MedicalExamination> optional=((MedicalExaminationRepository)repo).findById(id, date, STATUS_FREE);
		if(optional.isPresent())
			return optional.get();
		throw new ResourceNotFoundException(id+"");
	}
}

