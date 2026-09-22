## CHULETAS ARRAYS

### At

```javascript
let frutas = [manzana,pera,naranaja]
let ultimaFrutaConAt = frutas.at(-1)
console.log(ultimaFrutaConAt)  // 'naranja'
```

### Push
Si es necesario añadir elementos al **final** de un array, se puede utilizar el método push()
```javascript
frutas.push('uva', 'mango')
console.log(frutas)  // ['manzana', 'banana', 'naranja', 'uva', 'mango']
```

### Unshift 
Si es necesario añadir elementos al **inicio** de un array, se puede utilizar el método unshift()

```javascript
frutas.unshift('fresa')
console.log(frutas)  // ['fresa', 'manzana', 'banana', 'naranja', 'uva', 'mango']
```

### Pop
El método pop() elimina el **último elemento** de un array, reduce su longitud y devuelve el elemento eliminado.

```javascript
let numeros = [1, 2, 3, 4]
let eliminado = numeros.pop()
console.log(numeros)  // [1, 2, 3]
console.log(eliminado)  // 4
```

### Shift
Para eliminar el **primer elemento** de un array, se utiliza el método shift().

```javascript
let frutas = ['manzana', 'banana', 'naranja']
let primerElemento = frutas.shift()
console.log(frutas)  // ['banana', 'naranja']
console.log(primerElemento)  // 'manzana'
```

### for of
```javascript
let frutas = ['manzana', 'banana', 'naranja']
for (let fruta of frutas) {
  console.log(`Fruta: ${fruta}`)
}
```

### splice
```javascript
let frutas = ["manzana", "banana", "pera"];

// Eliminar 1 elemento desde el índice 1
frutas.splice(1, 1);

console.log(frutas); // ["manzana", "pera"]
Primer parámetro: índice desde donde empezar.
Segundo parámetro: cuántos elementos eliminar.
```
