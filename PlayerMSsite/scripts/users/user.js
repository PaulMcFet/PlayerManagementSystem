
var Inventory = []

function Player(Name)
    this.name = Name;
    return output;


function Character(CharacterName, CharacterClass, SGold, Inventory) {
    console.log()
    this.CharacterName = CharacterName;
    this.CharacterClass = CharacterClass;
    this.SGold = SGold;
    this.Inventory = new Inventory;
    this.toString = function() {
        let output = `${CharacterName} "The" \n${CharacterClass} "With" \n${SGold}`;
        return output;
    }
}

const userHeaders = ['id', 'character_name', 'gold', 'player_class', 'player_name'];

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