package com.mrsisa.service.appointment;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.Patient;
import com.mrsisa.entity.appointment.MedicalAppointment;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.repository.MedicalAppointmentRepository;

@Service
public class MedicalAppointmentService extends CRUDService<MedicalAppointment, Long> {

	private final int STATUS_FREE = 0;
	
	public MedicalAppointmentService(MedicalAppointmentRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("deprecation")
	public Page<MedicalAppointment> getFreeAppointmentsByClinicId(Pageable pageable, Long id)
			throws ResourceNotFoundException {
		Date currentDate = new Date();
		currentDate.setHours(currentDate.getHours() + 24);
		Page<MedicalAppointment> page = ((MedicalAppointmentRepository) repo).findByClinicId(pageable, id, currentDate);
		return page;
	}

	public Page<MedicalAppointment> getMedicalExaminationByPatientId(Pageable pageable, Long id)
			throws ResourceNotFoundException {
		Page<MedicalAppointment> page = ((MedicalAppointmentRepository) repo).findByPatientId(pageable, id);
		return page;
	}

	public MedicalAppointment scheduleAppointment(Long medExId, Patient patient)
			throws ResourceNotFoundException {
		MedicalAppointment medicalEx = findFreeAppointmentById(medExId);
		medicalEx.setPatient(patient);
		return super.save(medicalEx);
	}

	public Page<MedicalAppointment> findAllByPatientId(Pageable pageable, Long id) throws ResourceNotFoundException {
		Page<MedicalAppointment> page = ((MedicalAppointmentRepository) repo).findByPatientId(pageable, id);
		return page;
	}

//	private MedicalExamination findById(Long id) throws ResourceNotFoundException{
//		Optional<MedicalExamination> optional=((MedicalExaminationRepository)repo).findById(id);
//		if(optional.isPresent())
//			return optional.get();
//		throw new ResourceNotFoundException(id+"");
//	}

	@SuppressWarnings("deprecation")
	private MedicalAppointment findFreeAppointmentById(Long id) throws ResourceNotFoundException {
		Date date = new Date();
		date.setHours(date.getHours() + 24);
		Optional<MedicalAppointment> optional = ((MedicalAppointmentRepository) repo).findById(id, date, STATUS_FREE);
		if (optional.isPresent())
			return optional.get();
		throw new ResourceNotFoundException(id + "");
	}

}
