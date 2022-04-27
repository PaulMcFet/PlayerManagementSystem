package com.qa.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.data.Entity.Inventory;
import com.qa.data.Entity.Player;
import com.qa.data.repo.CharacterRepository;
import com.qa.data.repo.InventoryRepository;
import com.qa.data.dto.NewInventoryDTO;
import com.qa.data.dto.InventoryDTO;
import com.qa.data.dto.UpdateInventoryDTO;


@Service
public class InventoryService {
	
	private CharacterRepository characterRepository;
	private InventoryRepository inventoryRepository;
	private ModelMapper modelMapper;

	@Autowired
	public InventoryService(InventoryRepository InventoryRepository, CharacterRepository characterRepository, ModelMapper modelMapper) {
		super();
		this.inventoryRepository = InventoryRepository;
		this.characterRepository = characterRepository;
		this.modelMapper = modelMapper;
	}

	public List<InventoryDTO> getInventorys() {
		List<Inventory> Inventorys = inventoryRepository.findAll();
		List<InventoryDTO> dtos = new ArrayList<>();
		
		for (Inventory Inventory : Inventorys) {
			dtos.add(this.toDTO(Inventory));
		}
		return dtos;
	}
	
	public List<InventoryDTO> getInventorysByCharacterId(int id) {
		List<Inventory> Inventorys = inventoryRepository.findByCharacterId(id);
		List<InventoryDTO> dtos = new ArrayList<>();
		for (Inventory Inventory : Inventorys) {
			dtos.add(this.toDTO(Inventory));
		}
		return dtos;
	}
	
	public InventoryDTO getInventory(int id) {
		Optional<Inventory> Inventory = inventoryRepository.findById(id);
		if (Inventory.isPresent()) {
			return this.toDTO(Inventory.get());
		}
		throw new EntityNotFoundException("Inventory not found with id " + id);
	}
	
	public InventoryDTO createInventory(NewInventoryDTO Inventory) {
		Inventory toSave = this.modelMapper.map(Inventory, Inventory.class);
		Optional<Player> opt = characterRepository.findById(Inventory.getCharacterId());
		
		Player player = opt.orElse(null);
		if (player == null) throw new EntityNotFoundException();
		// player does exist, set them on the inventory to save
		toSave.setCharacter(player);
		
		Inventory newInventory = inventoryRepository.save(toSave);
		return this.toDTO(newInventory);
	}
	
	public InventoryDTO updateInventory(UpdateInventoryDTO InventoryDTO, int id) {
		if (inventoryRepository.existsById(id)) {
			Inventory savedInventory = inventoryRepository.getById(id);
			savedInventory.setItemName(InventoryDTO.getItemName());
			savedInventory.setPrice(InventoryDTO.getPrice());
			return this.toDTO(inventoryRepository.save(savedInventory));
		}
		throw new EntityNotFoundException("Inventory not found with id " + id);
	}
	
	public void deleteInventory(int id) {
		if (inventoryRepository.existsById(id)) {
			inventoryRepository.deleteById(id);
			return;
		}
		throw new EntityNotFoundException("Inventory not found with id " + id); 
	}
	
	private InventoryDTO toDTO(Inventory Inventory) {		
		return modelMapper.map(Inventory, InventoryDTO.class);
	}
}
