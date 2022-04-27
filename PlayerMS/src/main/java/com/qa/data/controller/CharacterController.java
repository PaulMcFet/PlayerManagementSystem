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

@RestController
@RequestMapping(path = "/character")
@CrossOrigin("*")
public class CharacterController {
	private static int COUNTER = 1;
	private List<Player> characters = new ArrayList<Player>();

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
	public ResponseEntity<Player> getCharacter(@PathVariable(name = "id") int id) {
		for (int i = 0; i < characters.size(); i++) {
			Player current = this.characters.get(i);
			if (current.getId() == id) {
				return new ResponseEntity<Player>(current, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
	}
		
	@PostMapping
	public ResponseEntity<Player> createCharacter(@Valid @RequestBody Player character) {
		int id = COUNTER++;
		character.setId(id);
		characters.add(character);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:8080/character/" + id);
		return new ResponseEntity<Player>(character, headers, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Player> updateCharacter(@RequestBody Player character, int id,
			@PathVariable(name = "CharacterName") String CharacterName)
	{
		Player savedCharacter = null;
		for (int i = 0; i < characters.size(); i++) {
			if (this.characters.get(i).getId() == id) {
				savedCharacter = this.characters.get(i);
			}
		}
		if (savedCharacter != null) {
			savedCharacter.setCharacterName(character.getCharacterName());
			return ResponseEntity.ok(savedCharacter);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteCharacter(@PathVariable(name = "id") int id) {
		CharacterDTO deletedCharacter = service.getCharacter(id);
		service.deleteCharacter(id);
		return ResponseEntity.ok(deletedCharacter);
	}
}
