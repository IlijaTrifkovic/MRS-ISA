package com.mrsisa.service.clinic;

import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.AdminCC;
import com.mrsisa.repository.AdminCCRepository;

@Service
public class AdminCCService extends CRUDService<AdminCC, Long>{

	public AdminCCService(AdminCCRepository repo) {
		super(repo);
	}

}
