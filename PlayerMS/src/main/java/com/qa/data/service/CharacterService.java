package com.qa.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.data.Character;
import com.qa.data.repo.InventoryRepository;
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
		super();
		this.CharacterRepository = characterRepository;
		this.inventoryService = inventoryService;
		this.modelMapper = modelMapper;
	}

	public List<CharacterDTO> getCharacters() {
		List<Character> characters = CharacterRepository.findAll();
		List<CharacterDTO> dtos = new ArrayList<>();
		
		for (Character character : characters) {
			dtos.add(this.toDTO(character));
		}
		return dtos;
	}
	
	public CharacterDTO getCharacter(int id) {
		Optional<Character> character = CharacterRepository.findById(id);
		
		if (character.isPresent()) {
			return this.toDTO(character.get());
		}
		throw new EntityNotFoundException("Character not found with id " + id);
	}
	
	public CharacterDTO createCharacter(NewCharacterDTO character) {
		Character toSave = this.modelMapper.map(character, Character.class);
		Character newCharacter = CharacterRepository.save(toSave);
		return this.toDTO(newCharacter);
	}
	
	@Transactional
	public CharacterDTO updateCharacter(NewCharacterDTO character, int id) {
		if (CharacterRepository.existsById(id)) {
			Character savedCharacter = CharacterRepository.getById(id);
			savedCharacter.setCharacterName(character.getCharactername());
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
	
	private CharacterDTO toDTO(Character character) {		
		return this.modelMapper.map(character, CharacterDTO.class);
		
	}

	public List<InventoryDTO> getCharacterInventorys(int Id) {
		CharacterDTO character = this.getID(Id);
		List<InventoryDTO> inventorys = inventoryService.getinventorysByCharacterId(Id);
		inventorys.forEach(inventory -> inventory.setCharacterDTO(character));
		return inventorys;
	}	
}
