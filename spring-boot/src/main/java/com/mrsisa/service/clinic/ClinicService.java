package com.mrsisa.service.clinic;

import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.clinic.Clinic;
import com.mrsisa.repository.ClinicRepository;

@Service
public class ClinicService extends CRUDService<Clinic, Long>{

	public ClinicService(ClinicRepository repo) {
		super(repo);
	}
	
}
