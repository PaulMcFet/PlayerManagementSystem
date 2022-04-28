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
	private String playerName;
	
	@NotNull
	private int gold;
	
	
	public NewCharacterDTO() {
		super();
	}


	public String getCharacterName() {
		return characterName;
	}


	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPlayerClass() {
		return playerClass;
	}


	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public int getGold() {
		return gold;
	}


	public void setGold(int gold) {
		this.gold = gold;
	}


	@Override
	public int hashCode() {
		return Objects.hash(characterName, gold, id, playerClass, playerName);
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
		return Objects.equals(characterName, other.characterName) && gold == other.gold && id == other.id
				&& Objects.equals(playerClass, other.playerClass) && Objects.equals(playerName, other.playerName);
	}


	@Override
	public String toString() {
		return "NewCharacterDTO [getCharacterName()=" + getCharacterName() + ", getId()=" + getId()
				+ ", getPlayerClass()=" + getPlayerClass() + ", getPlayerName()=" + getPlayerName() + ", getGold()="
				+ getGold() + ", hashCode()=" + hashCode() + "]";
	}
}
