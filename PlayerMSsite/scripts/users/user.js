
var Inventory = []

function Player(Name)
    this.name = Name;
    return output;


    function character(characterName, playerName, playerClass, gold, id = null) {
        this.characterName = characterName;
        this.playerName = playerName;
        this.playerClass = playerClass;
        this.gold = gold;
        this.id = id;

const userHeaders = ['id', 'characterName', 'playerName', 'playerClass', 'gold'];

// containerElement is the element we want to render the table into
// users is an array of objects representing user data
function renderUserTable(users, containerElement) {
    const tableManager = new TableManager();
    const table = tableManager.createTable(userHeaders, users);
    containerElement.replaceChildren(table);
}

function renderCommentsTable(comments, containerElement) {
    const tableManager = new TableManager();
    const table = tableManager.createTable(CommentsHeaders, comments);
    containerElement.replaceChildren(table);
}
