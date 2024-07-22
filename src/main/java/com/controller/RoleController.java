package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RoleEntity;
import com.repository.RoleRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllRoles() {
		return ResponseEntity.ok(roleRepository.findAll());
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveRole(@RequestBody RoleEntity role) {
		//TODO: process POST request
		if(!roleRepository.findByRoleName(role.getRoleName()).isEmpty()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Role already exists");
		}
		RoleEntity savedRole = roleRepository.save(role);
        return ResponseEntity.ok(savedRole);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Long id) {
        RoleEntity role = roleRepository.findById(id).orElse(null);
        if (role == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(role);
    }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateRole(@PathVariable Long id, @RequestBody RoleEntity roleDetails) {
		//TODO: process PUT request
		RoleEntity role = roleRepository.findById(id).orElse(null);
		if(role == null) {
			return ResponseEntity.notFound().build();
		}
		role.setRoleName(roleDetails.getRoleName());
        RoleEntity updatedRole = roleRepository.save(role);
        return ResponseEntity.ok(updatedRole);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable Long id) {
		if(!roleRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		roleRepository.deleteById(id);
        return ResponseEntity.ok().build();
	}
	
}
