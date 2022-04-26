package com.qa.data.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewCharacterDTO {

	@NotNull
	@NotBlank
	private String characterName;
	
	@NotNull
	private int id;
	
	@NotNull
	private String playerClass;
	
	@NotNull
	private int gold;
	
	
	public NewCharacterDTO() {
		super();
	}

	public String getcharacterName() {
		return characterName;
	}

	public void setcharacterName(String characterName) {
		this.characterName = characterName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getplayerClass() {
		return playerClass;
	}

	public void setplayerClass(String playerClass) {
		this.playerClass = playerClass;
	}

	public int getgold() {
		return gold;
	}

	public void setgold(int gold) {
		this.gold = gold;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, characterName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewCharacterDTO other = (NewCharacterDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(characterName, other.characterName);
	}

	
	
}
