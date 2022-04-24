(function() {
    const toggle = document.querySelector("#toggle"); // select the toggle button
    const navLinks = document.querySelectorAll(".nav-link"); // select the nav links

    toggle.addEventListener("click", function(event) {
        console.log("clicked toggle");
        // when the toggle button is clicked, add or remove the 'show'
        navLinks.forEach(element => element.classList.toggle("show"));
    });
})();