const botonSumar = document.getElementById("btnSumar");
const botonRest = document.getElementById("btnRestar");
const botonMul = document.getElementById("btnMultiplicar");
const botonDiv = document.getElementById("btnDividir");
const resultado = document.getElementById("resultado");

function sumar() {
    let numero1 = parseFloat(document.getElementById("numero1").value);
    let numero2 = parseFloat(document.getElementById("numero2").value);
    resultado.textContent = "Suma de " + numero1 + " + " + numero2 + " : " + (numero1 + numero2);
}

function resta() {
    let numero1 = parseFloat(document.getElementById("numero1").value);
    let numero2 = parseFloat(document.getElementById("numero2").value);
    resultado.textContent = "Resta de " + numero1 + " - " + numero2 + " : " + (numero1 - numero2);
}

function multiplicacion() {
    let numero1 = parseFloat(document.getElementById("numero1").value);
    let numero2 = parseFloat(document.getElementById("numero2").value);
    resultado.textContent = "Multiplicación de " + numero1 + " * " + numero2 + " : " + (numero1 * numero2);
}

function division() {
    let numero1 = parseFloat(document.getElementById("numero1").value);
    let numero2 = parseFloat(document.getElementById("numero2").value);
    if (numero2 !== 0) {
        resultado.textContent = "División de " + numero1 + " / " + numero2 + " : " + (numero1 / numero2);
    } else {
        resultado.textContent = "Esta división no se puede hacer (división entre 0)";
    }
}

botonSumar.addEventListener("click", sumar);
botonRest.addEventListener("click", resta);
botonMul.addEventListener("click", multiplicacion);
botonDiv.addEventListener("click", division);