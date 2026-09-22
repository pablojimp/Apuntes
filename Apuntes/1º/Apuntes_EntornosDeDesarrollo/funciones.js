/**
 * 
 * Funcion que genera un array segun los numero que necesite y lo que necesite 
 * 
 * @param {Array} arrayMostrar En este array que introduzco sera el q muestre fuera 
 * @param {number} numeroEmojis Numero de emojis que tengo que poner en el array 
 * @param {string} emojiIntroducir String que tengo que introducir en el array que se muestra
 */ 
    function generadorArrayIniciales(arrayMostrar, numeroEmojis, emojiIntroducir) {
        for (let i = 0; i < numeroEmojis; i++) {
            arrayMostrar.push(emojiIntroducir)
        }

    }

