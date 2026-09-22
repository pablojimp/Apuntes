// Objetivo: Practicar el uso de querySelector y querySelectorAll.

// Instrucciones:
// Crea varios botones con la clase boton. Cada botón debe tener un texto diferente (por ejemplo: Iniciar, Detener, Reiniciar).
// Al cargar la página:
// Añade otro botón llamado "Cambiar Estilo de Todos". Al hacer clic en este botón:
// Cambia el color de fondo de todos los botones con la clase boton a un color diferente usando document.querySelectorAll(".boton").
// Añade un borde a cada botón.
// Pistas:
// Usa const primerBoton = document.querySelector(".boton") para seleccionar el primer botón.
// Usa const todosLosBotones = document.querySelectorAll(".boton") para obtener una NodeList de todos los botones.
// Recorre la NodeList usando forEach


const primerBoton = document.querySelector(".boton")
const cambiarTodo = document.querySelector("#cambiarEstilo")
const botones = document.querySelectorAll(".boton")
primerBoton.style.backgroundColor = "pink"

cambiarTodo.addEventListener("click", function () {

    for (let boton of botones) {
        boton.style.backgroundColor = "green"
        boton.style.border = "2px solid orange"
    }
})
