# Guía paso a paso · Repaso final Odoo 18 (UD1 · Sistemas de Gestión Empresarial)

> Resuelve los **8 ejercicios** del PDF *UD1 · Repaso final · Odoo* partiendo de cero. Cada paso te dice **qué pantalla abrir, qué botón pulsar y qué escribir**. Los datos (nombres, correos, fechas, importes) ya están decididos: solo tienes que copiarlos.

---

## Cómo leer esta guía

| Símbolo | Significado |
|---|---|
| **Negrita** | Botón, pestaña, menú u opción que tienes que pulsar |
| `código` | Texto que debes escribir o copiar exactamente |
| ➜ | Ruta de menús. `Ventas ➜ Productos ➜ Productos` = menú Ventas, luego Productos, luego Productos |
| ✅ | **Comprobación**: cómo saber que el paso salió bien |
| ⚠️ | **Error típico**: no lo hagas |
| 💡 | Truco |

**Idioma de los botones:** primero en español y, entre paréntesis, en inglés (*así lo reconoces aunque tu Odoo esté en inglés*). El propio PDF avisa de que etiquetas y campos pueden variar según la configuración: si algo no se llama exactamente igual, busca el equivalente por posición y por el icono.

**Fechas:** las pongo en formato `dd/mm/aaaa` (español). Si tu Odoo está en inglés usará `mm/dd/aaaa`: respeta el día real (p. ej. 22 de octubre de 2026).

---

## Índice

0. [Preparación (una sola vez)](#0-preparación-una-sola-vez)
1. [Ejercicio 1 · Contactos](#ejercicio-1--contactos-clientes-proveedores-y-personas)
2. [Ejercicio 2 · CSV (importar / verificar / exportar)](#ejercicio-2--csv-importación-verificación-y-exportación)
3. [Ejercicio 3 · CRM](#ejercicio-3--crm-oportunidades-actividades-y-embudo)
4. [Ejercicio 4 · Ventas (presupuestos)](#ejercicio-4--ventas-presupuestos-conectados-con-el-crm)
5. [Ejercicio 5 · Proyecto](#ejercicio-5--proyecto-planificación-y-seguimiento-de-tareas)
6. [Ejercicio 6 · Calendario](#ejercicio-6--calendario-eventos-cambios-y-actividades-crm)
7. [Ejercicio 7 · Caso integrador Centro Cauce](#ejercicio-7--caso-integrador-encargo-de-centro-cauce)
8. [Ejercicio 8 · Auditoría final](#ejercicio-8--auditoría-de-datos-y-revisión-final)
9. [Checklist final y estado esperado de la base](#checklist-final)
10. [Problemas frecuentes y cómo arreglarlos](#problemas-frecuentes-y-cómo-arreglarlos)

---

## 0. Preparación (una sola vez)

### 0.1 Entrar en Odoo

1. Abre el navegador (Chrome, Edge o Firefox).
2. Escribe en la barra de direcciones: `http://localhost:8069`
   *(8069 es el puerto por defecto de Odoo. Si tu guía de instalación usa otro número, cámbialo.)*
3. Si aparece una pantalla para elegir base de datos, elige tu **base local de pruebas**. **No** pulses "Crear base de datos".
4. Inicia sesión con tu usuario administrador.

### 0.2 Cómo es la pantalla (léelo una vez)

```
┌────────────────────────────────────────────────────────────────────────┐
│ ▦  Ventas   Pedidos  Productos  Informes  Configuración        🕒 💬 👤│  ← BARRA SUPERIOR
├────────────────────────────────────────────────────────────────────────┤
│ [Nuevo]  Presupuestos ⚙           [ 🔍 Buscar...            ▾ ]  ☰ ▦ │  ← PANEL DE CONTROL
├────────────────────────────────────────────────────────────────────────┤
│                                                                        │
│   LISTA / KANBAN / FORMULARIO / CALENDARIO                             │
│                                                                        │
└────────────────────────────────────────────────────────────────────────┘
```

| Pieza | Qué es y para qué se usa |
|---|---|
| **▦ (cuadrícula, arriba a la izquierda)** | Menú de aplicaciones: vuelve a la pantalla con los iconos de todas las apps. Así "cambias" de Contactos a CRM, etc. |
| **Barra superior** | Menús de la app en la que estás (cambian en cada app). |
| **Nuevo** (*New*) | Crea un registro nuevo (contacto, oportunidad, producto…). |
| **Miga de pan** (breadcrumb) `Contactos / Biblioteca Ronda` | Dónde estás. **Pulsar la palabra "Contactos" te devuelve a la lista**. |
| **⚙ engranaje junto a la miga** | Menú de acciones de la vista: aquí están **Importar registros** y **Exportar todo**. |
| **Caja de búsqueda con ▾** | Escribes para buscar. El ▾ abre el panel de **Filtros**, **Agrupar por** y **Favoritos**. |
| **Iconos de vista (arriba a la derecha)** | Cambian entre **Kanban** (tarjetas), **Lista** (filas), **Calendario**, etc. |
| **☁ (nube) y ↩ junto a la miga** | Aparecen cuando editas un formulario: ☁ = **Guardar manualmente**, ↩ = **Descartar cambios**. |
| **Chatter** (zona de mensajes de una ficha) | Tiene tres botones: **Enviar mensaje**, **Registrar nota** (*Log note* = nota interna) y **Actividad** (*Activity* = programar algo pendiente). |

💡 **Hábito para no fallar:** después de escribir en una ficha, pulsa siempre **☁ Guardar**. Odoo suele guardar solo al salir, pero así estás seguro.

### 0.3 Instalar o comprobar las 5 aplicaciones

El PDF pide tener **Contactos, CRM, Ventas, Proyecto y Calendario**.

1. Pulsa **▦** y entra en **Aplicaciones** (*Apps*).
2. En el buscador escribe el nombre de la app (`Contacts`, `CRM`, `Sales`, `Project`, `Calendar`; en español `Contactos`, `CRM`, `Ventas`, `Proyecto`, `Calendario`).
3. Si la tarjeta tiene botón **Activar** / **Instalar** (*Activate* / *Install*), púlsalo y **espera** a que Odoo recargue. Si ya pone *Instalado* o aparece el icono en el menú ▦, no hagas nada.
4. Repite con las cinco.

✅ Al terminar, en la pantalla de iconos (▦) deben verse: **Contactos, CRM, Ventas, Proyecto, Calendario**.

⚠️ Instala **CRM y Ventas los dos**: es lo que hace aparecer el botón **Nuevo presupuesto** dentro de las oportunidades (Ejercicio 4). Al instalar Ventas, Odoo instala también *Facturación*: es normal, **no lo uses**.

### 0.4 Buscar, filtrar y agrupar (se usa en todos los ejercicios)

Todas las listas y tableros tienen la misma caja de búsqueda:

| Acción | Cómo se hace |
|---|---|
| **Buscar por texto** | Escribe en la caja (por ejemplo `REP26`) y pulsa **Enter**. Aparece una "pastilla" (facet) con tu búsqueda. A veces Odoo ofrece opciones tipo *Buscar Nombre para: REP26*: elige la que corresponda. |
| **Aplicar un filtro** | Pulsa **▾** (a la derecha de la caja) ➜ columna **Filtros** ➜ marca la opción (p. ej. **Empresas**). |
| **Agrupar** | **▾** ➜ columna **Agrupar por** ➜ elige una opción. La lista se parte en grupos con un contador. |
| **Quitar un filtro/búsqueda/agrupación** | Pulsa la **✕** de su pastilla en la caja, o desmarca la opción en el ▾. |
| **Ver lista en vez de tarjetas** | Icono **☰** (lista) arriba a la derecha. |
| **Seleccionar varios registros** | En vista **Lista**, marca las casillas de la izquierda de cada fila. Aparece arriba "N seleccionados" y un botón **⚙ Acciones**. |

⚠️ Algunas apps (CRM, Proyecto) traen un **filtro puesto por defecto** (p. ej. *Mi pipeline* o *Mis tareas*). Si buscas algo y "no sale", mira si hay una pastilla de filtro que tengas que quitar.

### 0.5 Reglas de oro (evitan el 90 % de los fallos)

1. **Prefijo `[REP26]` en TODO lo nuevo que se pueda buscar por nombre** (empresas, personas, oportunidades, servicios, proyectos, tareas, eventos). Así lo localizas con una sola búsqueda y distingues tus datos de los que ya existían. *(El PDF solo lo escribe en algunos nombres, pero la instrucción general lo pide para todos; añadirlo nunca perjudica.)*
2. **Cuando un campo sea un desplegable de registros existentes** (Cliente, Empresa, Producto…), **elige la opción ya existente** de la lista. ⚠️ **Nunca** pulses **Crear "…"** / **Crear y editar…**: crearía un duplicado.
3. **Para corregir algo, edita la ficha que ya existe.** No crees otra.
4. **Prohibido pulsar**: **Confirmar**, **Enviar por correo**, **Crear factura**, **Ganado** (*Won*), **Perdido** (*Lost*), **Cancelar**. Los presupuestos se quedan en *Presupuesto* (borrador).
5. **Datos 100 % ficticios**, con correos acabados en `@example.test`. En los eventos **no añadas invitados** distintos de ti.
6. **Comprueba cada cambio reabriéndolo**: sal de la ficha (miga de pan) y vuelve a entrar.
7. Si al escribir el nombre de una empresa aparece un desplegable con **sugerencias de empresas reales** (autocompletado), **ignóralo**: no elijas ninguna, sigue escribiendo o pulsa Tab.

### 0.6 Datos maestros (copia y pega desde aquí)

**Empresas y personas (Ejercicio 1)**

| Tipo | Nombre | Correo | Puesto / Nota interna |
|---|---|---|---|
| Empresa | `[REP26] Biblioteca Ronda` | `biblioteca.ronda.rep26@example.test` | Nota: `REP26 - Actúa como CLIENTE` |
| Empresa | `[REP26] Centro Horizonte` | `centro.horizonte.rep26@example.test` | Nota: `REP26 - Actúa como CLIENTE`. Teléfono inicial `958 000 001` → luego `958 000 002` |
| Empresa | `[REP26] Academia Mirador` | `academia.mirador.rep26@example.test` | Nota: `REP26 - Actúa como CLIENTE` |
| Empresa | `[REP26] Distribuciones Nube` | `distribuciones.nube.rep26@example.test` | Nota: `REP26 - Actúa como PROVEEDOR` |
| Persona (de Biblioteca Ronda) | `[REP26] Laura Ronda` | `laura.ronda.rep26@example.test` | Puesto: `Directora` |
| Persona (de Centro Horizonte) | `[REP26] Sara Vega` | `sara.vega.rep26@example.test` | Puesto: `Coordinadora` |
| Persona (de Distribuciones Nube) | `[REP26] Mario Luna` | `mario.luna.rep26@example.test` | Puesto: `Comercial` |

**Empresas del CSV (Ejercicio 2)**

| Nombre | Correo |
|---|---|
| `[REP26] TecnoLuz` | `tecnoluz.rep26@example.test` |
| `[REP26] Editorial Alba` | `editorial.alba.rep26@example.test` |
| `[REP26] Oficina Río` | `oficina.rio.rep26@example.test` |

**Oportunidades (Ejercicios 3, 4 y 7)**

| Nombre | Cliente | Ingreso esperado |
|---|---|---|
| `[REP26] Centro Horizonte - 6 portátiles` | `[REP26] Centro Horizonte` | 3600 |
| `[REP26] Academia Mirador - 2 proyectores` | `[REP26] Academia Mirador` | 900 |
| `[REP26] Centro Horizonte - mantenimiento` | `[REP26] Centro Horizonte` | 240 |
| `[REP26] Academia Mirador - software y formación` *(la "oportunidad nueva" del Ej. 4)* | `[REP26] Academia Mirador` | 160 |
| `[REP26] Centro Cauce - 6 puestos y formación` *(Ej. 7)* | `[REP26] Centro Cauce` | 490 |

**Servicios (Ejercicios 4 y 7)**

| Nombre | Precio | Tipo |
|---|---|---|
| `[REP26] Puesta a punto de portátil` | 45 € / ud. | Servicio |
| `[REP26] Instalación de software` | 30 € / ud. | Servicio |
| `[REP26] Formación individual` | 35 € / hora | Servicio |
| `[REP26] Preparación de puesto informático` | 70 € / ud. | Servicio |

**Presupuestos (subtotales sin impuestos que debes ver)**

| Presupuesto | Líneas | Subtotal |
|---|---|---|
| Centro Horizonte – mantenimiento | 4 → **6** puestas a punto (45) + 2 instalaciones (30) | 240 → **330 €** |
| Academia Mirador | 3 instalaciones (30) + 2 h formación (35) | **160 €** |
| Centro Cauce | 6 preparaciones (70) + 2 h formación (35) | **490 €** |

**Fechas que uso** (hoy es martes 20/10/2026; todas son futuras y en día laborable)

| Qué | Fecha |
|---|---|
| Actividad llamada (Ej. 3) | 23/10/2026 |
| Actividad seguimiento (Ej. 3) | 26/10/2026 |
| Fechas límite tareas Ej. 5 | Inventariar equipos 30/10/2026 · Actualizar navegadores 02/11/2026 (luego 09/11/2026) · Redactar informe 06/11/2026 |
| Reunión interna (Ej. 6) | jueves 22/10/2026 de 10:00 a 10:45 → luego viernes 23/10/2026 10:00–10:45 |
| Eventos solapados (Ej. 6) | miércoles 21/10/2026 11:00–11:30 los dos → el segundo pasa a 12:00–12:30 |
| Actividad reunión del CRM (Ej. 6) | 27/10/2026 |
| Actividad "Definir alcance" (Ej. 7) | 26/10/2026 |
| Fechas límite tareas Centro Cauce (Ej. 7) | 30/10/2026 · 03/11/2026 · 05/11/2026 |
| Evento Coordinación Centro Cauce (Ej. 7) | miércoles 28/10/2026 10:00–10:30 |

### 0.7 Orden de trabajo

Haz los ejercicios **en orden 1 → 8**: se reutilizan registros (E03 usa empresas del E01; E04 usa la oportunidad del E03; E06 usa la del E03; E07 usa servicios del E04; E08 revisa todo).

---

## Ejercicio 1 · Contactos: clientes, proveedores y personas

**App:** Contactos (▦ ➜ **Contactos**). Verás tarjetas (vista Kanban). Pulsa el icono **☰** (arriba a la derecha) para ver la **lista**.

**Objetivo final:** 4 empresas + 3 personas vinculadas (no siete empresas), y el cambio de teléfono guardado.

### Paso 1 · Crear las 4 empresas (+ nota interna cliente/proveedor)

Repite lo siguiente **una vez por empresa** (datos en la tabla 0.6):

1. Pulsa **Nuevo** (*New*).
2. Arriba en el formulario hay un selector **Individual / Empresa**. Pulsa **Empresa** (*Company*).
3. En el campo grande de nombre escribe `[REP26] Biblioteca Ronda`.
4. En **Correo electrónico** (*Email*) escribe `biblioteca.ronda.rep26@example.test`.
5. *(Solo en Centro Horizonte)* En **Teléfono** (*Phone*) escribe `958 000 001`. Hazlo ya, porque en el paso 3 lo vas a cambiar.
6. En la parte inferior del formulario hay pestañas: **Contactos y direcciones**, **Ventas y compras**, **Facturación**, **Notas internas**. Pulsa **Notas internas** (*Internal Notes*), haz clic en el cuadro de texto y escribe `REP26 - Actúa como CLIENTE` (o `... PROVEEDOR` en Distribuciones Nube).
7. Pulsa **☁ Guardar**.

✅ La miga de pan muestra `Contactos / [REP26] Biblioteca Ronda` y el icono de la ficha es el de un edificio (empresa).

Repite para `[REP26] Centro Horizonte`, `[REP26] Academia Mirador` y `[REP26] Distribuciones Nube`.

⚠️ No uses el botón **Duplicar** (copiaría correos y datos).

### Paso 2 · Crear las 3 personas y vincularlas a su empresa

**Método recomendado (queda vinculada automáticamente):**

1. Abre la empresa (por ejemplo `[REP26] Biblioteca Ronda`) desde la lista de Contactos.
2. Pestaña **Contactos y direcciones** (*Contacts & Addresses*) ➜ botón **Añadir** (*Add*).
3. Se abre una ventana emergente. Deja **Tipo de contacto = Contacto** y rellena:
   - **Nombre:** `[REP26] Laura Ronda`
   - **Puesto de trabajo** (*Job Position*): `Directora`
   - **Correo electrónico:** `laura.ronda.rep26@example.test`
4. Pulsa **Guardar y cerrar** (*Save & Close*).
5. En la ficha de la empresa pulsa **☁ Guardar**.

Repite con `[REP26] Sara Vega` (en Centro Horizonte, puesto `Coordinadora`) y `[REP26] Mario Luna` (en Distribuciones Nube, puesto `Comercial`).

**Método alternativo (desde cero):** **Nuevo** ➜ selector **Individual** ➜ nombre ➜ en el campo bajo el nombre (placeholder *Empresa…*) escribe `Biblioteca Ronda` y **elige del desplegable la empresa que ya existe** (⚠️ no "Crear…") ➜ rellena puesto y correo ➜ **☁ Guardar**.

✅ En la ficha de la persona, el campo de empresa muestra la empresa correcta. En la ficha de la empresa, la pestaña **Contactos y direcciones** muestra a la persona.

### Paso 3 · Cambiar el teléfono de Centro Horizonte

1. Abre `[REP26] Centro Horizonte`.
2. Haz clic en **Teléfono**, borra el valor y escribe `958 000 002`.
3. Pulsa **☁ Guardar**.
4. Pulsa **Contactos** en la miga de pan (vuelves a la lista) y **vuelve a abrir** Centro Horizonte.

✅ El teléfono es `958 000 002` y no existe una segunda ficha de Centro Horizonte.

### Paso 4 · Buscar, filtrar y agrupar (y quitarlo después)

Estando en la **lista** de Contactos:

1. **Búsqueda por parte del nombre:** escribe `Ronda` en la caja y pulsa **Enter**. Salen `Biblioteca Ronda` y `Laura Ronda`.
2. **Filtro de empresas:** pulsa **▾** ➜ en **Filtros** marca **Empresas** (*Companies*). Ahora solo salen fichas de empresa (Laura desaparece).
3. **Agrupación:** en el mismo panel, **Agrupar por** ➜ elige una opción disponible (**Empresa**, **País**, **Comercial**…; la que tengas). La lista se divide en grupos con contador.
4. **Quitar todo:** pulsa la **✕** de cada pastilla de la caja de búsqueda (búsqueda, filtro, agrupación) hasta que la caja quede vacía.
5. **Observa:** al quitar filtro y agrupación vuelve a salir la lista completa y plana.

### Paso 5 · Buscar tus fichas y comprobar vinculaciones y duplicados

1. En la caja de búsqueda escribe `REP26` y pulsa **Enter**.
2. Cuenta los resultados: **7 fichas** (4 empresas + 3 personas). Cada nombre aparece **una sola vez**.
3. Filtro **Empresas** ➜ debe haber **4**. Cambia a **Particulares/Individuos** (*Individuals*) ➜ **3**. (Desmarca uno antes de marcar el otro.)
4. Abre cada persona y mira el campo de empresa: Laura ➜ Biblioteca Ronda, Sara ➜ Centro Horizonte, Mario ➜ Distribuciones Nube.

✅ **Resultado esperado del E01:** 4 empresas + 3 personas vinculadas; teléfono de Centro Horizonte = `958 000 002`.

---

## Ejercicio 2 · CSV: importación, verificación y exportación

**App:** Contactos. Aquí es donde más se falla, así que sigue el orden exacto.

> ⚠️ **No importes de nuevo contactos que ya existen** (los del Ejercicio 1). Este CSV lleva **tres empresas nuevas** distintas.

### Paso 1 · Exportar un contacto de prueba y preparar el CSV

**1a. Exportar un contacto de prueba (para ver los nombres de campo):**

1. Contactos ➜ vista **Lista** (☰) ➜ busca `REP26`.
2. Marca la casilla de **una sola** empresa (p. ej. Biblioteca Ronda). Arriba aparece "1 seleccionado".
3. **⚙ Acciones** ➜ **Exportar** (*Export*).
4. En la ventana:
   - Marca **Quiero actualizar datos (exportación compatible con importación)** (*I want to update data (import-compatible export)*).
   - Formato: **CSV**.
   - A la derecha están los **campos a exportar**. Si hay alguno que no sea `Nombre` ni `Correo electrónico`, quítalo con su icono **🗑/✕**.
   - Para añadir campos usa el buscador de la izquierda (`Name`, `Email`) y haz doble clic o pulsa el **+**.
5. Pulsa **Exportar**. Se descarga un `.csv`.
6. Ábrelo con el **Bloc de notas** (no con Excel) y mira la primera línea: son los **nombres de columna** que Odoo entiende (por ejemplo `Name,Email`).

**1b. Crear `E02_importacion.csv`:**

1. Abre el **Bloc de notas** (o VS Code).
2. Pega **exactamente** esto:

```csv
name,email,is_company
[REP26] TecnoLuz,tecnoluz.rep26@example.test,1
[REP26] Editorial Alba,editorial.alba.rep26@example.test,1
[REP26] Oficina Río,oficina.rio.rep26@example.test,1
```

   - `name` = nombre, `email` = correo, `is_company` = "es empresa" (`1` = sí). Son los nombres **técnicos**; Odoo los reconoce aunque esté en español o inglés.
   - Si prefieres usar las cabeceras que viste en tu exportación (`Name,Email`), también vale: solo tendrás que mapear la tercera columna a mano.
3. **Archivo ➜ Guardar como…**
   - Nombre: `E02_importacion.csv`
   - Tipo: **Todos los archivos (\*.\*)** (si no, añade `.txt` sin querer).
   - **Codificación: UTF-8** (desplegable abajo a la derecha). *Es lo que hace que "Río" no salga como "RÃ­o".*
4. Guarda en una carpeta que recuerdes (por ejemplo Escritorio).

💡 Si usas Excel: **Guardar como ➜ CSV UTF-8 (delimitado por comas)**. Un Excel en español puede poner `;` como separador: en ese caso, en Odoo elige **Separador = Punto y coma**.

### Paso 2 · Abrir la importación, mapear y pulsar *Probar*

1. En Contactos pulsa el **⚙ engranaje junto al título "Contactos"** (miga de pan) ➜ **Importar registros** (*Import records*). *(Si no lo ves en la vista de tarjetas, cambia a lista con ☰ y repite.)*
2. Pulsa **Cargar archivo / Subir archivo de datos** (*Upload Data File*) y elige `E02_importacion.csv`.
3. Verás a la izquierda las **opciones de formato** (Formato CSV, **Codificación UTF-8**, **Separador Coma**, delimitador `"`). Déjalas así.
4. A la derecha hay una tabla de **mapeo**: columna del archivo ➜ campo de Odoo.
   - `name` ➜ **Nombre**
   - `email` ➜ **Correo electrónico**
   - `is_company` ➜ **Es una empresa** (*Is a Company*)
   - Si una columna sale **sin campo o en rojo/con ✗**, pulsa su desplegable, escribe el nombre del campo y elígelo.
5. Pulsa **Probar** (*Test*).

✅ Debe salir un mensaje verde tipo *"Todo parece válido"* (*Everything seems valid*). **Todavía no pulses Importar.**

### Paso 3 · Importar UNA sola vez y verificar

1. Pulsa **Importar** (*Import*) **una sola vez** y espera a que cargue la lista.
2. Busca `REP26` ➜ deben aparecer **TecnoLuz, Editorial Alba y Oficina Río, cada una una vez**.
3. Ábrelas: el icono debe ser de **empresa**. Si alguna aparece como persona, edita la ficha: selector **Individual / Empresa** ➜ **Empresa** ➜ **☁ Guardar** (el PDF permite corregir desde la interfaz).

⚠️ Si pulsas Importar dos veces tendrás **6** fichas. Arreglo: marca las duplicadas ➜ **⚙ Acciones** ➜ **Eliminar** (*Delete*) (o **Archivar** si no te deja).

### Paso 4 · Probar un CSV defectuoso (sin importarlo)

1. Copia `E02_importacion.csv` y llámalo `E02_importacion_defectuoso.csv`.
2. Déjalo así (nombre vacío en la segunda fila):

```csv
name,email,is_company
[REP26] TecnoLuz,tecnoluz.rep26@example.test,1
,editorial.alba.rep26@example.test,1
[REP26] Oficina Río,oficina.rio.rep26@example.test,1
```

3. Contactos ➜ **⚙** ➜ **Importar registros** ➜ carga el defectuoso ➜ pulsa **Probar**.
4. Observa el **aviso/error** (algo como *"Contacts require a name"* o *"falta un valor obligatorio en Nombre"*; el texto exacto puede variar). Fíjate en que indica la **fila** del problema.
5. **NO pulses Importar.** Sal con **Cancelar** (*Cancel*) o pulsando **Contactos** en la miga de pan.

✅ No se ha creado ninguna ficha nueva (Probar no escribe nada).

### Paso 5 · Exportar solo las 3 empresas importadas y compararlo

1. Contactos ➜ **Lista** (☰) ➜ busca `REP26`.
2. Marca **solo** las casillas de `[REP26] TecnoLuz`, `[REP26] Editorial Alba` y `[REP26] Oficina Río`. Arriba debe poner **3 seleccionados**.
3. **⚙ Acciones** ➜ **Exportar**.
4. En la ventana: **desmarca** *Quiero actualizar datos* (así sale un CSV limpio), formato **CSV**, y deja **solo** los campos `Nombre` y `Correo electrónico`.
5. Pulsa **Exportar** y abre el archivo con el **Bloc de notas**.

Debe parecerse a esto (Odoo puede poner comillas en todos los valores y usar `,` o `;`; no se penaliza):

```csv
"Name","Email"
"[REP26] TecnoLuz","tecnoluz.rep26@example.test"
"[REP26] Editorial Alba","editorial.alba.rep26@example.test"
"[REP26] Oficina Río","oficina.rio.rep26@example.test"
```

6. **Compara con tu archivo inicial y comprueba:**
   - ✅ **Cabecera:** 1 línea de cabecera.
   - ✅ **Filas:** 3 líneas de datos (4 líneas en total).
   - ✅ **Tildes:** "Río" se lee bien.
   - ✅ **Correos:** los 3 son distintos.
7. **No edites el CSV exportado a mano** (la revisión final lo pregunta). Renómbralo a `E02_exportado.csv` si quieres guardarlo.

---

## Ejercicio 3 · CRM: oportunidades, actividades y embudo

**App:** CRM (▦ ➜ **CRM**). La pantalla principal es el **Pipeline**: columnas (etapas) como *Nuevo, Calificado, Propuesta, Ganado* con tarjetas dentro.

**Reutiliza** `[REP26] Centro Horizonte` y `[REP26] Academia Mirador` del E01. **No** las vuelvas a crear.

### Paso 1 y 2 · Crear las 3 oportunidades

Repite **una vez por oportunidad** (datos en la tabla 0.6):

1. En el Pipeline pulsa **Nuevo** (*New*). Aparece una tarjeta rápida en la primera columna.
2. **Organización / Contacto** (*Organization / Contact*): escribe `Horizonte` y elige del desplegable **`[REP26] Centro Horizonte`** (la empresa). ⚠️ No elijas a la persona Sara Vega ni "Crear…".
3. **Oportunidad** (*Opportunity*): `[REP26] Centro Horizonte - 6 portátiles`
4. **Ingreso esperado** (*Expected Revenue*): `3600`
5. Pulsa **Editar** (*Edit*) para abrir la ficha completa (así compruebas el cliente). Pulsa **☁ Guardar**.

Crea igual:
- `[REP26] Academia Mirador - 2 proyectores` · cliente `[REP26] Academia Mirador` · `900`
- `[REP26] Centro Horizonte - mantenimiento` · cliente `[REP26] Centro Horizonte` · `240`

✅ En la ficha, **Cliente** = la empresa correcta e **Ingreso esperado** = el importe (3.600,00 € / 900,00 € / 240,00 €).

### Paso 3 · Actividades (llamada y seguimiento) y nota

**Oportunidad 1 – `Centro Horizonte - 6 portátiles`:**

1. Ábrela. En el chatter pulsa **Actividad** (*Activity* / *Schedule Activity*).
2. En la ventana rellena:
   - **Tipo de actividad:** `Llamada` (*Call*)
   - **Resumen:** `Llamada inicial 6 portátiles`
   - **Fecha límite:** `23/10/2026`
   - **Asignado a:** tú
3. Pulsa **Programar** (*Schedule*).
   ⚠️ **No** pulses *Programar y marcar como hecha* (*Schedule & Mark as Done*).

**Oportunidad 2 – `Academia Mirador - 2 proyectores`:**

1. Ábrela ➜ **Actividad**.
   - **Tipo:** `Por hacer` (*To-Do*) (vale también *Llamada* o *Correo*)
   - **Resumen:** `Seguimiento proyectores`
   - **Fecha límite:** `26/10/2026`
2. **Programar**. **Déjala pendiente** (no la marques como hecha).

**Volver a la oportunidad 1 – primero la nota, después "hecho":**

1. En el chatter pulsa **Registrar nota** (*Log note*) y escribe:
   `Simulación de seguimiento: llamada realizada, el cliente pide confirmar el presupuesto.`
   Pulsa **Registrar** (*Log*).
2. Ahora, en **Actividades planificadas** (*Planned Activities*), despliega la llamada y pulsa **✓ Marcar como hecha** (*Mark Done*).
3. En la ventanita que sale (feedback opcional) pulsa **Hecho** (*Done*).
   ⚠️ **No** pulses *Hecho y programar la siguiente* (*Done & Schedule Next*).

✅ La nota queda **antes** del registro de "actividad hecha" en el chatter. La actividad de la oportunidad 2 sigue pendiente.

### Paso 4 · Avanzar solo la primera oportunidad

1. Abre `Centro Horizonte - 6 portátiles`.
2. Arriba a la derecha está la **barra de etapas**. Pulsa la etapa siguiente a la actual (normalmente **Calificado** / *Qualified*).
   ⚠️ **No** pulses **Ganado** ni **Perdido**.
3. **Registrar nota:** `Avance ficticio: el cliente confirma interés, pasa a calificado.` ➜ **Registrar**.

✅ La etapa resaltada ya no es la primera. Las otras dos oportunidades siguen en **Nuevo**.

### Paso 5 · Buscar, filtrar y agrupar

1. Vuelve al Pipeline (miga de pan **CRM**/**Pipeline**).
2. En la caja de búsqueda, **quita** la pastilla *Mi pipeline* si estorba, escribe `REP26` y pulsa **Enter** (elige la opción *Buscar Oportunidad…* si te la ofrece).
3. **▾** ➜ **Filtros** ➜ **Oportunidades abiertas** (*Open Opportunities*) (o la opción equivalente).
4. **▾** ➜ **Agrupar por** ➜ **Etapa** (*Stage*). *(El Kanban ya agrupa por etapa; en vista Lista, ☰, verás los grupos con totales.)*
5. Cambia a **Lista (☰)** para ver columnas de **Cliente** e **Ingreso esperado**.
6. **Abre cada una** y confirma cliente e importe.

✅ **Resultado esperado del E03:** 3 oportunidades abiertas con **3.600 €, 900 € y 240 €**; solo `6 portátiles` ha avanzado de etapa.

> ℹ️ En el E04 y el E07 se crearán 2 oportunidades más; la comprobación de "tres" es **al terminar el E03**.

---

## Ejercicio 4 · Ventas: presupuestos conectados con el CRM

**Apps:** Ventas y CRM. **No confirmes, factures ni envíes.** Trabaja con importes **sin impuestos** ("Importe sin impuestos" / *Untaxed Amount*).

### Paso 1 · Crear los 3 servicios

Repite **una vez por servicio**:

1. ▦ ➜ **Ventas** ➜ menú **Productos** ➜ **Productos**.
2. Pulsa **Nuevo**.
3. **Nombre del producto:** `[REP26] Puesta a punto de portátil`
4. Debajo del nombre, deja marcada la casilla **Puede ser vendido** (*Sales* / *Can be Sold*).
5. Pestaña **Información general** (*General Information*):
   - **Tipo de producto** (*Product Type*): **Servicio** (*Service*). ⚠️ No *Bienes/Goods*.
   - **Precio de venta** (*Sales Price*): `45`
   - Deja el resto como está (en *Crear en el pedido* / *Create on Order* deja **Nada**).
6. **☁ Guardar**.

Crea igual:
- `[REP26] Instalación de software` · Servicio · `30`
- `[REP26] Formación individual` · Servicio · `35`

💡 **Unidad "hora" (opcional):** para que Formación individual salga en horas, activa `Ventas ➜ Configuración ➜ Ajustes` ➜ sección Catálogo de productos ➜ **Unidades de medida** ➜ **Guardar**; luego en el producto elige **Unidad de medida = Horas**. Si no encuentras la opción, **sáltatelo**: el ejercicio solo comprueba el subtotal (35 × 2 = 70).

✅ **Revisa que son tipo Servicio:** en `Ventas ➜ Productos ➜ Productos`, busca `REP26`, ábrelos o agrupa por **Tipo de producto** y comprueba que los tres están en *Servicio*.

### Paso 2 · Presupuesto de Centro Horizonte – mantenimiento (240 €)

1. ▦ ➜ **CRM** ➜ abre la oportunidad `[REP26] Centro Horizonte - mantenimiento`.
2. Pulsa **Nuevo presupuesto** (*New Quotation*) (arriba, junto a Ganado/Perdido).
   *(Si no aparece, mira "Problemas frecuentes".)*
3. Se abre el formulario de presupuesto. El **Cliente** ya viene relleno (`[REP26] Centro Horizonte`).
4. Pestaña **Líneas del pedido** (*Order Lines*) ➜ **Añadir un producto** (*Add a product*):
   - **Producto:** escribe `Puesta a punto` y elige `[REP26] Puesta a punto de portátil` ➜ **Cantidad** `4` (precio 45 automático).
5. De nuevo **Añadir un producto**:
   - `[REP26] Instalación de software` ➜ **Cantidad** `2` (precio 30).
6. Abajo a la derecha mira **Importe sin impuestos** (*Untaxed Amount*): debe ser **240,00 €** (4 × 45 + 2 × 30).
7. **☁ Guardar**.

⚠️ **No pulses** **Confirmar** (*Confirm*) ni **Enviar por correo** (*Send by Email*), y no compartas el presupuesto con nadie.

### Paso 3 · Editar ese mismo presupuesto (4 → 6)

1. En el **mismo** presupuesto, haz clic en la **Cantidad** de la línea de *Puesta a punto* y cambia `4` por `6`.
2. **Importe sin impuestos** pasa a **330,00 €** (6 × 45 + 2 × 30).
3. **☁ Guardar**. Déjalo **sin confirmar**: arriba debe seguir marcado **Presupuesto** (*Quotation*).
4. Recarga la página (**F5**) para comprobar que 330 € persiste.

### Paso 4 · Segundo presupuesto (Academia Mirador, 160 €)

1. CRM ➜ **Nuevo**. En la tarjeta rápida:
   - **Organización / Contacto:** `[REP26] Academia Mirador` (elígela del desplegable)
   - **Oportunidad:** `[REP26] Academia Mirador - software y formación`
   - **Ingreso esperado:** `160`
2. **Editar** ➜ **☁ Guardar**.
3. Pulsa **Nuevo presupuesto** y añade:
   - `[REP26] Instalación de software` ➜ Cantidad `3`
   - `[REP26] Formación individual` ➜ Cantidad `2`
4. **Importe sin impuestos = 160,00 €** (3 × 30 + 2 × 35).
5. **☁ Guardar**, sin confirmar.

> Esta es la "oportunidad nueva" que pide el enunciado: será la 4.ª oportunidad REP26 (la 5.ª será la de Centro Cauce en el E07).

### Paso 5 · Buscar ambos presupuestos y revisar el enlace con el CRM

1. ▦ ➜ **Ventas** ➜ **Pedidos** ➜ **Presupuestos** (*Orders ➜ Quotations*).
2. En la caja de búsqueda escribe `REP26` y elige **Buscar Cliente para: REP26** (*Search Customer for*).
3. Deben salir **2 presupuestos** (Centro Horizonte y Academia Mirador) con estado **Presupuesto**.
4. Vuelve a **CRM** ➜ abre `Centro Horizonte - mantenimiento`. Arriba a la derecha hay un botón-contador **Presupuestos** (*Quotations*) con un **1**: púlsalo y verás el presupuesto enlazado (ese es el "enlace real").
5. Mira el **Ingreso esperado**: sigue siendo **240 €** (no 330 €).

✅ **Por qué:** el ingreso esperado del CRM es un campo que se escribe a mano; el presupuesto **no lo actualiza solo**. Solo cambiaría si tú lo editas.

✅ **Resultado esperado del E04:** subtotales **330 €** y **160 €** sin impuestos; los dos en *Presupuesto*; ninguno confirmado. (El total con impuestos puede ser distinto según la configuración de la base.)

---

## Ejercicio 5 · Proyecto: planificación y seguimiento de tareas

**App:** Proyecto (▦ ➜ **Proyecto**). Pantalla principal: tarjetas de proyectos.

### Paso 1 · Crear el proyecto y sus 3 etapas

1. Pulsa **Nuevo**.
2. **Nombre del proyecto:** `[REP26] AulaTec - revisión de equipos`.
3. Pulsa **Crear proyecto** (*Create Project*). Se abre el **tablero de tareas** (columnas = etapas).
4. **Crear las etapas:** a la derecha de las columnas hay un hueco para **añadir columna** (*Add column* / **+ Etapa**).
   - Escribe `Pendiente` ➜ pulsa **Enter** o **Añadir**.
   - Repite con `En curso` y `Finalizado`.
5. **Si ya existen columnas por defecto** (por ejemplo *Inbox/Por hacer, En curso/In Progress, Hecho/Done, Cancelada*): **no las borres ni las renombres** (pueden estar compartidas con otros proyectos de la base). Deja esas columnas **vacías** y trabaja con tus tres columnas nuevas. El PDF permite "utilizar o adaptar las opciones equivalentes".

✅ Se ven las columnas `Pendiente`, `En curso`, `Finalizado`.

### Paso 2 · Crear las 6 tareas con descripción

Crea las tareas **en la columna Pendiente**: pasa el ratón por la cabecera de `Pendiente` y pulsa el **+**, escribe el nombre y pulsa **Añadir**. Hazlo 6 veces:

| Tarea | Descripción (cópiala) |
|---|---|
| `[REP26] Inventariar equipos` | `Listar todos los equipos del aula con marca, modelo y número de serie.` |
| `[REP26] Revisar antivirus` | `Comprobar que el antivirus está activo y actualizado en cada equipo.` |
| `[REP26] Actualizar navegadores` | `Actualizar Chrome y Firefox a la última versión estable.` |
| `[REP26] Comprobar red` | `Verificar conectividad, velocidad y puntos de acceso Wi-Fi.` |
| `[REP26] Redactar informe` | `Redactar el informe final con el estado de los equipos.` |
| `[REP26] Documentar incidencias` | `Registrar cada incidencia detectada con fecha y solución aplicada.` |

Luego **abre cada tarea** (clic en la tarjeta) y escribe la descripción en la pestaña **Descripción** (*Description*) (clic en el recuadro de texto) ➜ **☁ Guardar**.

### Paso 3 · Fechas límite y asignación

Abre cada tarea y rellena **Fecha límite** (*Deadline*) con una fecha futura:

| Tarea | Fecha límite |
|---|---|
| Inventariar equipos | `30/10/2026` |
| Actualizar navegadores | `02/11/2026` |
| Redactar informe | `06/11/2026` |

*(Tres tareas **distintas**.)* En `Inventariar equipos`, en **Asignados** (*Assignees*) elige tu usuario. **☁ Guardar** cada una.

### Paso 4 · Mover tareas y marcar estado

1. **Arrastra** (clic mantenido) `Inventariar equipos` y `Revisar antivirus` a la columna **En curso**.
   *(Alternativa sin arrastrar: abre la tarea y en la barra de etapas de arriba pulsa **En curso**.)*
2. Después arrastra **solo** `Inventariar equipos` a **Finalizado**.
3. En la tarjeta de `Inventariar equipos` hay un **círculo de estado** (abajo a la derecha de la tarjeta, o junto al título en el formulario). Púlsalo y elige **Hecha / Hecho** (*Done*) (si tu instalación tiene *Listo* o *Aprobada*, vale esa). Es el estado "Listo" del enunciado.

✅ **Diferencia que debes saber explicar:**
- **Etapa** (*stage*) = la **columna** del tablero (Pendiente → En curso → Finalizado): dónde está la tarea en el flujo.
- **Estado** (*state*) = el **círculo** de la tarea (En curso, Cambios solicitados, Aprobada, Hecha, Cancelada): indica su situación, y **es independiente de la columna**.

### Paso 5 · Cambiar una fecha límite con nota

1. En el tablero, busca `Actualizar navegadores` en la caja de búsqueda (o haz clic en su tarjeta).
2. Cambia **Fecha límite** a `09/11/2026`.
3. En el chatter ➜ **Registrar nota**: `Cambio de fecha límite por reorganización del calendario (dato ficticio).` ➜ **Registrar**.
4. **☁ Guardar**. Sal (miga de pan) y **reabre** la tarea ➜ la fecha es `09/11/2026`.

### Paso 6 · Revisar el tablero (6 tareas, sin duplicados)

1. Vuelve al tablero. Aplica un filtro (**▾** ➜ **Filtros** ➜ p. ej. **Mis tareas** o **Fecha límite**) y **quítalo** con su ✕.
2. Para contar bien: pulsa **☰ Lista** y, si quieres, **▾ ➜ Agrupar por ➜ Etapa**: cada grupo muestra su contador.

✅ **Resultado esperado del E05:** **6 tareas** en total; **Pendiente 4**, **En curso 1** (`Revisar antivirus`), **Finalizado 1** (`Inventariar equipos`).

---

## Ejercicio 6 · Calendario: eventos, cambios y actividades CRM

**Apps:** Calendario y CRM. **Sin invitados externos.** Los eventos solo deben tener como asistente a ti mismo.

### Paso 1 · Reunión interna de 45 minutos

1. ▦ ➜ **Calendario**. Arriba a la derecha elige vista **Semana** (desplegable *Día / Semana / Mes / Año*). Navega con las flechas **‹ ›** hasta la semana del **22/10/2026**.
2. Crea el evento:
   - **Opción A (formulario completo):** pulsa **Nuevo** (si tu Odoo lo muestra).
   - **Opción B:** en la vista Semana, haz clic en el jueves 22 a las 10:00 (o arrastra de 10:00 a 10:45). Se abre una ventana "Nuevo evento": escribe el título y pulsa **Más opciones** (*More Options*) para abrir el formulario completo.
3. En el formulario:
   - **Asunto de la reunión:** `[REP26] Reunión interna AulaTec`
   - **Inicio:** `22/10/2026` `10:00`
   - **Duración:** `00:45` (el fin se calcula solo: 10:45)
   - **Asistentes:** **deja solo tu usuario**. ⚠️ No añadas a nadie más.
   - Pestaña **Descripción:** `Coordinación interna del equipo. Reunión interna, sin invitados externos.`
4. **☁ Guardar** (o **Guardar y cerrar**).

### Paso 2 · Ver que no está duplicada

1. Vista **Semana**: debe verse **un solo** bloque `[REP26] Reunión interna AulaTec` el jueves 22 de 10:00 a 10:45.
2. Cambia a vista **Mes** (desplegable): debe verse **una sola** etiqueta ese día.
3. Si no la ves: en el panel izquierdo del Calendario comprueba que tu calendario está **marcado** (casilla de *Asistentes*) y que estás en la semana/mes correctos.

### Paso 3 · Dos eventos solapados y desplazar uno

1. Crea `[REP26] Revisión de material`: miércoles `21/10/2026`, `11:00`, **Duración** `00:30`, solo tú de asistente. Guardar.
2. Crea `[REP26] Preparar aula`: miércoles `21/10/2026`, `11:00`, **Duración** `00:30`. Guardar.
3. Vista **Semana** del 21/10: **observa el solapamiento** (los dos bloques ocupan el mismo hueco, uno al lado del otro).
4. **Desplaza el segundo** (`Preparar aula`): arrastra su bloque hacia abajo hasta las 12:00 **o** ábrelo y pon **Inicio = 21/10/2026 12:00** ➜ **Guardar**.

✅ Ya no coinciden: 11:00–11:30 y 12:00–12:30. Sigue siendo 30 minutos cada uno.

### Paso 4 · Reprogramar la reunión de 45 min

1. Abre `[REP26] Reunión interna AulaTec`.
2. Cambia la fecha de **Inicio** a `23/10/2026` manteniendo `10:00` (o arrastra el bloque al viernes).
3. **☁ Guardar**.

✅ Compruébalo: **Duración = 00:45** y fin = 10:45. En la vista Semana/Mes sigue habiendo **una sola** reunión (no se creó otra).

### Paso 5 · Actividad desde el CRM y ver si aparece en Calendario

1. ▦ ➜ **CRM** ➜ abre `[REP26] Centro Horizonte - 6 portátiles`.
2. Chatter ➜ **Actividad**:
   - **Tipo:** `Reunión` (*Meeting*)
   - **Resumen:** `Reunión de seguimiento portátiles`
   - **Fecha límite:** `27/10/2026`
3. Pulsa **Programar** (*Schedule*).
   ⚠️ **No** uses **Abrir calendario** (*Open Calendar*) a menos que quieras crear a propósito un evento enlazado (y ahí no añadas invitados).
4. Ve a ▦ ➜ **Calendario** ➜ semana/mes del `27/10/2026` y **mira si hay un evento** con ese resumen o con el nombre de la oportunidad.

✅ **Escribe lo que veas realmente.** Lo habitual en Odoo es que **Programar** solo crea la **actividad** (visible en el chatter y en la vista *Actividades* del CRM) y **no** un evento en Calendario; el evento solo se crea con **Abrir calendario**. **No des por hecho** que todo evento se enlaza automáticamente con el CRM: es justo lo que pide comprobar el enunciado.

✅ **Resultado esperado del E06:** una sola reunión interna de 45 min; dos eventos de 30 min ya no solapados.

---

## Ejercicio 7 · Caso integrador: encargo de Centro Cauce

**Apps:** Contactos → CRM → Ventas → Proyecto → Calendario (en este orden). Si un servicio no existe, créalo. **El presupuesto no se convierte en pedido.**

### Paso 1 · Empresa y responsable (Contactos)

1. ▦ ➜ **Contactos** ➜ **Nuevo** ➜ selector **Empresa**.
   - Nombre: `[REP26] Centro Cauce`
   - Correo: `centro.cauce.rep26@example.test`
   - **☁ Guardar**.
2. En esa misma ficha: pestaña **Contactos y direcciones** ➜ **Añadir**:
   - Nombre: `[REP26] Elena Ruiz`
   - Puesto de trabajo: `Responsable`
   - Correo: `elena.ruiz.rep26@example.test`
   - **Guardar y cerrar** ➜ **☁ Guardar** la empresa.

✅ Elena aparece dentro de Centro Cauce (vinculación real).

### Paso 2 · Oportunidad, actividad, nota y avance (CRM)

1. CRM ➜ **Nuevo**:
   - **Organización / Contacto:** `[REP26] Centro Cauce` (del desplegable)
   - **Oportunidad:** `[REP26] Centro Cauce - 6 puestos y formación`
   - **Ingreso esperado:** `490`
   - **Editar** ➜ **☁ Guardar**.
2. Chatter ➜ **Actividad**: Tipo `Por hacer` · **Resumen:** `Definir alcance` · Fecha límite `26/10/2026` ➜ **Programar**.
3. Chatter ➜ **Registrar nota** (nota **interna**): `Nota interna: alcance preliminar de 6 puestos informáticos y 2 horas de formación.` ➜ **Registrar**.
4. En la barra de etapas pulsa la siguiente etapa (**Calificado**). ⚠️ **No** pulses Ganado.

### Paso 3 · Servicio nuevo y presupuesto de 490 € (Ventas)

1. `Ventas ➜ Productos ➜ Productos` ➜ **Nuevo**:
   - Nombre: `[REP26] Preparación de puesto informático`
   - **Tipo de producto: Servicio** · **Precio de venta:** `70` ➜ **☁ Guardar**.
2. Vuelve al CRM ➜ abre `[REP26] Centro Cauce - 6 puestos y formación` ➜ **Nuevo presupuesto**.
3. **Líneas del pedido** ➜ **Añadir un producto**:
   - `[REP26] Preparación de puesto informático` ➜ Cantidad `6`
   - `[REP26] Formación individual` (la del E04, 35 €/hora) ➜ Cantidad `2`
4. **Importe sin impuestos = 490,00 €** (6 × 70 + 2 × 35).
5. **☁ Guardar**. Debe quedar en **Presupuesto** (borrador). ⚠️ No Confirmar.

### Paso 4 · Proyecto con 5 tareas (Proyecto)

1. ▦ ➜ **Proyecto** ➜ **Nuevo** ➜ nombre `[REP26] Centro Cauce - aula de formación` ➜ **Crear proyecto**.
2. Añade las columnas `Pendiente` y `En curso` (y `Finalizado` si quieres). Igual que en el E05: **no borres ni renombres** columnas por defecto si ya existen; déjalas vacías.
3. En la columna **Pendiente** pulsa **+** y crea 5 tareas:
   - `[REP26] Revisar puestos`
   - `[REP26] Preparar equipos`
   - `[REP26] Comprobar conectividad`
   - `[REP26] Formar usuarios`
   - `[REP26] Entregar informe`
4. **Fecha límite** en tres de ellas (abre la tarea ➜ campo **Fecha límite** ➜ **☁ Guardar**):
   - `Revisar puestos` ➜ `30/10/2026`
   - `Preparar equipos` ➜ `03/11/2026`
   - `Formar usuarios` ➜ `05/11/2026`
5. **Distribúyelas en 2 o más etapas:** arrastra `Revisar puestos` a **En curso**. Las otras 4 quedan en **Pendiente**.

✅ El proyecto tiene 5 tareas repartidas en 2 etapas, 3 con fecha.

### Paso 5 · Evento de calendario

1. ▦ ➜ **Calendario** ➜ nuevo evento (**Nuevo**, o clic en el hueco ➜ **Más opciones**).
   - **Asunto:** `[REP26] Coordinación Centro Cauce`
   - **Inicio:** `28/10/2026` `10:00` · **Duración:** `00:30`
   - **Asistentes:** solo tú (**sin invitados externos**).
2. **☁ Guardar**.

### Paso 6 · Coherencia entre aplicaciones: ¿enlace real o solo el nombre?

Recorre las apps y comprueba que el cliente "Centro Cauce" y el encargo se ven coherentes. Después clasifica:

| Relación | ¿Enlace real? | Cómo lo compruebas |
|---|---|---|
| Elena Ruiz ➜ Centro Cauce | ✅ **Real** (campo *Empresa* de la persona) | Ficha de Elena: campo de empresa; ficha de la empresa: pestaña *Contactos y direcciones*. |
| Oportunidad ➜ Centro Cauce | ✅ **Real** (campo *Cliente*) | Ficha de la oportunidad: campo **Cliente**. |
| Presupuesto ➜ Centro Cauce | ✅ **Real** (campo *Cliente* del presupuesto) | Ficha del presupuesto: campo **Cliente**. |
| Presupuesto ➜ Oportunidad | ✅ **Real** | En la oportunidad, el botón-contador **Presupuestos (1)**; en el presupuesto, el campo **Oportunidad** (pestaña *Otra información*). |
| Proyecto ➜ cliente/presupuesto/oportunidad | ❌ **Solo coincidencia de nombre** (lo creaste a mano con el mismo nombre) | En la ficha del proyecto el campo **Cliente** está vacío y el presupuesto no tiene botón de proyecto (no es un pedido confirmado). |
| Evento de Calendario ➜ cliente/oportunidad/presupuesto | ❌ **Solo coincidencia de nombre** | En el evento, el único asistente eres tú; no hay referencia a la oportunidad ni al presupuesto. |

> 💡 Si rellenaras a mano el campo **Cliente** del proyecto, sería un enlace real a la ficha de contacto, pero **no** al presupuesto ni a la oportunidad. En este ejercicio déjalo vacío para poder contestar correctamente.

✅ **Resultado esperado del E07:** 1 empresa + 1 persona + 1 oportunidad + 1 presupuesto (490 € en borrador) + 1 proyecto con 5 tareas + 1 evento. Ningún pedido.

---

## Ejercicio 8 · Auditoría de datos y revisión final

**Apps:** Contactos, CRM, Ventas (y mira Proyecto y Calendario). Ahora **revisas**; solo corriges si encuentras algo mal.

### Paso 1 · Teléfono de Oficina Río (sin duplicar)

1. Contactos ➜ busca `Oficina Río` ➜ debe salir **una sola** ficha.
2. Ábrela ➜ **Teléfono:** escribe `+34 600 000 000` (o corrige el que tenga) ➜ **☁ Guardar**.
3. Miga de pan **Contactos** ➜ busca otra vez `Oficina Río` ➜ **una sola ficha** ➜ ábrela ➜ el teléfono está guardado.

### Paso 2 · Exportar solo 3 empresas del E01

1. Contactos ➜ **Lista** (☰) ➜ busca `REP26` ➜ filtro **Empresas**.
2. Marca **solo**: `[REP26] Biblioteca Ronda`, `[REP26] Centro Horizonte`, `[REP26] Academia Mirador`. Arriba: **3 seleccionados**.
3. **⚙ Acciones** ➜ **Exportar** ➜ formato **CSV** ➜ campos **Nombre** y **Correo electrónico** únicamente ➜ **Exportar**.
4. Abre el CSV con el **Bloc de notas** y comprueba:
   - ✅ 1 línea de cabecera + **3 filas** de datos.
   - ✅ Sin símbolos raros (si algún nombre llevara tilde, se lee bien). En este export no hay "Río"; la prueba de tildes con `Río` es la del Ejercicio 2.
   - ✅ Ningún contacto repetido y ninguna persona (Laura, Sara, Mario) en el archivo.

### Paso 3 · Oportunidades y presupuestos coherentes

1. CRM ➜ abre `[REP26] Centro Horizonte - mantenimiento`:
   - **Cliente = `[REP26] Centro Horizonte`** ✅
   - Pulsa el botón-contador **Presupuestos (1)** ➜ en el presupuesto, **Importe sin impuestos = 330,00 €** ✅ y estado **Presupuesto** ✅.
2. CRM ➜ abre `[REP26] Centro Cauce - 6 puestos y formación`:
   - **Cliente = `[REP26] Centro Cauce`** ✅
   - **Presupuestos (1)** ➜ **Importe sin impuestos = 490,00 €** ✅ y estado **Presupuesto** ✅.

### Paso 4 · Proyecto y evento de Centro Cauce: ¿enlazados o solo el nombre?

1. Proyecto ➜ abre `[REP26] Centro Cauce - aula de formación` (menú **⋮** de la tarjeta ➜ **Configuración/Ajustes**): campo **Cliente** vacío ➜ **no** hay enlace con el presupuesto.
2. Calendario ➜ abre `[REP26] Coordinación Centro Cauce`: asistente = solo tú; sin referencia a oportunidad ni presupuesto ➜ **no** enlazado.
3. Presupuesto de Centro Cauce: no hay botón de proyecto ni de evento.

✅ **Conclusión que debes poder redactar:** *"Persona→empresa, oportunidad→cliente, presupuesto→cliente y presupuesto→oportunidad son enlaces reales (campos relacionales de Odoo). El proyecto y el evento de Calendario solo comparten el nombre de referencia, organizado manualmente."*

### Paso 5 · Al menos 6 comprobaciones (usa este guion)

Para cada una, busca `REP26`. Si algo no coincide, corrígelo **editando la ficha existente**. Si todo está bien, **no inventes incidencias**.

| # | Área | Dónde mirar | Qué debe verse |
|---|---|---|---|
| 1 | Contactos (empresas) | Contactos ➜ `REP26` ➜ filtro **Empresas** | **8 empresas** (4 del E01 + 3 del CSV + Centro Cauce), ninguna repetida |
| 2 | Contactos (personas) | Mismo ➜ filtro **Particulares** | **4 personas** (Laura, Sara, Mario, Elena), cada una con su empresa |
| 3 | Importaciones | Buscar `TecnoLuz`, `Editorial Alba`, `Oficina Río` | **Una ficha** de cada una (sin duplicados por importar) |
| 4 | CRM | CRM ➜ `REP26` ➜ lista | **5 oportunidades abiertas**: 3.600 · 900 · 240 · 160 · 490 €; clientes correctos; en *Calificado* solo `6 portátiles` y `Centro Cauce` |
| 5 | Ventas (presupuestos) | `Ventas ➜ Pedidos ➜ Presupuestos` ➜ cliente `REP26` | **3 presupuestos** en *Presupuesto*: 330 · 160 · 490 € sin impuestos |
| 6 | Ventas (ningún pedido) | `Ventas ➜ Pedidos ➜ Pedidos` ➜ `REP26` | **Vacío**: no hay presupuestos confirmados |
| 7 | Proyecto | Proyecto ➜ ambos proyectos | AulaTec: **6 tareas** (4 · 1 · 1); Centro Cauce: **5 tareas**; sin duplicados |
| 8 | Calendario | Calendario ➜ semanas del 21 al 28/10 | Reunión de 45 min (23/10), Revisión de material 11:00, Preparar aula 12:00, Coordinación Centro Cauce 28/10; sin duplicados y sin invitados externos |
| 9 | Servicios | `Ventas ➜ Productos ➜ Productos` ➜ `REP26` | **4 servicios** de tipo Servicio con los precios 45 · 30 · 35 · 70 |

💡 Para ver los **importes sin impuestos** en la lista de presupuestos: en la cabecera de la lista, icono **⋮/columnas opcionales** (a la derecha) ➜ marca **Importe sin impuestos**.

**Posibles incoherencias y arreglo rápido:**

| Si ves… | Arréglalo así |
|---|---|
| Una empresa duplicada | Marca la sobrante ➜ **⚙ Acciones** ➜ **Eliminar** (o **Archivar**) |
| Una persona sin empresa | Abre la persona ➜ rellena el campo de empresa eligiendo la existente ➜ **☁ Guardar** |
| Oportunidad con otro importe o sin cliente | Ábrela ➜ corrige **Ingreso esperado**/**Cliente** ➜ **☁ Guardar** |
| Presupuesto confirmado por error | Ábrelo ➜ **Cancelar** ➜ **Establecer como presupuesto** (*Set to Quotation*) |
| Dos tareas o eventos iguales | Marca la sobrante ➜ **⚙ Acciones** ➜ **Eliminar** (en eventos, ábrelo ➜ **⚙** ➜ **Eliminar**) |

---

## Checklist final

Pasa por esta lista antes de dar por terminado el repaso (incluye la "Revisión final" del PDF).

**Revisión final del PDF**

- [ ] ¿El código `[REP26]` aparece en **todos** los registros nuevos? (búsqueda `REP26` en cada app)
- [ ] ¿Los contactos importados se han **exportado de nuevo desde Odoo**, sin tocar a mano el CSV resultante?
- [ ] ¿Las oportunidades muestran **cliente, etapa, ingreso esperado y actividades** correctos?
- [ ] ¿Los presupuestos mantienen **cantidades, subtotales (330 / 160 / 490) y estado sin confirmar**?
- [ ] ¿Se han guardado **tableros, eventos y cambios** (reabre y comprueba)?
- [ ] ¿Los CSV se importaron/exportaron con **acentos legibles** (`Río`)?

**Estado esperado de la base al terminar**

| Concepto | Cantidad |
|---|---|
| Empresas `REP26` | 8 (4 + 3 CSV + Centro Cauce) |
| Personas `REP26` | 4 (Laura, Sara, Mario, Elena) |
| Oportunidades abiertas | 5 (3.600 · 900 · 240 · 160 · 490 €) |
| Presupuestos en borrador | 3 (330 · 160 · 490 €) |
| Pedidos confirmados | **0** |
| Servicios | 4 |
| Proyectos | 2 (6 tareas y 5 tareas) |
| Eventos de calendario | 4 (+1 solo si creaste uno con *Abrir calendario*) |

**Ejercicio por ejercicio**

- [ ] **E01:** 4 empresas + 3 personas vinculadas; teléfono de Centro Horizonte = `958 000 002`.
- [ ] **E02:** CSV con 3 empresas importadas una sola vez; CSV defectuoso **probado pero no importado**; CSV exportado = 1 cabecera + 3 filas.
- [ ] **E03:** 3 oportunidades abiertas (3.600 / 900 / 240); solo una avanzó de etapa; llamada hecha y seguimiento pendiente.
- [ ] **E04:** presupuestos de 330 € y 160 €; ingreso esperado de mantenimiento sigue en 240 €.
- [ ] **E05:** 6 tareas; 4 Pendiente · 1 En curso · 1 Finalizado; `Actualizar navegadores` con fecha `09/11/2026` y nota.
- [ ] **E06:** una sola reunión de 45 min; eventos de 30 min sin solapamiento; observado si la actividad del CRM crea evento.
- [ ] **E07:** empresa, persona, oportunidad (490), presupuesto (490, borrador), proyecto (5 tareas), evento; enlaces reales vs nombre identificados.
- [ ] **E08:** Oficina Río con teléfono; export de 3 filas; ≥ 6 comprobaciones; sin duplicados ni presupuestos confirmados.

---

## Problemas frecuentes y cómo arreglarlos

| Problema | Causa probable | Solución |
|---|---|---|
| **No aparece el botón "Nuevo presupuesto" en la oportunidad** | Falta una de las apps, o la oportunidad está ganada/perdida | Instala **CRM y Ventas** (▦ ➜ Aplicaciones). La oportunidad debe estar **abierta**. Recarga con **F5**. |
| **No encuentro "Importar registros"** | Está en el engranaje de la miga de pan | En **Contactos** pulsa el **⚙ junto al título** de la vista. Prueba en vista **Lista (☰)**. |
| **Los acentos salen raros (`RÃ­o`)** | El CSV no está en UTF-8 | Reabre el archivo en el Bloc de notas ➜ **Guardar como** ➜ **Codificación UTF-8**. En el asistente de importación comprueba **Codificación = UTF-8**. |
| **Una columna no se mapea sola** | El nombre de columna no coincide con ningún campo | En el asistente, pulsa el desplegable de esa columna y elige el campo a mano (`Nombre`, `Correo electrónico`, `Es una empresa`). |
| **Todo sale en una sola columna** | Separador equivocado (`;` vs `,`) | En las opciones de formato cambia **Separador** (Coma / Punto y coma) y vuelve a pulsar **Probar**. |
| **Importé dos veces** | Pulsé **Importar** más de una vez | Marca las fichas repetidas ➜ **⚙ Acciones** ➜ **Eliminar** (o **Archivar**). |
| **Se creó un contacto duplicado desde un desplegable** | Elegí **Crear "…"** | Elimina el duplicado y en la ficha correspondiente elige el registro existente. |
| **Cliente de la oportunidad incorrecto** | Elegí la persona en lugar de la empresa | En la oportunidad, campo **Cliente** ➜ elige `[REP26] <Empresa>`. |
| **Marqué Ganada/Perdida por error** | Pulsé el botón | **Ganada:** pulsa otra etapa en la barra para reabrirla. **Perdida:** filtra por **Perdidas**, ábrela y pulsa **Restaurar**. |
| **Confirmé un presupuesto** | Pulsé **Confirmar** | Ábrelo ➜ **Cancelar** ➜ **Establecer como presupuesto**. |
| **No veo mis registros al buscar** | Hay un filtro por defecto (*Mi pipeline*, *Mis tareas*…) | Quita las pastillas de filtro con su **✕** y vuelve a buscar `REP26`. |
| **El proyecto ya trae columnas** | Odoo crea etapas por defecto | No las borres/renombres; añade tus 3 columnas y deja las otras vacías. |
| **No sé qué columna es `Pendiente`** | Hay más columnas de las esperadas | Mira el **título** de cada columna; crea las tareas con el **+** de la cabecera correcta. |
| **El evento "desaparece" del Calendario** | Estás en otra semana/mes o tu calendario está desmarcado | Pulsa **Hoy**, navega a la semana correcta y marca tu casilla en el panel izquierdo. |
| **Odoo intenta enviar invitaciones** | Añadiste asistentes externos | Quita a todos menos a ti y guarda. |
| **Sale un desplegable con empresas reales al escribir un nombre** | Autocompletado de empresas | Ignóralo: no selecciones nada. |
| **No aparece el botón ☁ Guardar** | No hay cambios pendientes o ya se guardó | Es normal; si has escrito algo y no sale, haz clic fuera del campo y comprueba. |
| **Mi Odoo está en inglés/español y los nombres no coinciden** | Idioma distinto al de esta guía | Usa el texto entre paréntesis o cambia el idioma: avatar (arriba a la derecha) ➜ **Preferencias** ➜ **Idioma**. |

💡 **Ver nombres técnicos de campos (opcional):** activa el modo desarrollador abriendo `http://localhost:8069/odoo?debug=1`. Al pasar el ratón por el nombre de un campo verás su nombre técnico (por ejemplo `is_company`).

---

*Fin de la guía. Datos 100 % ficticios · prefijo `[REP26]` en todos los registros nuevos.*
