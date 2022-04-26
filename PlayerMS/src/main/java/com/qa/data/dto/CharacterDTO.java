package com.qa.data.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qa.data.Entity.Character;

public class CharacterDTO {

	private int id;
	
	@NotNull
	@NotBlank
	private String Charactername;
	
	@NotNull
	private String PlayerName;
	
	@NotNull
	private String Cclass;
	
	@NotNull
	private int SGold;
	
	public CharacterDTO() {
		super();
	}
	
	public CharacterDTO(Character character) {
		this.id = character.getId();
		this.PlayerName = character.getPlayerName();
		this.Charactername = character.getCharactername();
		this.Cclass = character.getCclass();
		this.SGold = character.getSGold();
		
	}

	public CharacterDTO(int id, String Charactername, String Cclass, int SGold ) {

		this.id = id;
		this.Charactername = Charactername;
		this.Cclass = Cclass;
		this.SGold = SGold;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCharactername() {
		return Charactername;
	}

	public void setCharactername(String charactername) {
		Charactername = charactername;
	}

	public String getCclass() {
		return Cclass;
	}

	public void setCclass(String cclass) {
		Cclass = cclass;
	}

	public int getSGold() {
		return SGold;
	}

	public void setSGold(int sGold) {
		SGold = sGold;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, Charactername);
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
		return Objects.equals(Cclass, other.Cclass) && id == other.id && Objects.equals(Charactername, other.Charactername);
	}

	@Override
	public String toString() {
		return "CharacterDTO [Id=" + getId() + ", Character Name=" + getCharactername() + ", Class="
				+ getCclass() + ", Gold=" + getSGold() + "]";
	}


	
}
