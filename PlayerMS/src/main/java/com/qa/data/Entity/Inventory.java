package com.qa.data.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@NotBlank
	private String itemName;

	@NotNull
	private int price;
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "character_id", referencedColumnName = "id")


	private Player character;
	
	public Inventory() {
		super();
	}

	public Inventory(String itemName, int price) {
		super();
		this.itemName = itemName;
		this.price = price;
	}

	public Inventory(int id, String itemName, int price, Player character) {
		super();
		this.id = id;
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

	public Player getCharacter() {
		return character;
	}

	public void setCharacter(Player character) {
		this.character = character;
	}

	@Override
	public String toString() {
		return "Inventory [itemName=" + itemName + ", price=" + price + ", character=" + character + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, itemName, character);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return Objects.equals(price, other.price) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(character, other.character);
	}

}
