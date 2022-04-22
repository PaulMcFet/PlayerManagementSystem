CREATE SCHEMA IF NOT EXISTS `Playerms`;

USE `Playerms` ;

SHOW Tables;

#DROP TABLE PLAYER;
#DROP TABLE CHARACTERSTATS;
#DROP TABLE INVENTORY;


CREATE TABLE Player (
	PlayerName VARCHAR(64) NOT NULL,
    CharacterName VARCHAR(64) NOT NULL,
    Gold BIGINT NOT NULL,
    Inventory VARCHAR(64) NOT NULL,
    PRIMARY KEY(PlayerName),
    Foreign Key(CharacterName) REFERENCES CharacterStats(CharacterName)
);

CREATE TABLE CharacterStats (
	CharacterName VARCHAR(64) NOT NULL,
    InventoryID BIGINT AUTO_INCREMENT,
    Gold BIGINT NOT NULL,
    PRIMARY KEY(CharacterName),
    Foreign Key(InventoryID) REFERENCES Inventory(InventoryID)
);

CREATE TABLE Inventory (
	InventoryID BIGINT AUTO_INCREMENT,
    ItemName VARCHAR(64) NOT NULL,
    Cost BIGINT NOT NULL,
    Quantity VARCHAR(64) NOT NULL,
    PRIMARY KEY(InventoryID)
);

INSERT INTO Inventory(ItemName, Cost, Quantity)
VALUES("Potion", 25, 5 );

