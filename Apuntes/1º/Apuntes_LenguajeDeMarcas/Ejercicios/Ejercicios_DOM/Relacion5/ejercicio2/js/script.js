
let contadorPrecio = 0;
const botonAniadir = document.getElementById("btnAniadirProducto");
function aniadir() {
    let nombreProducto = document.getElementById("inputNombreProducto").value;
    let precioProducto = parseFloat(document.getElementById("inputPrecioProducto").value);
    const nuevoParrafo = document.createElement("li")
    nuevoParrafo.textContent = nombreProducto + " | " + precioProducto;
    document.getElementById("listaProductos").appendChild(nuevoParrafo)


    const nuevoTotal = document.createElement("H2")
    document.getElementById("totalCompraH2").innerHTML = "";
    contadorPrecio += precioProducto;
    nuevoTotal.textContent = "Tienes en total: " + contadorPrecio;
    document.getElementById("totalCompraH2").appendChild(nuevoTotal);


}


botonAniadir.addEventListener("click", aniadir)