/**
 * 
 * @param {*} numero1 
 * @param {*} numero2 
 * @param {*} numero3 
 * @returns 
 */

function numeros(numero1, numero2, numero3){
    let resultado = 0
    if (numero1 > 0) {
        if (numero2 > 0) {
            resultado = numero1 + numero2
        } else {
            resultado = numero1 - numero3
        }
    } else {
        if (numero3 > 0) {
            resultado = numero2 + numero3
        } else {
            resultado = 0
        }
    }
    return resultado
}