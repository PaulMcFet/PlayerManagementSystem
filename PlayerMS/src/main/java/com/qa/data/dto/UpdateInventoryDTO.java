package com.qa.data.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateInventoryDTO {

	@NotNull
	@NotBlank
	private String itemName;
	
	@NotNull
	private int price;

	@NotNull
	private int characterid;
	
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

	public int getCharacterid() {
		return characterid;
	}

	public void setCharacterid(int characterid) {
		this.characterid = characterid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(characterid, itemName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdateInventoryDTO other = (UpdateInventoryDTO) obj;
		return characterid == other.characterid && Objects.equals(itemName, other.itemName) && price == other.price;
	}

	@Override
	public String toString() {
		return "UpdateInventoryDTO [getItemName()=" + getItemName() + ", getPrice()=" + getPrice()
				+ ", getCharacterid()=" + getCharacterid() + ", hashCode()=" + hashCode() + "]";
	}

}
