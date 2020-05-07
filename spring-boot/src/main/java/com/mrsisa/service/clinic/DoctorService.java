package com.mrsisa.service.clinic;

import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.Doctor;
import com.mrsisa.repository.DoctorRepository;

@Service
public class DoctorService extends CRUDService<Doctor, Long>{

	public DoctorService(DoctorRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

}
