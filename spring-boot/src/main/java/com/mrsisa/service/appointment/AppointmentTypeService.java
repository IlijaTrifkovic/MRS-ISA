package com.mrsisa.service.appointment;

import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.appointment.type.AppointmentType;
import com.mrsisa.repository.AppointmentTypeRepository;

@Service
public class AppointmentTypeService  extends CRUDService<AppointmentType, Long>{
	
	public AppointmentTypeService(AppointmentTypeRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
		
		
	}
}
