# Práctica: Consumo de la API REST Countries con `fetch`

## Objetivo

Desarrolla una página web en JavaScript que consuma varios endpoints de la API pública **REST Countries** para mostrar información de países en distintas secciones de una misma página. La estructura HTML y los estilos CSS ya están creados. Tu trabajo será completar la lógica en JavaScript para realizar peticiones `GET`, procesar respuestas JSON y mostrar los datos en pantalla.

Trabajarás con varios endpoints de la API, entre ellos:

- `https://restcountries.com/v3.1/name/{name}`
- `https://restcountries.com/v3.1/region/{region}`
- `https://restcountries.com/v3.1/capital/{capital}`
- `https://restcountries.com/v3.1/alpha/{code}`
- `https://restcountries.com/v3.1/all?fields=name,flags,capital,population`

---

## Tareas a realizar

### 1. Buscar país por nombre
Debes completar el formulario para que, al escribir el nombre de un país, se haga una petición a:

```text
https://restcountries.com/v3.1/name/{nombre}
```

Debes mostrar en pantalla:

- bandera
- nombre común
- nombre oficial
- capital
- región
- subregión
- población
- idiomas
- monedas


---

### 2. Países por región
Debes completar la sección para que, al pulsar uno de los botones de región, se consulte:

```text
https://restcountries.com/v3.1/region/{region}
```

Debes mostrar varios países de esa región en tarjetas.  
De cada país muestra:

- bandera
- nombre
- capital
- población

---

### 3. Buscar por capital
Debes hacer una búsqueda usando:

```text
https://restcountries.com/v3.1/capital/{capital}
```

Debes mostrar:

- bandera
- nombre del país
- capital
- región
- enlace al mapa de Google Maps

---

### 4. Buscar por código
Debes completar la búsqueda por código de país usando:

```text
https://restcountries.com/v3.1/alpha/{code}
```

Ejemplos de código:

- `es`
- `fr`
- `it`
- `jp`

Debes mostrar:

- bandera
- nombre
- código `cca2`
- código `cca3`
- continente
- zona horaria

---

### 5. Lista rápida de países
Debes cargar, al pulsar un botón, una lista de países usando el endpoint:

```text
https://restcountries.com/v3.1/all?fields=name,flags,capital,population
```

Debes mostrar al menos 12 países en una cuadrícula con:

- bandera
- nombre
- capital
- población

---

### 6. Gestión de errores
Debes mostrar mensajes de error cuando:

- el país no exista
- la capital no exista
- el usuario deje un campo vacío
- falle la petición

---