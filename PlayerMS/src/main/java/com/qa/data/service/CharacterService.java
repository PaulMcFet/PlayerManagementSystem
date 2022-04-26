package com.qa.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.data.Entity.Player;
import com.qa.data.repo.CharacterRepository;
import com.qa.data.dto.NewCharacterDTO;
import com.qa.data.dto.InventoryDTO;
import com.qa.data.dto.CharacterDTO;

@Service
public class CharacterService {
	
	private CharacterRepository CharacterRepository;
	private InventoryService inventoryService;
	private ModelMapper modelMapper;

	@Autowired
	public CharacterService(CharacterRepository characterRepository, InventoryService inventoryService, ModelMapper modelMapper) {
		this.CharacterRepository = characterRepository;
		this.inventoryService = inventoryService;
		this.modelMapper = modelMapper;
	}

	public List<CharacterDTO> getCharacters() {
		List<Player> characters = CharacterRepository.findAll();
		List<CharacterDTO> dtos = new ArrayList<>();
		
		for (Player character_details : characters) {
			dtos.add(this.toDTO(character_details));
		}
		return dtos;
	}
	
	public CharacterDTO getCharacter(int id) {
		Optional<Player> character_details = CharacterRepository.findById(id);
		if (character_details.isPresent()) {
			return this.toDTO(character_details.get());
		}
		throw new EntityNotFoundException("Character not found with id " + id);
	}
	
	public CharacterDTO createCharacter(NewCharacterDTO character_details) {
		Player toSave = this.modelMapper.map(character_details, Player.class);
		Player newCharacter = CharacterRepository.save(toSave);
		return this.toDTO(newCharacter);
	}
	
	@Transactional
	public CharacterDTO updateCharacter(NewCharacterDTO character, int id) {
		if (CharacterRepository.existsById(id)) {
			Player savedCharacter = CharacterRepository.getById(id);
			savedCharacter.setCharacterName(character.getcharacterName());
			return this.toDTO(savedCharacter);
		}
		throw new EntityNotFoundException("Character not found with id " + id);
	}
	
	public void deleteCharacter(int id) {
		if (CharacterRepository.existsById(id)) {
			CharacterRepository.deleteById(id);
			return;
		}
		throw new EntityNotFoundException("Character not found with id " + id); 
	}
	
	private CharacterDTO toDTO(Player character_details) {		
		return this.modelMapper.map(character_details, CharacterDTO.class);
		
	}

	public List<InventoryDTO> getCharacterInventorys(int Id) {
		Player character_details = CharacterRepository.getById(Id);
		List<InventoryDTO> inventorys = inventoryService.getinventorysByCharacterId(Id);
		inventorys.forEach(inventory -> inventory.setCharacterDTO(new CharacterDTO(character_details)));
		return inventorys;
	}
}

