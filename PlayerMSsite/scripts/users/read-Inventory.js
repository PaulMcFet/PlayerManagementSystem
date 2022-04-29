(function() {
    const dataTable = document.querySelector('#data-table');
    const dataForm = document.querySelector('#data-form');
    const id = document.querySelector('#id');

function readById() {
    setStatus('PREPARING GET REQUEST');

    fetch(`http://localhost:8080/Inventory`, {
        method: 'GET'
    }).then(response => {
        setStatus('RECEIVED RESPONSE');
        if (response.ok) return response.json();
        else throw new Error('Uh oh, something went wrong...');
    })
      .then(comments => {
        setStatus('RENDERING TABLE');
        renderCommentsTable(comments, dataTable);
        setStatus('RESPONSE RENDERED INTO TABLE');
    })
      .catch(error => {
        setStatus('ERROR ENCOUNTERED');
        handleError(error);
    });
}
    dataForm.addEventListener('submit', function(event) {
        event.preventDefault(); 
        readById();
    });
})();