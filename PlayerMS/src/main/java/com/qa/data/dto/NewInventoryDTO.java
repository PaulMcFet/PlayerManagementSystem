package com.qa.data.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewInventoryDTO {

	@NotNull
	@NotBlank
	private String itemName;
	
	@NotNull
	@NotBlank
	private int value;
	
	protected NewInventoryDTO() {
		
	}

	public NewInventoryDTO(String itemName, int value) {
		super();
		this.itemName = itemName;
		this.value = value;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, itemName);
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
		return Objects.equals(value, other.value) && Objects.equals(itemName, other.itemName);
	}

	@Override
	public String toString() {
		return "NewInventoryDTO [itemName=" + itemName + ", value=" + value + "]";
	}
	
}
