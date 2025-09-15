/**
 * Function that changes the color theme of the webpage.
 */
document.addEventListener("DOMContentLoaded", () => {
    const themeBtn = document.getElementById("btnTheme");
    const themeLink = document.getElementById("themeStylesheet");

    const savedTheme = localStorage.getItem("theme") || "light";
    themeLink.href = `/css/${savedTheme}.css`;

    themeBtn.addEventListener("click", () => {
        let currentTheme = themeLink.includes("light.css") ? "light" : "dark";
        let newTheme = currentTheme === "light" ? "dark" : "light";
        themeLink.href = `/css/${newTheme}.css`;

        // Save new theme
        localStorage.setItem("theme", newTheme);
    })
})