function Inventory(id, itemName, price, characterId) {
this.id = id;
this.itemName = itemName;
this.price = price;
this.characterId = characterId;
}

const InventoryHeaders = [ 'id', 'itemName', 'price', 'characterId']


function renderInventoryTable(Inventory, containerElement) {
    const tableManager = new TableManager();
    const table = tableManager.createTable(InventoryHeaders, Inventory);
    containerElement.replaceChildren(table);
}