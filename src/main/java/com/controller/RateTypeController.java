package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RateTypeEntity;
import com.repository.RateTypeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/rateType")
public class RateTypeController {
	
	@Autowired
	private RateTypeRepository rateTypeRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllRateType() {
		List<RateTypeEntity> rateTypes = rateTypeRepository.findAll();
		return ResponseEntity.ok(rateTypes);
	}

	@PostMapping("/save")
	public ResponseEntity<?> createRateType(@RequestBody RateTypeEntity rateType) {
		//TODO: process POST request
		RateTypeEntity savedRateType = rateTypeRepository.save(rateType);
		return ResponseEntity.ok(rateType);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getRateTypeById(@PathVariable Long id) {
        RateTypeEntity rateType = rateTypeRepository.findById(id).orElse(null);
        if (rateType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rateType);
    }
	
	@PutMapping("/update/{id}")
    public ResponseEntity<?> updateRateType(@PathVariable Long id, @RequestBody RateTypeEntity rateTypeDetails) {
        RateTypeEntity rateType = rateTypeRepository.findById(id).orElse(null);
        if (rateType == null) {
            return ResponseEntity.notFound().build();
        }
        rateType.setType(rateTypeDetails.getType());
//        rateType.setRateList(rateTypeDetails.getRateList());
        RateTypeEntity updatedRateType = rateTypeRepository.save(rateType);
        return ResponseEntity.ok(updatedRateType);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRateType(@PathVariable Long id) {
        RateTypeEntity rateType = rateTypeRepository.findById(id).orElse(null);
        if (rateType == null) {
            return ResponseEntity.notFound().build();
        }
        rateTypeRepository.delete(rateType);
        return ResponseEntity.noContent().build();
    }
}
