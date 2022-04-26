package com.qa.data.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

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
	private String ItemName;

	@NotNull
	@NotBlank
	private int Value;

	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "character_id", referencedColumnName = "id")
	private Player character;

	public Inventory(String ItemName, int Value) {
		super();
		this.ItemName = ItemName;
		this.Value = Value;

	}

	public Inventory(String ItemName, int Value, Player character) {
		super();
		this.ItemName = ItemName;
		this.Value = Value;
		this.character = character;

	}

	public Inventory(int id, String ItemName, int Value, Player character) {
		super();
		this.id = id;
		this.ItemName = ItemName;
		this.Value = Value;
		this.character = character;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String ItemName) {
		this.ItemName = ItemName;
	}

	public int getValue() {
		return Value;
	}

	public void setValue(int Value) {
		this.Value = Value;
	}

	public Player getCharacter() {
		return character;
	}

	public void setCharacter(Player character) {
		this.character = character;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", ItemName=" + ItemName + ", Value=" + Value + ", character=" + character + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Value, id, ItemName, character);
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
		return Objects.equals(Value, other.Value) && id == other.id && Objects.equals(ItemName, other.ItemName)
				&& Objects.equals(character, other.character);
	}

}
