package com.qa.data.Entity;


import java.util.ArrayList;
import java.util.List;
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
public class Character {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 16, message = "Charactername must have at least 2 characters, but no more than 16")
	private String charactername;
	
	@NotNull
	@NotBlank
	private String PlayerName;
	
	@NotNull
	private String Cclass;
	private int SGold;
	
	
	@OneToOne(mappedBy = "character", targetEntity = Inventory.class, fetch = FetchType.LAZY)
	private Inventory inventory;

		
	protected Character() {
		super();
	}
	
	public Character(String charactername, String Cclass) {
		this.charactername = charactername;
		this.Cclass = Cclass;
	}

	public Character(int id, String PlayerName, String charactername, String Cclass, int SGold) {
		this.id = id;
		this.PlayerName = PlayerName;
		this.charactername = charactername;
		this.Cclass = Cclass;
		this.SGold = SGold;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	public String getCharactername() {
		return charactername;
	}

	public void setCharactername(String charactername) {
		this.charactername = charactername;
	}

	public String getCclass() {
		return Cclass;
	}

	public void setCclass(String Cclass) {
		this.Cclass = Cclass;
	}

	public int getSGold() {
		return SGold;
	}

	public void setSGold(int SGold) {
		this.SGold = SGold;
	}

	@Override
	public String toString() {
		return "Character [PlayerID=" + id + ", Player Name =" + PlayerName + ", Character Name=" + charactername + ", Class=" + Cclass + ", Gold=" + SGold + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Cclass, SGold, id, inventory, PlayerName, charactername);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		return Objects.equals(Cclass, other.Cclass) && id == other.id && Objects.equals(inventory, other.inventory)
				&& Objects.equals(PlayerName, other.PlayerName) && Objects.equals(charactername, other.charactername);
	}
	
}
