let lista = document.getElementById("lista");

let botonBorrar = document.getElementById("btnBorrar");
let botonAniadir = document.getElementById("btnAniadir");
let botonEditar = document.getElementById("btnEditar");


function borrarUltimo() {
    if (lista.lastElementChild) {
        lista.lastElementChild.remove();
    }
}


function aniadirFinal() {

    const nuevoParrafo = document.createElement("li")
    nuevoParrafo.textContent = "Elemento " + (lista.childElementCount + 1)
    lista.appendChild(nuevoParrafo)

}

function editar(){
    lista.lastElementChild.innerHTML = "Elemento Editado"
}


botonBorrar.addEventListener("click", borrarUltimo)
botonAniadir.addEventListener("click", aniadirFinal)
botonEditar.addEventListener("click", editar)
