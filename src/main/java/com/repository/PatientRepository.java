package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Long>{
	
}
