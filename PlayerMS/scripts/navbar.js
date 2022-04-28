(function() {
    const toggle = document.querySelector("#toggle");
    const navLinks = document.querySelectorAll(".nav-link");

    toggle.addEventListener("click", function(event) {
        console.log("clicked toggle");
        navLinks.forEach(element => element.classList.toggle("show"));
    });
})();