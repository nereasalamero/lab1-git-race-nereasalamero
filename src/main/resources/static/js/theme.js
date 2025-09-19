/**
 * Function that changes the color theme of the webpage.
 */
document.addEventListener("DOMContentLoaded", () => {
    const themeBtn = document.getElementById("btnTheme");

    // Load current saved theme
    const savedTheme = localStorage.getItem("theme") || "light";
    // If the theme is dark, then add "darkmode" to the class of body
    if (savedTheme === "dark") {
        document.body.classList.add("darkmode");
    }
    else {
        document.body.classList.remove("darkmode");
    }

    themeBtn.addEventListener("click", () => {
        document.body.classList.toggle("darkmode");

        // Save preference after clicking the theme button.
        if (document.body.classList.contains("darkmode")) {
            localStorage.setItem("theme", "dark");    // Save new theme
        }
        else {
            localStorage.setItem("theme", "light");    // Save new theme
        }
    })
})