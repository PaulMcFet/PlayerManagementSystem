package com.qa.data.dto;

import java.util.Objects;

public class InventoryDTO {
	
	private int id;
	private int characterid;
	private String itemName;
	private int price;
	private CharacterDTO character;
	
	protected InventoryDTO() {
	}

	public InventoryDTO(int id, int characterid, String itemName, int price, CharacterDTO character) {
		super();
		this.id = id;
		this.characterid = characterid;
		this.itemName = itemName;
		this.price = price;
		this.character = character;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getcharacterId() {
		return characterid;
	}

	public void setcharacterId(int characterid) {
		this.characterid = characterid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public CharacterDTO getCharacter() {
		return character;
	}

	public void setCharacter(CharacterDTO character) {
		this.character = character;
	}

	@Override
	public int hashCode() {
		return Objects.hash(character, characterid, id, itemName, price);
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
		return Objects.equals(character, other.character) && characterid == other.characterid && id == other.id
				&& Objects.equals(itemName, other.itemName) && price == other.price;
	}

	@Override
	public String toString() {
		return "InventoryDTO [Id()=" + getId() + ", character Id()=" + getcharacterId() + ", Item Name()="
				+ getItemName() + ", Price()=" + getPrice() + ", character()=" + getCharacter()
				+ "]";
	}	
}
