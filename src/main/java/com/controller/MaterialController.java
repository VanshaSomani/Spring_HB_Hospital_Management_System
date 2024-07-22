package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.MaterialEntity;
import com.repository.MaterialRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private MaterialRepository materialRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllMaterial() {
		List<MaterialEntity> materials = materialRepository.findAll();
		return ResponseEntity.ok(materials);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> createMaterial(@RequestBody MaterialEntity material) {
		//TODO: process POST request
		MaterialEntity savedMaterial = materialRepository.save(material);
		return ResponseEntity.ok(savedMaterial);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMaterialById(@PathVariable Long id) {
		MaterialEntity material = materialRepository.findById(id).orElse(null);
		if(material == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(material);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateMaterial(@PathVariable Long id, @RequestBody MaterialEntity materialDetails) {
		//TODO: process PUT request
		MaterialEntity material = materialRepository.findById(id).orElse(null);
        if (material == null) {
            return ResponseEntity.notFound().build();
        }

        material.setMaterialName(materialDetails.getMaterialName());
        material.setDescription(materialDetails.getDescription());

        MaterialEntity updatedMaterial = materialRepository.save(material);
        return ResponseEntity.ok(updatedMaterial);
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMaterial(@PathVariable Long id) {
        MaterialEntity material = materialRepository.findById(id).orElse(null);
        if (material == null) {
            return ResponseEntity.notFound().build();
        }

        materialRepository.delete(material);
        return ResponseEntity.ok().build();
    }
}
