package com.mrsisa.service.clinic;

import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.examination.ExaminationType;
import com.mrsisa.repository.ExaminationTypeRepository;

@Service
public class ExaminationTypeService extends CRUDService<ExaminationType, Long>{

	public ExaminationTypeService(ExaminationTypeRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	

}
