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
import javax.persistence.OneToOne;
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
	@NotBlank
	private int price;
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "character_details", referencedColumnName = "id")

	//characterid is causing problems, 
	private Player characterid;

	public Inventory(String itemName, int price) {
		super();
		this.itemName = itemName;
		this.price = price;
	}

	public Inventory(String itemName, int price, Player characterId) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.characterid = characterId;

	}

	public Inventory(int id, String itemName, int price, Player characterId) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.characterid = characterId;
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

	public Player getCharacterId() {
		return characterid;
	}

	public void setCharacterId(Player characterId) {
		this.characterid = characterId;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", itemName=" + itemName + ", price=" + price + ", characterId=" + characterid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, id, itemName, characterid);
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
		return Objects.equals(price, other.price) && id == other.id && Objects.equals(itemName, other.itemName)
				&& Objects.equals(characterid, other.characterid);
	}

}
