package com.qa.data.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InventoryDTO {
	
	private int id;

	private String title;

	private String content;
	
	private CharacterDTO characterDTO;
	
	private LocalDate postedAt;
	
	protected InventoryDTO() {
		
	}

	public InventoryDTO(int id, String title, String content, CharacterDTO characterDTO, LocalDate postedAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.characterDTO = characterDTO;
		this.postedAt = postedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CharacterDTO getCharacterDTO() {
		return characterDTO;
	}

	public void setCharacterDTO(CharacterDTO characterDTO) {
		this.characterDTO = characterDTO;
	}

	public LocalDate getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(LocalDate postedAt) {
		this.postedAt = postedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, id, title, characterDTO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryDTO other = (InventoryDTO) obj;
		return Objects.equals(content, other.content) && id == other.id && Objects.equals(title, other.title)
				&& Objects.equals(characterDTO, other.characterDTO);
	}

	@Override
	public String toString() {
		return "InventoryDTO [id=" + id + ", title=" + title + ", content=" + content + ", characterDTO=" + characterDTO
				+ ", postedAt=" + postedAt + "]";
	}
	
}
