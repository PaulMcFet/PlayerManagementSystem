package com.qa.data.dto;

import java.util.Objects;

public class InventoryDTO {
	
	private int id;

	private String itemName;

	private int Value;
	
	private CharacterDTO characterDTO;
	
	
	protected InventoryDTO() {
		
	}

	public InventoryDTO(int id, String itemName, int value, CharacterDTO characterDTO) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.Value = value;
		this.characterDTO = characterDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getValue() {
		return Value;
	}

	public void setValue(int value) {
		this.Value = value;
	}

	public CharacterDTO getCharacterDTO() {
		return characterDTO;
	}

	public void setCharacterDTO(CharacterDTO characterDTO) {
		this.characterDTO = characterDTO;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Value, id, itemName, characterDTO);
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
		return Objects.equals(Value, other.Value) && id == other.id && Objects.equals(itemName, other.itemName)
				&& Objects.equals(characterDTO, other.characterDTO);
	}

	@Override
	public String toString() {
		return "InventoryDTO [id=" + id + ", itemName=" + itemName + ", value=" + Value + ", characterDTO=" + characterDTO
				+"]";
	}

	
}
