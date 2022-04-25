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

	public List<CharacterDTO> getUsers() {
		List<Character> users = CharacterRepository.findAll();
		List<CharacterDTO> dtos = new ArrayList<>();
		
		for (Character character : characters) {
			dtos.add(this.toDTO(character));
		}
		return dtos;
//		return userRepository.findAll()
//							 .stream()
//							 .map(this::toDTO)
//							 .collect(Collectors.toList());
	}
	
	public CharacterDTO getUser(int id) {
		Optional<Character> user = CharacterRepository.findById(id);
		
		if (user.isPresent()) {
			return this.toDTO(user.get());
		}
		throw new EntityNotFoundException("User not found with id " + id);
//		return this.toDTO(user.orElseThrow(() -> new EntityNotFoundException("User not found with id " + id)));
	}
	
	public CharacterDTO createUser(NewCharacterDTO character) {
		Character toSave = this.modelMapper.map(character, Character.class);
		Character newUser = CharacterRepository.save(toSave);
		return this.toDTO(newUser);
	}
	
	@Transactional
	// @Transactional wraps this whole method in a transaction
	// - if a RuntimeException is thrown, the transaction is rolled back (i.e., the changes to the database are not made)
	public CharacterDTO updateUser(NewCharacterDTO character, int id) {
		// Alternate way of retrieving a user, no optionals involved
		if (CharacterRepository.existsById(id)) {
			Character savedCharacter = CharacterRepository.getById(id);
			savedCharacter.setUsername(user.getUsername());
			return this.toDTO(savedCharacter);
		}
		throw new EntityNotFoundException("User not found with id " + id);
	}
	
	public void deleteUser(int id) {
		if (CharacterRepository.existsById(id)) {
			CharacterRepository.deleteById(id);
			return;
		}
		throw new EntityNotFoundException("User not found with id " + id); 
	}
	
	private CharacterDTO toDTO(Character user) {		
		return this.modelMapper.map(user, CharacterDTO.class);
		
		// ModelMapper will create an instance of UserDTO
		// - it will then assign the values of all fields in `user`, which have the same name
		//   as the fields in `UserDTO.class`, to that new instance of UserDTO
	}

	public List<InventoryDTO> getUserInventorys(int Id) {
		CharacterDTO user = this.getID(Id);
		List<InventoryDTO> inventorys = inventoryService.getinventorysByUserId(Id);
		inventorys.forEach(inventory -> inventory.setUserDTO(user));
		return inventorys;
	}
	
}
