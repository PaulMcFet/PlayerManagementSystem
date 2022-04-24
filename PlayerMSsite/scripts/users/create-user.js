(function() {
    const dataTable = document.querySelector('#data-table');
    const dataForm = document.querySelector('#data-form');

    function createUserFromFormObj(dataObject) {
        const Player = new Player(Name);
        const Character = new Character(CharacterName, CharacterClass, SGold);
        const Inventory = new Inventory(InventoryID,[]);
        return user;
    }

    function create() {
        const formData = new FormData(dataForm);
        const formDataObject = Object.fromEntries(formData.entries());

        setStatus('PREPARING POST REQUEST');
        

        fetch('https://jsonplaceholder.typicode.com/users', {
            method: 'POST',
            body: JSON.stringify(createUserFromFormObj(formDataObject)),
            headers: {
                'Content-type': 'application/json'
            }
        }).then(response => {
            setStatus('RECEIVED RESPONSE');
            if (response.ok) return response.json();
            else throw new Error('Uh oh, something went wrong...');
        })
          .then(user => {
            setStatus('RENDERING TABLE');
            renderUserTable([user], dataTable);
            setStatus('RESPONSE RENDERED INTO TABLE');
        })
          .catch(error => {
            setStatus('ERROR ENCOUNTERED');
            handleError(error);
        });
    }

    function handleFormSubmission(event) {
        event.preventDefault(); 
        create();

    }
    dataForm.addEventListener('submit', handleFormSubmission);
})();