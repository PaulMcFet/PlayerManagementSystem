package com.qa.data.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewCharacterDTO {

	@NotNull
	@NotBlank
	private String charactername;
	
	@NotNull
	private int id;
	
	@NotNull
	private String Cclass;
	
	@NotNull
	private int SGold;
	
	
	public NewCharacterDTO() {
		super();
	}

	public String getCharactername() {
		return charactername;
	}

	public void setCharactername(String charactername) {
		this.charactername = charactername;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCclass() {
		return Cclass;
	}

	public void setCclass(String cclass) {
		this.Cclass = cclass;
	}

	public int getSGold() {
		return SGold;
	}

	public void setSGold(int SGold) {
		this.SGold = SGold;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, charactername);
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
		return Objects.equals(id, other.id) && Objects.equals(charactername, other.charactername);
	}

	
	
}
