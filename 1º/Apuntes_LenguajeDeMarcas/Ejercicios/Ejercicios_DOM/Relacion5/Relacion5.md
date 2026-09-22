# Relación 5

## Ejercicio 1: Manipulación de una lista con JavaScript

### Objetivo
Crear una página web en la que el usuario pueda añadir, borrar y reemplazar elementos en una lista de forma dinámica mediante botones.

### Requisitos
- El código JavaScript que gestione la manipulación del DOM estará en un archivo externo llamado `js/script.js`.

### Estructura del HTML

```html
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Manipulando el DOM</title>
    <script src="js/script.js" defer></script>
</head>

<body>
    <h1>Añadir elementos</h1>

    <ul id="lista">
        <li>Elemento 1</li>
        <li>Elemento 2</li>
        <li>Elemento 3</li>
    </ul>

    <button id="btnAniadir">Añadir elemento</button>
    <button id="btnBorrar">Borrar elemento</button>
    <button id="btnEditar">Editar elemento</button>
</body>

</html>
```

---

## Ejercicio 2: Lista de la compra

### Objetivo
Crear una página web que permita añadir productos con nombre y precio a una lista de la compra y que muestre el total acumulado.

### Requisitos
- El código JavaScript estará en un archivo externo llamado `js/script.js`.
- Los eventos se gestionarán mediante `addEventListener` en lugar de atributos en las etiquetas HTML.

### Estructura del HTML

```html
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Lista de la compra</title>
    <script src="js/script.js" defer></script>
</head>

<body>
    <h1>Añadir elementos</h1>
    
    <label for="inputNombreProducto">Nombre del producto:</label>
    <input id="inputNombreProducto" type="text"><br>

    <label for="inputPrecioProducto">Precio del producto:</label>
    <input id="inputPrecioProducto" type="number"><br>

    <button id="btnAniadirProducto">Añadir producto</button>
    
    <ol id="listaProductos"></ol>

    <h2 id="totalCompraH2"></h2>
</body>

</html>
```

### Pista
Para leer el valor de un campo de entrada (`input`), se usa la propiedad `.value`. Por ejemplo:

```javascript
const nombreProducto = document.getElementById("inputNombreProducto").value;
const precioProducto = parseFloat(document.getElementById("inputPrecioProducto").value);
```

Luego, puedes usar estos valores para crear un nuevo elemento de lista y actualizar el total de la compra.

---

## Ejercicio 3: Operaciones y variables

### Objetivo
Crear una página web que permita realizar operaciones matemáticas básicas (suma, resta, multiplicación y división) entre dos números ingresados por el usuario.

### Requisitos
- El código JavaScript estará en un archivo externo llamado `js/script.js`.
- Los eventos se gestionarán mediante `addEventListener` en lugar de atributos en las etiquetas HTML.

### Estructura del HTML

```html
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Operaciones y variables</title>
    <script src="js/script.js" defer></script>
</head>

<body>
    <label for="numero1">Número 1:</label>
    <input id="numero1" type="number"><br>

    <label for="numero2">Número 2:</label>
    <input id="numero2" type="number"><br>

    <button id="btnSumar">SUMAR</button>
    <button id="btnRestar">RESTAR</button>
    <button id="btnMultiplicar">MULTIPLICAR</button>
    <button id="btnDividir">DIVIDIR</button>

    <h1 id="resultado"></h1>
</body>

</html>
```

