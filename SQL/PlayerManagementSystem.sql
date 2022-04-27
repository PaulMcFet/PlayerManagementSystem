CREATE SCHEMA IF NOT EXISTS `Playerms`;

USE `Playerms` ;

SHOW Tables;

DROP TABLE character_details;
DROP TABLE INVENTORY;

SELECT * FROM character_details;
SELECT * FROM inventory;

#This statement displays all items held by player one
select * from inventory where character_id=1;

#This statement displays all items held by player two
select * from inventory where character_id=2;

#This statement displays all items held by player three
select * from inventory where character_id=3;

#This statement displays all items held by player four
select * from inventory where character_id=4;



