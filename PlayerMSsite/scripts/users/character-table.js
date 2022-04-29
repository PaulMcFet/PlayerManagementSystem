(function() {
    const requestManager = new RequestManager('http://localhost:8080/character');
    const tableManager = new TableManager();

    const dataTable = document.querySelector('#data-table');
    const dataForm = document.querySelector('#data-form');
    const requestSelector = dataForm.querySelector('#action');
    const generalInfo = dataForm.querySelector('#general-info');
    const id = dataForm.querySelector('#id');

    let users = [];

    function hideFormInputs() {
      if (!generalInfo.classList.contains('hide')) generalInfo.classList.toggle('hide');
      if (!addressInfo.classList.contains('hide')) addressInfo.classList.toggle('hide');
      if (!companyInfo.classList.contains('hide')) companyInfo.classList.toggle('hide');
    }

    function displayFormInputs() {
      if (generalInfo.classList.contains('hide')) generalInfo.classList.toggle('hide');
      if (addressInfo.classList.contains('hide')) addressInfo.classList.toggle('hide');
      if (companyInfo.classList.contains('hide')) companyInfo.classList.toggle('hide');
    }

    function hideIdField(hide) {
      if (hide) id.classList.add('hide');
      else id.classList.remove('hide');
    }
    
    function renderUserTable(users) {
      const table = tableManager.createTable(userHeaders, users);
      dataTable.replaceChildren(table);
    }

    function addUserToTable(user) {
      console.log(user);
      const tableBody = dataTable.querySelector('tbody');
      tableBody.appendChild(tableManager.createTableRow(tableManager.getValuesInOrder(userHeaders, user)));
    }

    function createUserFromFormObj(dataObject) {
      const character = new Character(dataObject.CharacterName, dataObject.CharacterClass, dataObject.Gold, dataObject.PlayerName);
      return character;
    }

    function handleFormSubmission(event) {
      event.preventDefault(); 
      const form = event.currentTarget;
      const formData = new FormData(form);
      const dataObject = Object.fromEntries(formData.entries());

      let user;
      switch (requestSelector.value) {
        case 'GET':
          requestManager.setPayload('');
          requestManager.setRequestMethod('GET');

          requestManager.sendRequest().then(response => response.json())
                                      .then(data => renderUserTable(data))
                                      .catch(err => handleError(err));
          break;
        case 'POST':
          user = createUserFromFormObj(dataObject);
          requestManager.setRequestMethod('POST');
          requestManager.setPayload(JSON.stringify(character));
          requestManager.setHeaders({
            'Content-type': 'application/json'
          });

          requestManager.sendRequest().then(response => response.json())
                                      .then(data => addUserToTable(data))
                                      .catch(err => handleError(err));
          break;
        case 'PUT':
          user = createUserFromFormObj(dataObject);
          break;
        case 'DELETE':

          break;
      }
    }
    requestManager.sendRequest()
                  .then(response => response.json())
                  .then(response => {
                    users = response;
                    renderUserTable(users)
                  })
                  .catch(err => handleError(err));

    dataForm.addEventListener('submit', handleFormSubmission);

    requestSelector.addEventListener('change', (event) => {
      const select = event.currentTarget;
      
      switch (select.value) {
        case 'GET': 
          hideFormInputs();
          break;
        case 'POST':
          displayFormInputs();
          hideIdField(true);
          break;
        case 'PUT':
          displayFormInputs();
          hideIdField(false);
          break;
        case 'DELETE':
          // TODO
          break;
      }
    });
})();