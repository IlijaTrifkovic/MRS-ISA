package com.mrsisa.service.appointment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.entity.Patient;
import com.mrsisa.entity.appointment.AppointmentStatus;
import com.mrsisa.entity.appointment.MedicalAppointment;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.repository.MedicalAppointmentRepository;
import com.mrsisa.service.mail.MailService;

@Service
public class MedicalAppointmentService extends CRUDService<MedicalAppointment, Long> {
	
	@Autowired
	private MailService mailService;
	
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

	public MedicalAppointment scheduleAppointment(Long medApId, Patient patient)
			throws ResourceNotFoundException {
		MedicalAppointment medicalEx = findFreeAppointmentById(medApId);
		medicalEx.setPatient(patient);
		medicalEx.setAppointmentStatus(AppointmentStatus.SCHEDULED);
		return super.save(medicalEx);
	}

	public Page<MedicalAppointment> findAllByPatientId(Pageable pageable, Long id) throws ResourceNotFoundException {
		Page<MedicalAppointment> page = ((MedicalAppointmentRepository) repo).findByPatientId(pageable, id);
		return page;
	}
	
	
	public boolean setDoctorGrade(Long id, int grade, Long patientId) throws ResourceNotFoundException {
		MedicalAppointment medAppointment = findOne(id);
		if(medAppointment.getAppointmentStatus()==AppointmentStatus.FINISHED) {
			if(medAppointment.getPatient().getId()==patientId && medAppointment.getDoctorGrade()==null) {
				medAppointment.setDoctorGrade(grade);
				super.save(medAppointment);
				return true;
			}
		}
		return false;
	}
	
	public boolean setClinicGrade(Long id, int grade, Long patientId) throws ResourceNotFoundException {
		MedicalAppointment medAppointment = findOne(id);
		if(medAppointment.getAppointmentStatus()==AppointmentStatus.FINISHED) {
			if(medAppointment.getPatient().getId()==patientId && medAppointment.getClinicGrade()==null) {
				medAppointment.setClinicGrade(grade);
				super.save(medAppointment);
				return true;
			}
		}
		return false;
	}
	
	
	@SuppressWarnings("deprecation")
	public MedicalAppointment cancelAppointment(Long medApId, Long patientId, String email) throws ResourceNotFoundException, MessagingException, IOException {
		MedicalAppointment medApp= findOne(medApId);
		Date date=medApp.getDateTime();
		Date currentDate=new Date();
		currentDate.setHours(currentDate.getHours()+24);
		String dt=new SimpleDateFormat("dd.MM.yyyy").format(medApp.getDateTime());
		String time=new SimpleDateFormat("HH:mm").format(medApp.getDateTime());
		if(medApp.getPatient()!=null) {
			if(medApp.getPatient().getId()==patientId) {
				if(currentDate.before(date)) {
					medApp.setAppointmentStatus(AppointmentStatus.CANCELED);
					medApp.setPatient(null);
					return super.save(medApp);
				}else {
					mailService.sendMessage(email, "Pregled za datum "+dt+" u "+time+" nije moguće otkazati, jer je ostalo manje od 24 časa do početka pregleda.");
				}
			}
		}
		return null;
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
		Optional<MedicalAppointment> optional = ((MedicalAppointmentRepository) repo).findPreCreatedApp(id, date);
		if (optional.isPresent())
			return optional.get();
		throw new ResourceNotFoundException(id + "");
	}

}
