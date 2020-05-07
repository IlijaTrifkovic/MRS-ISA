package com.mrsisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.entity.examination.ExaminationType;

public interface ExaminationTypeRepository extends JpaRepository<ExaminationType, Long>{

}
