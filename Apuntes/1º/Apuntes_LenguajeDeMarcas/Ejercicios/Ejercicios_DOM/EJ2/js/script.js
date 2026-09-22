let boton = document.querySelector("#marcarFrutas")
let lista = document.querySelectorAll("li")
let contenedor = document.querySelector("ul")


for (let element of lista) {
    element.style.border = "2px solid orange"
}

boton.addEventListener("click", function () {
    for (let element of lista) {

        texto = element.textContent
        element.textContent = texto + "✅"
        element.style.backgroundColor = "pink"
    }

})
