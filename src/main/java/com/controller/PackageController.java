package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.PackageEntity;
import com.repository.PackageRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/package")
public class PackageController {

	@Autowired
	private PackageRepository packageRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllPackage() {
		 List<PackageEntity> packages = packageRepository.findAll();
	     return ResponseEntity.ok(packages);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getPackageById(@PathVariable Long id) {
        PackageEntity packageEntity = packageRepository.findById(id).orElse(null);
        if (packageEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(packageEntity);
    }
	
	@PostMapping("/save")
    public ResponseEntity<?> createPackage(@RequestBody PackageEntity packageEntity) {
        PackageEntity savedPackage = packageRepository.save(packageEntity);
        return ResponseEntity.ok(savedPackage);
    }
	
	@PutMapping("/update/{id}")
    public ResponseEntity<?> updatePackage(@PathVariable Long id, @RequestBody PackageEntity packageDetails) {
        PackageEntity packageEntity = packageRepository.findById(id).orElse(null);
        if (packageEntity == null) {
            return ResponseEntity.notFound().build();
        }
        
        packageEntity.setName(packageDetails.getName());
        packageEntity.setAmount(packageDetails.getAmount());
        packageEntity.setRateType(packageDetails.getRateType());
        packageEntity.setPackageType(packageDetails.getPackageType());
        
        PackageEntity updatedPackage = packageRepository.save(packageEntity);
        return ResponseEntity.ok(updatedPackage);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePackage(@PathVariable Long id) {
        PackageEntity packageEntity = packageRepository.findById(id).orElse(null);
        if (packageEntity == null) {
            return ResponseEntity.notFound().build();
        }
        
        packageRepository.delete(packageEntity);
        return ResponseEntity.ok().build();
    }
}
