package com.qa.data.dto;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CharacterDTO {

	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 16, message = "Charactername must have at least 2 characters, but no more than 16")
	private String Charactername;
	
	@NotNull
	@Email
	private String email;
	
	public CharacterDTO() {
		super();
	}

	public CharacterDTO(int id, String Charactername, String email) {
		super();
		this.id = id;
		this.Charactername = Charactername;
		this.email = email;
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
		this.Charactername = charactername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, Charactername);
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
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(Charactername, other.Charactername);
	}

	@Override
	public String toString() {
		return "CharacterDTO [id=" + id + ", charactername=" + Charactername + ", email=" + email + "]";
	}
	
}
