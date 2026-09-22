let integrantes = document.getElementById("integrantes");
let nuevoIntegrante = document.createElement("li");
let bateria = integrantes.querySelectorAll("li");


nuevoIntegrante.textContent = "Trompetista";
integrantes.appendChild(nuevoIntegrante);
bateria = bateria[1]
bateria.remove();