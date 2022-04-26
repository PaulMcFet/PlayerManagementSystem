package com.qa.data.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.data.Entity.Inventory;
import com.qa.data.dto.InventoryDTO;
import com.qa.data.dto.UpdateInventoryDTO;
import com.qa.data.service.InventoryService;

@RestController
@RequestMapping(path = "/Inventory")
@CrossOrigin("*")
public class InventoryController {

	private InventoryService InventoryService;
	
	@Autowired
	public InventoryController(InventoryService InventoryService) {
		this.InventoryService = InventoryService;
	}
	
	@GetMapping
	public ResponseEntity<List<InventoryDTO>> getInventorys() {
		return ResponseEntity.ok(InventoryService.getInventorys());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<InventoryDTO> getInventory(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(InventoryService.getInventory(id));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<InventoryDTO> updateInventory(@Valid @RequestBody UpdateInventoryDTO Inventory, @PathVariable(name = "id") int id) {
		return ResponseEntity.ok(InventoryService.updateInventory(Inventory, id));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteInventory(@PathVariable(name = "id") int id) {
		InventoryDTO deletedInventory = InventoryService.getInventory(id);
		InventoryService.deleteInventory(id);
		return ResponseEntity.ok(deletedInventory);
	}
}
