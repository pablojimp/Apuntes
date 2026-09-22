let imagenClick = document.getElementById("imgClick");
let imagenHover = document.getElementById("imgHover");
let imagenHoverimg = document.getElementById("imgHover").src;
let textoEscribir = document.getElementById("campoTexto")
let formulario = document.getElementById('formulario');
let resultado = document.getElementById('resultado');

let codigo = document.getElementById("codigo")



imagenClick.addEventListener("click", function () {
    imagenClick.src = "https://picsum.photos/id/238/200/300";
})


imagenHover.addEventListener("mouseover", function () {
    imagenHover.src = "https://picsum.photos/id/238/200/300";
})

imagenHover.addEventListener("mouseout", function () {
    imagenHover.src = imagenHoverimg;
})

textoEscribir.addEventListener("keydown", function (event) {
    console.log("Tecla presionada: " + event.key)
})



formulario.addEventListener('submit', function (event) {
    event.preventDefault();
    let nombre = document.getElementById('nombre').value;
    resultado.textContent = `¡Energía recargada, ${nombre}!`;
});


codigo.addEventListener("focus", function () {
    codigo.style.outline = 'none';
    codigo.style.border = '2px solid green';
    document.getElementById("mensaje").textContent = "Introduce tu código de energía";
});

codigo.addEventListener("blur", function () {
    codigo.style.border = '';
    document.getElementById("mensaje").textContent = "";
});