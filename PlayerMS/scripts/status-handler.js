function setStatus(input) {
    document.querySelector('#status').innerText = input;
}

(function() {
    setStatus('READY');
})(); 