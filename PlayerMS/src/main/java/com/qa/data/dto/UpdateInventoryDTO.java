package com.qa.data.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateInventoryDTO {

	@NotNull
	@NotBlank
	private String ItemName;
	
	@NotNull
	@NotBlank
	private int value;

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String ItemName) {
		this.ItemName = ItemName;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, ItemName);
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
		return Objects.equals(value, other.value) && Objects.equals(ItemName, other.ItemName);
	}

	@Override
	public String toString() {
		return "UpdateInventoryDTO [ItemName=" + ItemName + ", value=" + value + "]";
	}
	
}
