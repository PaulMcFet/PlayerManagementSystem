package com.qa.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.data.Entity.Inventory;
import com.qa.data.repo.InventoryRepository;
import com.qa.data.dto.NewInventoryDTO;
import com.qa.data.dto.NewCharacterDTO;
import com.qa.data.dto.InventoryDTO;
import com.qa.data.dto.UpdateInventoryDTO;
import com.qa.data.dto.CharacterDTO;

@Service
public class InventoryService {

	private InventoryRepository InventoryRepository;
	private ModelMapper modelMapper;

	@Autowired
	public InventoryService(InventoryRepository InventoryRepository, ModelMapper modelMapper) {
		super();
		this.InventoryRepository = InventoryRepository;
		this.modelMapper = modelMapper;
	}

	public List<InventoryDTO> getInventorys() {
		List<Inventory> Inventorys = InventoryRepository.findAll();
		List<InventoryDTO> dtos = new ArrayList<>();
		
		for (Inventory Inventory : Inventorys) {
			dtos.add(this.toDTO(Inventory));
		}
		return dtos;
	}
	
	public List<InventoryDTO> getInventorysByCharacterId(int id) {
		List<Inventory> Inventorys = InventoryRepository.findByCharacterId(id);
		List<InventoryDTO> dtos = new ArrayList<>();
		
		for (Inventory Inventory : Inventorys) {
			dtos.add(this.toDTO(Inventory));
		}
		return dtos;
	}
	
	public InventoryDTO getInventory(int id) {
		Optional<Inventory> Inventory = InventoryRepository.findById(id);
		
		if (Inventory.isPresent()) {
			return this.toDTO(Inventory.get());
		}
		throw new EntityNotFoundException("Inventory not found with id " + id);
	}
	
	public InventoryDTO createInventory(NewInventoryDTO Inventory) {
		Inventory toSave = this.modelMapper.map(Inventory, Inventory.class);
		Inventory newInventory = InventoryRepository.save(toSave);
		return this.toDTO(newInventory);
	}
	
	public InventoryDTO updateInventory(UpdateInventoryDTO InventoryDTO, int id) {
		if (InventoryRepository.existsById(id)) {
			Inventory savedInventory = InventoryRepository.getById(id);
			savedInventory.setItemName(InventoryDTO.getItemName());
			savedInventory.setValue(InventoryDTO.getValue());
			return this.toDTO(InventoryRepository.save(savedInventory));
		}
		throw new EntityNotFoundException("Inventory not found with id " + id);
	}
	
	public void deleteInventory(int id) {
		if (InventoryRepository.existsById(id)) {
			InventoryRepository.deleteById(id);
			return;
		}
		throw new EntityNotFoundException("Inventory not found with id " + id); 
	}
	
	private InventoryDTO toDTO(Inventory Inventory) {		
		return modelMapper.map(Inventory, InventoryDTO.class);
	}
}
