package com.qa.data.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.qa.data.dto.InventoryDTO;
import com.qa.data.dto.UpdateInventoryDTO;
import com.qa.data.service.InventoryService;
import com.qa.data.dto.NewInventoryDTO;


@RestController
@RequestMapping(path = "/Inventory")
@CrossOrigin("*")
public class InventoryController {

	private InventoryService inventoryService;
	
	@Autowired
	public InventoryController(InventoryService InventoryService) {
		this.inventoryService = InventoryService;
	}
	
	@GetMapping
	public ResponseEntity<List<InventoryDTO>> getInventorys() {
		return ResponseEntity.ok(inventoryService.getInventorys());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<InventoryDTO> getInventory(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(inventoryService.getInventory(id));
	}
	
	@PostMapping
	public ResponseEntity<InventoryDTO> createItems(@Valid @RequestBody NewInventoryDTO Item) {
		InventoryDTO newInventory = inventoryService.createInventory(Item);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:8080/Inventory/" + newInventory.getId());
		return new ResponseEntity<>(newInventory, headers, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<InventoryDTO> updateInventory(@Valid @RequestBody UpdateInventoryDTO Inventory, @PathVariable(name = "id") int id) {
		return ResponseEntity.ok(inventoryService.updateInventory(Inventory, id));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteInventory(@PathVariable(name = "id") int id) {
		InventoryDTO deletedInventory = inventoryService.getInventory(id);
		inventoryService.deleteInventory(id);
		return ResponseEntity.ok(deletedInventory);
	}
}
