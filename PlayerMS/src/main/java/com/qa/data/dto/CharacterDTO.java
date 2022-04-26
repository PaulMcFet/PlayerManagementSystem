package com.qa.data.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qa.data.Entity.Player;

public class CharacterDTO {

	private int id;
	
	@NotNull
	@NotBlank
	private String characterName;
	
	@NotNull
	private String playerName;
	
	@NotNull
	private String playerClass;
	
	@NotNull
	private int Gold;
	
	public CharacterDTO() {
		super();
	}
	
	public CharacterDTO(Player character) {
		this.id = character.getId();
		this.playerName = character.getPlayerName();
		this.characterName = character.getCharacterName();
		this.playerClass = character.getPlayerClass();
		this.Gold = character.getGold();
		
	}

	public CharacterDTO(int id, String CharacterName, String playerClass, int Gold ) {
		this.id = id;
		this.characterName = CharacterName;
		this.playerClass = playerClass;
		this.Gold = Gold;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}

	public int getGold() {
		return Gold;
	}

	public void setGold(int gold) {
		Gold = gold;
	}

	@Override
	public String toString() {
		return "CharacterDTO [id=" + id + ", Character Name=" + characterName + ", Player Name=" + playerName
				+ ", Class=" + playerClass + ", Gold=" + Gold + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Gold, characterName, id, playerClass, playerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterDTO other = (CharacterDTO) obj;
		return Gold == other.Gold && Objects.equals(characterName, other.characterName) && id == other.id
				&& Objects.equals(playerClass, other.playerClass) && Objects.equals(playerName, other.playerName);
	}




}
