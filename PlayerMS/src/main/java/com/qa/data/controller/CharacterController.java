package com.qa.data.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.data.Entity.Character;
import com.qa.data.service.CharacterService;
import com.qa.data.dto.CharacterDTO;

@RestController
@RequestMapping(path = "/character")
public class CharacterController {
	private static int COUNTER = 1;
	private List<Character> characters = new ArrayList<>(
			List.of(new Character(1, "Tim", "Toby", "Wizard", 50), new Character(2, "Nika", "Jayla", "Paladin", 0)));

	private CharacterService service;
	
	@Autowired
	public CharacterController(CharacterService service) {
		this.service = service;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Character> getCharacter(@PathVariable(name = "id") int id) {
		for (int i = 0; i < characters.size(); i++) {
			Character current = this.characters.get(i);
			if (current.getId() == id) {
				return new ResponseEntity<Character>(current, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Character>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Character> createCharacter(@Valid @RequestBody Character character) {
		int id = COUNTER++;
		character.setId(id);
		characters.add(character);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:8080/character/" + id);
		return new ResponseEntity<Character>(character, headers, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Character> updateCharacter(@RequestBody Character character, int id,
			@PathVariable(name = "CharacterName") String CharacterName) {
		Character savedCharacter = null;
		for (int i = 0; i < characters.size(); i++) {
			if (this.characters.get(i).getId() == id) {
				savedCharacter = this.characters.get(i);
			}
		}
		if (savedCharacter != null) {
			savedCharacter.setCharactername(character.getCharactername());
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
