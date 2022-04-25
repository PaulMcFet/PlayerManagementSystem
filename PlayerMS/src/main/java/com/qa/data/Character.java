package com.qa.data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Character {
	
	private int id;
	private String PlayerName;
	private String CharacterName;
	private String CClass;
	private int SGold;
	
	@NotNull
	@NotBlank

	public Character(int id, String PlayerName, String CharacterName, String CClass, int SGold) {
		super();
		this.id = id;
		this.PlayerName = PlayerName;
		this.CharacterName = CharacterName;
		this.CClass = CClass;
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

	public String getCharacterName() {
		return CharacterName;
	}

	public void setCharacterName(String characterName) {
		CharacterName = characterName;
	}

	public String getCClass() {
		return CClass;
	}

	public void setCClass(String cClass) {
		CClass = cClass;
	}

	public int getSGold() {
		return SGold;
	}

	public void setSGold(int sGold) {
		SGold = sGold;
	}

	
}