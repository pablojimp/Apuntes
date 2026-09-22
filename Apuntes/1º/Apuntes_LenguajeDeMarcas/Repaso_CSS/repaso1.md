# Ejercicio Práctico CSS + Flexbox  
## Campaña Web de Concienciación Antipirateo

---

## Objetivo

Diseñar los estilos CSS de una página web con temática **antipiratería digital**, aplicando correctamente los contenidos de la **Unidad Didáctica 4**: selectores, clases e id, modelo de caja y Flexbox.

⚠️ **Importante**  
- El HTML ya está dado y **NO debe modificarse en su estructura**, solo añadir clases e identificadores.  
- En el CSS **solo se pueden añadir clases e id a los contenedores** (header, section, div, footer, etc.).  

---

## 1. Estilos globales

1. Añade una clase o id a un contenedor principal para definir:
   - Reseteo de márgenes y paddings.
   - Ajuste del modelo de caja.
2. Define un estilo general de la página:
   - Color de fondo acorde a una campaña antipirateo.
   - Tipografía diferenciada para títulos y texto.
   - Espaciado general coherente.

---

## 2. Encabezado de la campaña

1. Añade una clase o id al `header`.
2. Diseña el encabezado para que:
   - El título principal y el menú de navegación se alineen correctamente en una sola fila.
   - El diseño se adapte cuando el ancho de pantalla disminuya.
3. Estiliza el título para que tenga un aspecto llamativo y contundente.
4. Menú de navegación:
   - Añade una clase al contenedor del menú.
   - Los enlaces deben mostrarse alineados horizontalmente.
   - Elimina estilos por defecto de listas.
5. Enlaces:
   - Aplica un efecto visual al pasar el ratón.
   - Destaca visualmente un enlace como si fuera el activo.
6. Añade un detalle visual decorativo al encabezado (borde, sombra o línea).

---

## 3. Sección principal de impacto (Hero)

1. Añade una clase o id a la primera sección del contenido.
2. Diseña la sección para que:
   - Tenga una altura destacada.
   - El contenido esté correctamente alineado.
3. Aplica una imagen o recurso visual de fondo relacionado con el antipirateo.
4. Estiliza:
   - El título principal como elemento protagonista.
   - El texto descriptivo como subtítulo.
5. Botón de acción:
   - Dale un aspecto claro de llamada a la acción.
   - Añade un efecto visual al pasar el ratón (cambio visual y transformación).

---

## 4. Sección de recursos o casos reales (tarjetas)

1. Añade una clase o id al contenedor de la sección.
2. Añade una clase común a las tarjetas.
3. Diseña la sección para que:
   - Las tarjetas se distribuyan en una misma fila.
   - Exista separación visual entre ellas.
   - Se adapten a distintos tamaños de pantalla.
4. En cada tarjeta:
   - Aplica un diseño tipo tarjeta (fondo, borde, sombra).
   - Estiliza la imagen con bordes redondeados usando un **selector de descendientes**.
   - Estiliza el título usando un **selector de hijo directo**.
5. Botón:
   - Añade un efecto visual al pasar el ratón.

---

## 5. Sección de amenazas o perfiles destacados

1. Añade una clase o id al contenedor de la sección.
2. Añade una clase común a las tarjetas de esta sección.
3. Distribuye las tarjetas usando Flexbox.
4. Aplica estilos diferentes a cada tarjeta:
   - Cambia colores de fondo.
   - Modifica estilos del nombre.
   - Ajusta tamaños o márgenes.
5. Usa un **selector de hermanos adyacentes (`+`)** para que:
   - Al pasar el ratón sobre la imagen, cambie el estilo del nombre del elemento correspondiente.

---

## 6. Sección de eventos o campañas

1. Añade una clase o id al contenedor de la sección.
2. Estiliza la lista:
   - Elimina viñetas y estilos por defecto.
3. Aplica un diseño común a los elementos de la lista usando:
   - Selector de tipo combinado (`ul > li`) junto con clases.
4. Diseña dos eventos con el mismo estilo.
5. Diseña el tercer evento con un estilo claramente diferente.
6. Estiliza la fecha como un elemento visual destacado.

---

## 7. Pie de página

1. Añade una clase o id al `footer`.
2. Diseña el pie de página para que:
   - Sus elementos se alineen horizontalmente.
   - Se adapten al cambiar el tamaño de pantalla.
3. Estiliza:
   - Texto informativo.
   - Lista de redes sociales alineada.
4. Aplica un fondo oscuro con texto claro.
5. Añade efectos visuales en los enlaces al pasar el ratón.

---

## Requisitos finales

- Todo el diseño debe realizarse **exclusivamente con clases e id añadidos a contenedores**.
- Deben utilizarse Flexbox, pseudo-clases y selectores avanzados.
- El diseño debe ser coherente con una campaña de concienciación antipiratería.
- No se debe modificar la estructura HTML.
