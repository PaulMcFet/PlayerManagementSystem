package com.qa.data.controller;

import java.util.ArrayList;
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

import com.qa.data.Entity.Player;
import com.qa.data.service.CharacterService;
import com.qa.data.dto.CharacterDTO;
import com.qa.data.dto.NewCharacterDTO;

@RestController
@RequestMapping(path = "/character")
@CrossOrigin("*")
public class CharacterController {

	private CharacterService service;
	
	@Autowired
	public CharacterController(CharacterService service) {
		this.service = service;
	}
	
	//Read All
	@GetMapping 
	public ResponseEntity<List<CharacterDTO>> getCharacters() {
		return ResponseEntity.ok(service.getCharacters());
	}
	
	//Read by ID
	@GetMapping(path = "/{id}")
	public ResponseEntity<CharacterDTO> getUser(@PathVariable(name = "id") int id) {
		CharacterDTO character = service.getCharacter(id);
		return new ResponseEntity<>(character, HttpStatus.OK);
	}
		
	@PostMapping
	public ResponseEntity<CharacterDTO> createCharacter(@Valid @RequestBody NewCharacterDTO character) {
		CharacterDTO newCharacter = service.createCharacter(character);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:8080/character/" + newCharacter.getId());
		return new ResponseEntity<>(newCharacter, headers, HttpStatus.CREATED);
	}
	
	//Update/Replace existing Character
	@PutMapping(path = "/{id}")
	public ResponseEntity<CharacterDTO> updateCharacter(@RequestBody NewCharacterDTO newCharacterDTO, @PathVariable(name = "id") int id) {
		return ResponseEntity.ok(service.updateCharacter(newCharacterDTO, id));
	}
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteCharacter(@PathVariable(name = "id") int id) {
		CharacterDTO deletedCharacter = service.getCharacter(id);
		service.deleteCharacter(id);
		return ResponseEntity.ok(deletedCharacter);
	}
}
