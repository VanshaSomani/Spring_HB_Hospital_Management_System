package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.DepartmentEntity;
import com.repository.DepartmentRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDepartments() {
		List<DepartmentEntity> departments = departmentRepository.findAll();
		return ResponseEntity.ok(departments);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> createDepartments(@RequestBody DepartmentEntity department) {
		//TODO: process POST request
		DepartmentEntity savedDepartment = departmentRepository.save(department);
		return ResponseEntity.ok(savedDepartment);
	}
					
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
		DepartmentEntity department = departmentRepository.findById(id).orElse(null);
		if(department == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(department);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable Long id, @RequestBody DepartmentEntity departmentDetails) {
		//TODO: process PUT request
		DepartmentEntity department = departmentRepository.findById(id).orElse(null);
		if(department == null) {
			return ResponseEntity.notFound().build();
		}
		department.setName(departmentDetails.getName());
		department.setActive(departmentDetails.isActive());
//        department.setRateList(departmentDetails.getRateList());
        
        DepartmentEntity updatedDepartment = departmentRepository.save(department);
        
        return ResponseEntity.ok(updatedDepartment);
	}
	
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
		 DepartmentEntity department = departmentRepository.findById(id).orElse(null);
		 if(department == null) {
			 return ResponseEntity.notFound().build();
		 }
		 departmentRepository.deleteById(id);
		 return ResponseEntity.ok().build();
	 }
}
