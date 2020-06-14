package com.mrsisa.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.dto.MedicalAppointmentDTO;
import com.mrsisa.entity.appointment.MedicalAppointment;
import com.mrsisa.exception.CustomException;
import com.mrsisa.exception.ResourceNotFoundException;
import com.mrsisa.service.appointment.MedicalAppointmentService;
import com.mrsisa.service.patient.PatientService;

@RestController
public class AppointmentController {
	@Autowired
	private MedicalAppointmentService medicalAppointmentService;
	@Autowired 
	private PatientService patientService;

	//getAllApp - test 
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/appointments", method = RequestMethod.GET)
	public ResponseEntity<Page<MedicalAppointmentDTO>> getAll(Pageable pageable) {
		Page<MedicalAppointment> page = medicalAppointmentService.findAll(pageable);
		Page<MedicalAppointmentDTO> pageDto = page.map(obj -> new MedicalAppointmentDTO(obj));
		return new ResponseEntity<Page<MedicalAppointmentDTO>>(pageDto, HttpStatus.OK);
	}
	
	
	//getAppByClinicID
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/appointment/{id}", method = RequestMethod.GET)
	public ResponseEntity<Page<MedicalAppointmentDTO>> getMedicalAppointment(Pageable pageable,@PathVariable Long id) throws ResourceNotFoundException {
		Page<MedicalAppointmentDTO> pageDto = medicalAppointmentService.getFreeAppointmentsByClinicId(pageable, id);
		return new ResponseEntity<Page<MedicalAppointmentDTO>>(pageDto, HttpStatus.OK);
	}
	
	
	//davanje ocjene ljekaru koji je obavio pregled - operaciju
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/appointment/doctor-grade", method = RequestMethod.PUT)
	public ResponseEntity<?> setDoctorGrade(@RequestParam Long id, @RequestParam int grade) throws ResourceNotFoundException{
		if(grade<1 || grade>5 )
			return new ResponseEntity<String>("{\"message\":\"Ocjena mora biti od 1 do 5.\"}", HttpStatus.BAD_REQUEST);
		if(patientService.setDoctorGrade(id, grade))
			return new ResponseEntity<String>("{\"message\":\"Doktor je ocijenjen.\"}", HttpStatus.OK);
		return new ResponseEntity<String>("{\"message\":\"Nije moguce ocijeniti doktora.\"}", HttpStatus.BAD_REQUEST);
	}
	
	//davanje ocjene klinici koji je obavio pregled - operaciju
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/appointment/clinic-grade", method = RequestMethod.PUT)
	public ResponseEntity<?> setClinicGrade(@RequestParam Long id, @RequestParam int grade) throws ResourceNotFoundException{
		if(grade<1 || grade>5 )
			return new ResponseEntity<String>("{\"message\":\"Ocjena mora biti od 1 do 5.\"}", HttpStatus.BAD_REQUEST);
		if(patientService.setClinicGrade(id, grade))
			return new ResponseEntity<String>("{\"message\":\"Klinika je ocijenjena.\"}", HttpStatus.OK);
		return new ResponseEntity<String>("{\"message\":\"Nije moguce ocijeniti kliniku.\"}", HttpStatus.BAD_REQUEST);
	}
	
	//zakazivanje pregleda
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/appointment/{id}", method = RequestMethod.GET)
	public ResponseEntity<MedicalAppointment> scheduleAppointment(@PathVariable Long id)
			throws ResourceNotFoundException, CustomException, MessagingException, IOException {
		MedicalAppointment medicalAppointment = patientService.scheduleAppointment(id);
		return new ResponseEntity<MedicalAppointment>(medicalAppointment, HttpStatus.OK);
	}
	
	//otkazivanje pregleda
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/appointment/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> cancelAppointment(@PathVariable Long id) throws ResourceNotFoundException, MessagingException, IOException{
		if(patientService.cancelAppointment(id))
			return new ResponseEntity<String>("{\"message\":\"Pregled je otkazan.\"}", HttpStatus.OK);
		return new ResponseEntity<String>("{\"message\":\"Nije moguce otkazati pregled.\"}", HttpStatus.OK);
	}
	
	//svi pregledi-operacije pacijenta
	@PreAuthorize("hasAnyRole('PATIENT')")
	@RequestMapping(value = "/patient/appointment", method = RequestMethod.GET)
	public ResponseEntity<Page<MedicalAppointmentDTO>> getMedicalAppointment(Pageable pageable)
			throws ResourceNotFoundException {
		Page<MedicalAppointmentDTO> pageDto = patientService.getAllMedicalAppointments(pageable);
		return new ResponseEntity<Page<MedicalAppointmentDTO>>(pageDto, HttpStatus.OK);
	}
}
