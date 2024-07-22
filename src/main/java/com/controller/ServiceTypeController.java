package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ServiceTypeEntity;
import com.repository.ServiceTypeRepository;

@RestController
@RequestMapping("/service-type")
public class ServiceTypeController {
	
	@Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAllServiceTypes() {
        List<ServiceTypeEntity> serviceTypes = serviceTypeRepository.findAll();
        return ResponseEntity.ok(serviceTypes);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createServiceType(@RequestBody ServiceTypeEntity serviceType) {
        ServiceTypeEntity savedServiceType = serviceTypeRepository.save(serviceType);
        return ResponseEntity.ok(savedServiceType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceTypeById(@PathVariable Long id) {
        ServiceTypeEntity serviceType = serviceTypeRepository.findById(id).orElse(null);
        if (serviceType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(serviceType);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateServiceType(@PathVariable Long id, @RequestBody ServiceTypeEntity serviceTypeDetails) {
        ServiceTypeEntity serviceType = serviceTypeRepository.findById(id).orElse(null);
        if (serviceType == null) {
            return ResponseEntity.notFound().build();
        }
        serviceType.setType(serviceTypeDetails.getType());
        
        ServiceTypeEntity updatedServiceType = serviceTypeRepository.save(serviceType);
        return ResponseEntity.ok(updatedServiceType);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteServiceType(@PathVariable Long id) {
        if (!serviceTypeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        serviceTypeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
