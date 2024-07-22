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

import com.entity.PackageItemEntity;
import com.repository.PackageItemRepository;

@RestController
@RequestMapping("/package-item")
public class PackageItemController {

	@Autowired
    private PackageItemRepository packageItemRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPackageItems() {
        List<PackageItemEntity> packageItems = packageItemRepository.findAll();
        return ResponseEntity.ok(packageItems);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createPackageItem(@RequestBody PackageItemEntity packageItem) {
        PackageItemEntity savedPackageItem = packageItemRepository.save(packageItem);
        return ResponseEntity.ok(savedPackageItem);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getPackageItemById(@PathVariable Long id) {
        PackageItemEntity packageItem = packageItemRepository.findById(id).orElse(null);
        if (packageItem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(packageItem);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePackageItem(@PathVariable Long id, @RequestBody PackageItemEntity packageItemDetails) {
        PackageItemEntity packageItem = packageItemRepository.findById(id).orElse(null);
        if (packageItem == null) {
            return ResponseEntity.notFound().build();
        }
        packageItem.setPackageEntity(packageItemDetails.getPackageEntity());
        packageItem.setItemEntity(packageItemDetails.getItemEntity());
        
        PackageItemEntity updatedPackageItem = packageItemRepository.save(packageItem);
        return ResponseEntity.ok(updatedPackageItem);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePackageItem(@PathVariable Long id) {
        if (!packageItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        packageItemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
