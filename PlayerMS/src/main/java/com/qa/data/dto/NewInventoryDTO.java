package com.qa.data.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewInventoryDTO {

	@NotNull
	@NotBlank
	private String itemName;
	
	@NotNull
	private int price;
	
	@NotNull
	private int characterId;
	
	
	protected NewInventoryDTO() {
		
	}

	public NewInventoryDTO(String itemName, int price, int characterId) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.characterId = characterId;
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

	public int getCharacterId() {
		return characterId;
	}

	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(characterId, itemName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewInventoryDTO other = (NewInventoryDTO) obj;
		return characterId == other.characterId && Objects.equals(itemName, other.itemName) && price == other.price;
	}

	@Override
	public String toString() {
		return "NewInventoryDTO [getItemName()=" + getItemName() + ", getPrice()=" + getPrice() + ", getCharacterId()="
				+ getCharacterId() + "]";
	}

}