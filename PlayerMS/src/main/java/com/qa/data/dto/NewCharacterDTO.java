package com.qa.data.dto;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewCharacterDTO {

	@NotNull
	@NotBlank
	@Size(min = 2, max = 16, message = "Character name must have at least 2 characters, but no more than 16")
	private String charactername;
	
	@NotNull
	@Email
	private String email;
	
	public NewCharacterDTO() {
		super();
	}

	public String getCharactername() {
		return charactername;
	}

	public void setCharactername(String charactername) {
		this.charactername = charactername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, charactername);
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
		return Objects.equals(email, other.email) && Objects.equals(charactername, other.charactername);
	}

	
	
}
