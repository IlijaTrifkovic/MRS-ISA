package com.mrsisa.service.clinic;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.examination.MedicalExamination;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.repository.MedicalExaminationRepository;

@Service
public class MedicalExaminationService extends CRUDService<MedicalExamination, Long>{

	public MedicalExaminationService(MedicalExaminationRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	
	@SuppressWarnings("deprecation")
	public Page<MedicalExamination> getFreeMedicalExaminationByClinicId(Pageable pageable,Long id) throws ResourceNotFoundException{
		Date currentDate = new Date();
		currentDate.setHours(currentDate.getHours()+24);
		final int STATUS_FREE=0;
		Page<MedicalExamination> page= ((MedicalExaminationRepository)repo).findByClinicId(pageable, id, STATUS_FREE, currentDate);
		return page;
	}
	
	
}

