function setStatus(input) {
    document.querySelector('#status').innerText = input;
}

// IIFE - Immediately Invoked Function Expression
// - this runs as soon as this file is loaded
(function() {
    setStatus('READY');
})(); // this last set of parenthesis which enables this, they call the function that was declared within the outer set of parenthesis.