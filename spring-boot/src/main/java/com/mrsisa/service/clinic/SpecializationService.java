package com.mrsisa.service.clinic;

import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.Specialization;
import com.mrsisa.repository.SpecializationRepository;

@Service
public class SpecializationService extends CRUDService<Specialization, Long>{

	public SpecializationService(SpecializationRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

}
