package com.mrsisa.service.appointment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mrsisa.crud.CRUDService;
import com.mrsisa.dto.MedicalAppointmentDTO;
import com.mrsisa.entity.Patient;
import com.mrsisa.entity.appointment.AppointmentStatus;
import com.mrsisa.entity.appointment.MedicalAppointment;
import com.mrsisa.exception.CustomException;
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
	public Page<MedicalAppointmentDTO> getFreeAppointmentsByClinicId(Pageable pageable, Long id)
			throws ResourceNotFoundException {
		Date currentDate = new Date();
		currentDate.setHours(currentDate.getHours() + 24);
		Page<MedicalAppointment> page = ((MedicalAppointmentRepository) repo).findByClinicId(pageable, id, currentDate);
		Page<MedicalAppointmentDTO> pageDto = page.map(obj -> new MedicalAppointmentDTO(obj));
		return pageDto;
	}

	public Page<MedicalAppointmentDTO> getMedicalExaminationByPatientId(Pageable pageable, Long id)
			throws ResourceNotFoundException {
		Page<MedicalAppointment> page = ((MedicalAppointmentRepository) repo).findByPatientId(pageable, id);
		Page<MedicalAppointmentDTO> pageDto = page.map(obj -> new MedicalAppointmentDTO(obj));
		return pageDto;
	}

	@SuppressWarnings("deprecation")
	public MedicalAppointment scheduleAppointment(Long medApId, Patient patient) throws ResourceNotFoundException, CustomException {
		MedicalAppointment medicalEx = findFreeAppointmentById(medApId);
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
		if(!isAbleToSchedule(medicalEx.getDateTime(), medicalEx.getAppointmentType().getDuration(), patient.getId())){
			Date d = medicalEx.getDateTime();
			Date d2 = (Date )medicalEx.getDateTime().clone();
			d2.setMinutes(d2.getMinutes()+medicalEx.getAppointmentType().getDuration());
			throw new CustomException("Nije moguce zakazati pregled '"+medicalEx.getAppointmentType().getName()+"' "
					+"za datum "+format.format(medicalEx.getDateTime())+" od "
					+format2.format(d)+" do "+format2.format(d2)+". U navedenom terminu vec imate zakazan pregled/operaciju.");
		}
		medicalEx.setPatient(patient);
		medicalEx.setAppointmentStatus(AppointmentStatus.SCHEDULED);
		return super.save(medicalEx);
	}

	@SuppressWarnings("deprecation")
	public List<MedicalAppointment> findByPatientIdAndDate(Long patientId, Date date) {
		Date sDate = (Date) date.clone();
		sDate.setHours(0);
		sDate.setMinutes(0);
		sDate.setSeconds(0);
		Date eDate = (Date) date.clone();
		eDate.setHours(23);
		eDate.setMinutes(59);
		eDate.setSeconds(59);
		List<MedicalAppointment> list = ((MedicalAppointmentRepository) repo).getByPatientIdAndDate(patientId, sDate,
				eDate);
		return list;
	}

	@SuppressWarnings("deprecation")
	public boolean isAbleToSchedule(Date date, int duration, Long patientId) {
		List<MedicalAppointment> list = findByPatientIdAndDate(patientId, date);
		Date endDate = (Date) date.clone();
		endDate.setMinutes(endDate.getMinutes() + duration);
		for (MedicalAppointment medicalAppointment : list) {
			Date sDate = medicalAppointment.getDateTime();
			Date eDate = (Date) sDate.clone();
			eDate.setMinutes(eDate.getMinutes()+medicalAppointment.getAppointmentType().getDuration());
			if ((date.before(sDate) || date.equals(sDate)) && endDate.after(sDate)) {
				return false;
			} else if (date.before(eDate) && (endDate.after(eDate) || endDate.equals(eDate))) {
				return false;
			} else if ((date.after(sDate) || date.equals(sDate)) && (endDate.before(eDate) || endDate.equals(eDate))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Page<MedicalAppointment> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public Page<MedicalAppointmentDTO> findAllByPatientId(Pageable pageable, Long id) throws ResourceNotFoundException {
		Page<MedicalAppointment> page = ((MedicalAppointmentRepository) repo).findByPatientId(pageable, id);
		Page<MedicalAppointmentDTO> pageDto = page.map(obj -> new MedicalAppointmentDTO(obj));
		return pageDto;
	}

	public boolean setDoctorGrade(Long id, int grade, Long patientId) throws ResourceNotFoundException {
		MedicalAppointment medAppointment = findOne(id);
		if (medAppointment.getAppointmentStatus() == AppointmentStatus.FINISHED) {
			if (medAppointment.getPatient().getId() == patientId && medAppointment.getDoctorGrade() == null) {
				medAppointment.setDoctorGrade(grade);
				super.save(medAppointment);
				return true;
			}
		}
		return false;
	}

	public boolean setClinicGrade(Long id, int grade, Long patientId) throws ResourceNotFoundException {
		MedicalAppointment medAppointment = findOne(id);
		if (medAppointment.getAppointmentStatus() == AppointmentStatus.FINISHED) {
			if (medAppointment.getPatient().getId() == patientId && medAppointment.getClinicGrade() == null) {
				medAppointment.setClinicGrade(grade);
				super.save(medAppointment);
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public MedicalAppointment cancelAppointment(Long medApId, Long patientId, String email)
			throws ResourceNotFoundException, MessagingException, IOException {
		MedicalAppointment medApp = findOne(medApId);
		Date date = medApp.getDateTime();
		Date currentDate = new Date();
		currentDate.setHours(currentDate.getHours() + 24);
		String dt = new SimpleDateFormat("dd.MM.yyyy").format(medApp.getDateTime());
		String time = new SimpleDateFormat("HH:mm").format(medApp.getDateTime());
		if (medApp.getPatient() != null) {
			if (medApp.getPatient().getId() == patientId) {
				if (currentDate.before(date)) {
					medApp.setAppointmentStatus(AppointmentStatus.CANCELED);
					medApp.setPatient(null);
					return super.save(medApp);
				} else {
					mailService.sendMessage(email, "Pregled za datum " + dt + " u " + time
							+ " nije moguće otkazati, jer je ostalo manje od 24 časa do početka pregleda.");
				}
			}
		}
		return null;
	}

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
