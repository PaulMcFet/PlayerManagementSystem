(function() {
    const requestSelector = document.querySelector('#method');
    const dataTable = document.querySelector('#data-table');
    const dataForm = document.querySelector('#data-form');
    const userIdField = document.querySelector('#user-id-field');
    const id = document.querySelector('#id');

    function toggleIdVisibility(isVisible) {
        if (isVisible) {
            if (userIdField.classList.contains('hide')) userIdField.classList.remove('hide');
        } else {
            if (!userIdField.classList.contains('hide')) userIdField.classList.add('hide');
        }
    }

    function readAll() {
        setStatus('PREPARING GET REQUEST');

        fetch('http://localhost:8080/character', {
            method: 'GET'
        }).then(response => {
            setStatus('RECEIVED RESPONSE');
            if (response.ok) return response.json();
            else throw new Error('Uh oh, something went wrong...');
        })
          .then(character => {
            setStatus('RENDERING TABLE');
            renderCharacterTable(character, dataTable);
            setStatus('RESPONSE RENDERED INTO TABLE');
        })
          .catch(error => {
            setStatus('ERROR ENCOUNTERED');
            handleError(error);
        });
    }

    function readById() {
        setStatus('PREPARING GET REQUEST');

        fetch(`http://localhost:8080/character/${id.value}`, {
            method: 'GET'
        }).then(response => {
            setStatus('RECEIVED RESPONSE');
            if (response.ok) return response.json();
            else throw new Error('Uh oh, something went wrong...');
        })
          .then(Character => {
            setStatus('RENDERING TABLE');
            renderCharacterTable([Character], dataTable);
            setStatus('RESPONSE RENDERED INTO TABLE');
        })
          .catch(error => {
            setStatus('ERROR ENCOUNTERED');
            handleError(error);
        });
    }

    readAll();

    requestSelector.addEventListener('change', function(event) {
        if (this.value == 'ALL') {
            toggleIdVisibility(false);
        } else if (this.value == 'ID') {
            toggleIdVisibility(true);
        }
    });

    dataForm.addEventListener('submit', function(event) {
        event.preventDefault();
        if (requestSelector.value == 'ALL') readAll();
        else if (requestSelector.value == 'ID') readById();
    });
})();