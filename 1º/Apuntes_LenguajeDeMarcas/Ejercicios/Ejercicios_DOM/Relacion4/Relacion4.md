# 🍹 Relación 4 - Eventos en JavaScript: “Energy Station”



## ✅ Requisitos (lo que debe hacer tu JavaScript)

### 1) 🖱️ Clic en la imagen
- Al hacer clic en la imagen con id **`imgClick`**, mostrar una alerta con el mensaje:
  - **"¡Siente la Energía de Burn!"**

---

### 2) 🐭 Hover en la imagen
- Cuando el ratón **entre** en la imagen con id **`imgHover`**, cambiar su `src` a:
  - `https://picsum.photos/200?random=99`
- Cuando el ratón **salga**, volver al `src` original.

> Pista: puedes guardar el `src` original en una variable.

---

### 3) ⌨️ Teclas en el campo de texto
- Cada vez que el usuario presione una tecla en el input con id **`campoTexto`**:
  - Mostrar en consola la tecla presionada (usa `event.key`).

---

### 4) 🧾 Submit del formulario (sin recargar)
- Al enviar el formulario con id **`formulario`**:
  - Evitar que la página se recargue con `event.preventDefault()`.
  - Leer el valor del input con id **`nombre`**.
  - Mostrar en el `<p>` con id **`resultado`** el mensaje:
    - **"Energía recargada, [nombre]!"**


Cuando un formulario se envía normalmente, el navegador recarga la página automáticamente. En este ejercicio no queremos que eso pase, sino controlar el envío con JavaScript.

Para hacerlo, debes escuchar el evento `submit` del formulario y, dentro del manejador, usar `event.preventDefault()` para evitar la recarga.

Después, solo tienes que obtener lo que el usuario escribió en el input del nombre usando `.value` y mostrar un mensaje personalizado dentro del párrafo de resultado usando, por ejemplo, `.textContent`.

En resumen: interceptas el envío, lees el dato y lo muestras en pantalla.
---

### 5) 🎯 Focus y Blur en el código
- Cuando el input con id **`codigo`** reciba foco (**focus**):
  - Cambiar el borde del input a verde.
  - Mostrar en `<p id="mensaje">` el texto:
    - **"Introduce tu código de energía"**
- Cuando pierda el foco (**blur**):
  - Restablecer el borde original.
  - Borrar el mensaje.

  Pista: this.style.outline = 'none'; //Para quitar el borde negro al hacer focus
  Usarremos el this cuando hacemos referencia al objeto al que se le ha añadido el Listener


---

## 🧠 Recomendaciones
- Usa `addEventListener`.
- Comprueba que tus selectores (`getElementById`, `querySelector`) apuntan bien.
- Abre la consola del navegador (F12) para ver errores y el registro de teclas.
