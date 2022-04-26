package com.qa.data.Entity;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity 
@Table(name = "character_details")
public class Player {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 16, message = "Character name must have at least 2 characters, but no more than 16")
	private String characterName;
	
	@NotNull
	@NotBlank
	private String playerName;
	
	@NotNull
	private String playerClass;
	private int gold;
	
	
	@OneToOne(mappedBy = "character", targetEntity = Inventory.class, fetch = FetchType.LAZY)
	private Inventory inventory;

		
	protected Player() {
		super();
	}


	public Player(int id,
			@NotNull @NotBlank @Size(min = 2, max = 16, message = "Character name must have at least 2 characters, but no more than 16") String characterName,
			@NotNull @NotBlank String playerName, @NotNull String playerClass, int gold, Inventory inventory) {
		super();
		this.id = id;
		this.characterName = characterName;
		this.playerName = playerName;
		this.playerClass = playerClass;
		this.gold = gold;
		this.inventory = inventory;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCharacterName() {
		return characterName;
	}


	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public String getPlayerClass() {
		return playerClass;
	}


	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}


	public int getGold() {
		return gold;
	}


	public void setGold(int gold) {
		this.gold = gold;
	}


	public Inventory getInventory() {
		return inventory;
	}


	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}


	@Override
	public int hashCode() {
		return Objects.hash(characterName, gold, id, inventory, playerClass, playerName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(characterName, other.characterName) && gold == other.gold && id == other.id
				&& Objects.equals(inventory, other.inventory) && Objects.equals(playerClass, other.playerClass)
				&& Objects.equals(playerName, other.playerName);
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", characterName=" + characterName + ", playerName=" + playerName + ", playerClass="
				+ playerClass + ", gold=" + gold + ", inventory=" + inventory + "]";
	}
	
	
	
}
