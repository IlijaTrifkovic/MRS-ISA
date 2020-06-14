package com.mrsisa.service.clinic;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.appointment.MedicalAppointment;
import com.mrsisa.entity.clinic.Clinic;
import com.mrsisa.repository.ClinicRepository;

@Service
public class ClinicService extends CRUDService<Clinic, Long>{

	public ClinicService(ClinicRepository repo) {
		super(repo);
	}

	public void avgGrade(Page<Clinic> page) {
		for (Clinic clinic : page) {
			float avgGrade=0;
			int index=0;
			Set<MedicalAppointment> medApp=clinic.getMedicalAppointments();
			for (MedicalAppointment mApp : medApp) {
				if(mApp.getClinicGrade()!=null) {
					avgGrade+=mApp.getClinicGrade();
					index++;
				}
			}
			if(index>0) {
				avgGrade=avgGrade/index;
				clinic.setGrade(avgGrade);
			}
		}
	}
	
}
