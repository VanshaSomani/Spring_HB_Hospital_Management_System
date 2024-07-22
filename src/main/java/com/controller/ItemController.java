package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ItemEntity;
import com.repository.ItemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllItem() {
		List<ItemEntity> items = itemRepository.findAll();
		return ResponseEntity.ok(items);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> createItem(@RequestBody ItemEntity item) {
		//TODO: process POST request
		ItemEntity savedItem = itemRepository.save(item);
		return ResponseEntity.ok(item);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getItemById(@PathVariable Long id) {
        ItemEntity item = itemRepository.findById(id).orElse(null);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }
	
	@PutMapping("/update/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Long id, @RequestBody ItemEntity itemDetails) {
        ItemEntity item = itemRepository.findById(id).orElse(null);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        item.setMaterialGroupName(itemDetails.getMaterialGroupName());
        item.setMaterialName(itemDetails.getMaterialName());
        item.setItemCode(itemDetails.getItemCode());
        item.setItemName(itemDetails.getItemName());
        item.setAlternateName(itemDetails.getAlternateName());
        item.setShortName(itemDetails.getShortName());
        item.setGstRate(itemDetails.getGstRate());
        item.setHsnCode(itemDetails.getHsnCode());
        item.setPrice(itemDetails.getPrice());
        
        ItemEntity updatedItem = itemRepository.save(item);
        return ResponseEntity.ok(updatedItem);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        if (!itemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        itemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
