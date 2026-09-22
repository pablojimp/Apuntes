
# Ejercicio Práctico: Página Web - Mundo Disney

## Objetivo

Diseñar una página web temática de Disney aplicando los conceptos aprendidos en la Unidad Didáctica 4. Este ejercicio busca que domines selectores, propiedades de diseño, modelo de caja, y Flexbox, entre otros.

---

## Instrucciones

### **1. Estilos Globales**
1. Configura los estilos globales en tu archivo CSS:
   - Aplica `margin` y `padding` de 0 a todos los elementos utilizando el selector universal (`*`).
   - Configura el `box-sizing: border-box;` para que los márgenes y bordes no afecten las dimensiones totales de los elementos.
   - Define un color de fondo suave para toda la página, como un azul cielo o un rosa pastel.
   - Usa `font-family` para aplicar una fuente decorativa para encabezados y una fuente legible para párrafos.

---

### **2. Encabezado de Bienvenida**
- Diseña un encabezado que contenga:
  1. Un título de texto que diga "Mundo Disney".
  2. Una barra de navegación con enlaces: **Inicio**, **Películas**, **Parques**, **Personajes** y **Contacto**.
- Usa **Flexbox** para alinear los elementos horizontalmente.
- Aplica los siguientes estilos:
  - Cambia el color del texto en los enlaces al pasar el ratón (`hover`) usando un selector de clase.
  - Usa una clase `active` para resaltar el enlace seleccionado en la barra de navegación (puedes aplicarlo manualmente para practicar).
  - Usa un borde inferior decorativo en el encabezado.

---

### **3. Sección Hero**
- Diseña una sección destacada que incluya:
  - Un título grande con el texto: "Bienvenidos al Mundo Disney".
  - Un subtítulo con el texto: "Explora la magia, la fantasía y los cuentos de hadas".
  - Un botón estilizado que diga: **Descubre Más**.
- Añade una imagen de fondo utilizando `background-image`, y ajusta el diseño con:
  - `background-size: cover;`
  - `background-position: center;`.
- Haz que el botón cambie de color y tamaño al pasar el ratón (usa `transform: scale()`).

---

### **4. Sección de Películas Destacadas**
- Diseña una sección con **tres tarjetas de películas**. Cada tarjeta debe incluir:
  - Una imagen representativa de la película.
  - El título de la película.
  - Una breve descripción.
  - Un botón con el texto "Ver más".
- Usa los siguientes selectores:
  - Un selector de descendientes (`.clase img`) para aplicar bordes redondeados a las imágenes.
  - Un selector de hijo directo (`.clase > h3`) para cambiar el estilo de los títulos de las tarjetas.
  - Usa Flexbox para alinear las tarjetas y aplica márgenes entre ellas.

---

### **5. Sección de Personajes Populares**
- Crea una sección que destaque a **cuatro personajes de Disney**. Cada personaje debe incluir:
  - Una imagen representativa del personaje.
  - El nombre del personaje.
  - Una breve descripción.
- Aplica estilos únicos para cada personaje, utilizando selectores de clase. Por ejemplo:
  - Cambia el color de fondo de la tarjeta de cada personaje.
  - Usa un color diferente para el texto de los nombres.
  - Aplica márgenes o tamaños de fuente distintos.
- Usa los siguientes selectores:
  - Un selector de hermanos adyacentes (`+`) para cambiar el color del nombre al pasar el ratón sobre la imagen.

---

### **6. Sección de Eventos en los Parques**
- Diseña una sección con una lista de **eventos próximos en los parques Disney**. Cada evento debe incluir:
  - Un título.
  - Una descripción breve.
  - Una fecha.
- Aplica los siguientes estilos:
  - Haz que dos eventos tengan un diseño idéntico y que el tercero sea diferente (por ejemplo, con un color de fondo o un borde decorativo).
  - Usa selectores de tipo (`ul > li`) y selectores de clase para personalizar cada evento.

---

### **7. Pie de Página**
- Diseña un pie de página que contenga:
  1. Enlaces a redes sociales (Facebook, Instagram y Twitter).
  2. Información de contacto (correo y teléfono).
  3. Derechos de autor con el texto: "© 2025 Mundo Disney. Todos los derechos reservados."
- Usa Flexbox para alinear los elementos horizontalmente.
- Aplica un `background-color` oscuro con texto claro.
- Usa pseudo-clases para cambiar el color de los enlaces al pasar el ratón (`hover`).
