package com.qa.data.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewInventoryDTO {

	@NotNull
	@NotBlank
	private String itemName;
	
	@NotNull
	@NotBlank
	private int price;
	
	protected NewInventoryDTO() {
		
	}

	public NewInventoryDTO(String itemName, int price) {
		super();
		this.itemName = itemName;
		this.price = price;
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

	@Override
	public int hashCode() {
		return Objects.hash(price, itemName);
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
		return Objects.equals(price, other.price) && Objects.equals(itemName, other.itemName);
	}

	@Override
	public String toString() {
		return "NewInventoryDTO [itemName=" + itemName + ", price=" + price + "]";
	}
	
}
