function character(characterName, playerName, playerClass, gold, id) {
    this.characterName = characterName;
    this.playerName = playerName;
    this.playerClass = playerClass;
    this.gold = gold;
    this.id = id;
}

const CharacterHeaders = ['id', 'characterName', 'playerName', 'playerClass', 'gold'];

function renderCharacterTable(character, containerElement) {
    const tableManager = new TableManager();
    const table = tableManager.createTable(CharacterHeaders, character);
    containerElement.replaceChildren(table);
}
