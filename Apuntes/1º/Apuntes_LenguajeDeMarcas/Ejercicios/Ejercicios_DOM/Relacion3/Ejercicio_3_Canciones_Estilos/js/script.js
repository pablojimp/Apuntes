let canciones = document.querySelectorAll("li");

canciones.forEach(function(cancion) {
    cancion.style.color = "green";
    cancion.textContent = cancion.textContent + " 🎶";
});