package com.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.PatientEntity;
import com.repository.PatientRepository;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
    private PatientRepository patientRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPatients() {
    	return ResponseEntity.ok(patientRepository.findAll());
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> createPatient(@RequestBody PatientEntity patient) {
        PatientEntity savedPatient = patientRepository.save(patient);
        return ResponseEntity.ok(savedPatient);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable Long id) {
        PatientEntity patient = patientRepository.findById(id).orElse(null);
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patient);
    }
}
