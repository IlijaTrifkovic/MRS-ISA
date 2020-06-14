package com.mrsisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.entity.appointment.type.AppointmentType;

public interface AppointmentTypeRepository extends JpaRepository<AppointmentType, Long> {

}
