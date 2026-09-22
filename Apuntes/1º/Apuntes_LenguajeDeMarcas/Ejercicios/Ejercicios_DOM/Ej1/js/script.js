
let animales = document.getElementsByClassName("animal")
for (let animal of animales) {
    animal.style.backgroundColor = "lightyellow"
}
let boton = document.querySelector("#resaltarAnimales")
boton.addEventListener("click", function () {
    for (let element of animales) {
        element.style.color = "green"
        element.style.fontSize = "25px"

    }
})