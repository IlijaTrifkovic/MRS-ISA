package com.mrsisa.service.clinic;

import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.Clinic;
import com.mrsisa.repository.ClinicRepository;

@Service
public class ClinicService extends CRUDService<Clinic, Integer>{

	public ClinicService(ClinicRepository repo) {
		super(repo);
	}

}