package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RateListEntity;
import com.repository.RateListRepository;
import com.repository.RateTypeRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/rateList")
public class RateListController {

	@Autowired
	private RateListRepository rateListRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllRateList() {
		List<RateListEntity> rateLists = rateListRepository.findAll();
		return ResponseEntity.ok(rateLists);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> createRateList(@RequestBody RateListEntity rateList) {
		//TODO: process POST request
		RateListEntity savedRateList = rateListRepository.save(rateList);
        return ResponseEntity.ok(savedRateList);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getRateListById(@PathVariable Long id) {
        RateListEntity rateList = rateListRepository.findById(id).orElse(null);
        if (rateList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rateList);
    }
	
	@PutMapping("/update/{id}")
    public ResponseEntity<?> updateRateList(@PathVariable Long id, @RequestBody RateListEntity rateListDetails) {
        RateListEntity rateList = rateListRepository.findById(id).orElse(null);
        if (rateList == null) {
            return ResponseEntity.notFound().build();
        }

        rateList.setName(rateListDetails.getName());
        rateList.setAmount(rateListDetails.getAmount());
        rateList.setRateType(rateListDetails.getRateType());
        rateList.setDepartment(rateListDetails.getDepartment());

        RateListEntity updatedRateList = rateListRepository.save(rateList);
        return ResponseEntity.ok(updatedRateList);
    }
	
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteRateList(@PathVariable Long id) {
	        RateListEntity rateList = rateListRepository.findById(id).orElse(null);
	        if (rateList == null) {
	            return ResponseEntity.notFound().build();
	        }

	        rateListRepository.delete(rateList);
	        return ResponseEntity.ok().build();
	    }
}
