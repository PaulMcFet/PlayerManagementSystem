(function() {
    const dataTable = document.querySelector('#data-table');
    const dataForm = document.querySelector('#data-form');

    function createUserFromFormObj(dataObject) {
        const address = new Address(dataObject.street, dataObject.city, dataObject.suite, dataObject.zipcode, new Geolatitude(dataObject.lat, dataObject.lng));
        const company = new Company(dataObject['company-name'], dataObject.bs, dataObject['catch-phrase']);
        const character = new Character(dataObject.characterName, dataObject.playerName, dataObject.playerClass, dataObject.gold, dataObject.id);
        return character;
    }

    function create() {
   
        const formData = new FormData(dataForm);
        const formDataObject = Object.fromEntries(formData.entries());
        setStatus('PREPARING POST REQUEST');
        

        fetch('http://localhost:8080/character', {
            method: 'POST', 
            body: JSON.stringify(createUserFromFormObj(formDataObject)),
            headers: {
                'Content-type': 'application/json' // has json data in the body
            }
        }).then(response => {
            setStatus('RECEIVED RESPONSE');
            if (response.ok) return response.json();
            else throw new Error('Uh oh, something went wrong...');
        })
          .then(character => {
            setStatus('RENDERING TABLE');
            renderUserTable([character], dataTable);
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