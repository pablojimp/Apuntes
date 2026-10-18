# Chuletario de Python — Examen SGE

*Hecho con tus ejercicios de las relaciones 01, 02, 05, 06, 07, 08, 09, 10 y 11 (las relaciones 03 y 04 no venían en el archivo). Cada apartado indica de qué relación sale el patrón.*

## 0. Reglas de oro

- Una función hace **una** cosa y devuelve el resultado con `return` (no con `print`).
- Si piden «imprimir solo desde main()», las funciones devuelven datos o listas de líneas y `main()` hace los `print`.
- Todo lo que sale de `input()` es **texto**: conviértelo con `int()` o `float()` y valida.
- Texto: `.strip()` quita espacios; `.lower()` o `.casefold()` ignoran mayúsculas.
- Dinero siempre con 2 decimales: `{valor:.2f}`.
- `=` asigna, `==` compara. Los bloques llevan `:` y sangría de 4 espacios.

## 1. Variables y tipos (R1)

```python
empresa = 'AulaTec'   # str (texto)
empleados = 7         # int (entero)
precio = 25.50        # float (decimal, con punto)
activa = True         # bool (True / False)
nada = None           # sin valor

print(type(precio))   # <class 'float'>
int('5')   float('2.5')   str(10)   # conversiones
```

## 2. Operadores y fórmulas típicas (R1)

| Operador | Qué hace |
|---|---|
| `+ - * /` | suma, resta, producto, división (siempre da float) |
| `//` | división entera (7 // 2 = 3) |
| `%` | resto (7 % 2 = 1) |
| `**` | potencia (2 ** 3 = 8) |
| `+= -= *=` | abreviados: `x += 1` es `x = x + 1` |
| `== != < <= > >=` | comparación |
| `and or not` | lógicos |

Fórmulas que se repiten en todas las relaciones:

```python
subtotal = precio * cantidad
descuento = subtotal * porcentaje / 100
total = subtotal - descuento
stock_final = stock_inicial + recibidas - vendidas
gasto_total = materiales + otros_gastos
resultado = ingresos - gasto_total
media = total / cantidad
```

## 3. Entrada de datos (R2)

```python
nombre = input('Nombre: ')                         # str
precio = float(input('Precio: '))                  # float
cantidad = int(input('Cantidad: '))                # int
premium = input('Cliente premium (S/N): ').strip().upper()
```

Si el usuario escribe letras donde va un número, salta `ValueError` (ver apartado 12).

## 4. Salida con f-strings (R1, R2)

```python
print(f'Cliente: {cliente}')
print(f'Total: {total:.2f} EUR')                 # 2 decimales
print(f'Descuento: {porcentaje}%')
print(f'PED-{numero:03d}')                        # PED-001, PED-012
print(f'{cantidad} x {precio:.2f} = {subtotal:.2f} EUR')
print('Línea 1\nLínea 2')                         # \n = salto de línea
```

## 5. Condicionales (R5)

**if / elif / else** (de lo más restrictivo a lo menos):

```python
if stock < 0:
    print('Error: stock negativo')
elif stock == 0:
    print('Agotado')
elif stock <= 5:
    print('Stock bajo')
else:
    print('Stock suficiente')
```

**Tramos de descuento** (R5E2):

```python
if cantidad < 5:
    porcentaje = 0
elif cantidad <= 9:
    porcentaje = 5
else:
    porcentaje = 10
```

**Operadores lógicos con paréntesis** (R5E3):

```python
if total > 500 or (premium == 'S' and total > 250):
    print('Prioritario')
else:
    print('Normal')
```

**If anidado + opción no válida** (R5E4):

```python
destino = input('Destino: ').strip().upper()
if destino == 'PENINSULA':
    if total >= 100:
        envio = 0
    else:
        envio = 6
elif destino == 'BALEARES':
    envio = 12
elif destino == 'CANARIAS':
    envio = 18
else:
    print('Destino no válido')
```

**Máximo y empates** (R5E5):

```python
maximo = max(tienda, web, telefono)
empates = 0
if tienda == maximo:
    empates += 1
if web == maximo:
    empates += 1
if telefono == maximo:
    empates += 1

if empates > 1:
    print('Empate')
elif tienda == maximo:
    print('Tienda')
```

## 6. Bucles (R6)

```python
range(5)            # 0,1,2,3,4
range(1, 8)         # 1..7  (el final NO entra)
range(1, n + 1)     # 1..n
range(0, 10, 2)     # 0,2,4,6,8
```

**for + acumulador + media** (R6E2):

```python
total = 0
for dia in range(1, 8):
    venta = float(input(f'Ventas del día {dia}: '))
    total += venta
media = total / 7
```

**Códigos con ceros** (R6E1): crear lista y unir con saltos de línea:

```python
codigos = []
for numero in range(1, cantidad + 1):
    codigos.append(f'PED-{numero:03d}')
print('\n'.join(codigos))
```

**while con centinela (el 0 corta)** y contador (R6E3):

```python
importe = float(input('Importe: '))
total = 0
contador = 0
while importe != 0:
    total += importe
    contador += 1
    importe = float(input('Importe: '))   # ¡volver a pedir dentro del bucle!
```

**Menú con while** (R6E4):

```python
opcion = -1
while opcion != 0:
    print('1) Alta\n2) Consulta\n0) Salir')
    opcion = int(input('Opción: '))
    if opcion == 1:
        print('Alta')
    elif opcion == 2:
        print('Consulta')
    elif opcion != 0:
        print('Opción no válida')
```

**Bucles anidados** (R6E5): el de dentro se repite entero por cada vuelta del de fuera:

```python
for producto in range(1, productos + 1):
    for mes in range(1, meses + 1):
        print(f'Producto {producto} - Mes {mes}')
```

Extra: `break` sale del bucle; `continue` salta a la siguiente vuelta.

## 7. Listas (R7)

```python
productos = ['Teclado', 'Ratón', 'Monitor']
productos.append('Webcam')        # añade al final
productos.insert(0, 'Cable')      # añade en una posición
productos.remove('Ratón')         # quita por valor
ultimo = productos.pop()          # quita y devuelve el último
productos.sort()                  # ordena la propia lista
ordenada = sorted(productos, reverse=True)   # copia ordenada

len(productos)   productos[0]   productos[-1]   productos[1:3]
'Monitor' in productos            # True / False
```

**Recorrer numerando** (R7E1):

```python
for numero, producto in enumerate(productos, start=1):
    print(f'{numero}. {producto}')
```

**Estadísticas de una lista de números** (R7E2):

```python
precios = [12.50, 25.00, 8.75]
cantidad = len(precios)
total = sum(precios)
minimo = min(precios)
maximo = max(precios)
media = total / cantidad      # cuidado: si la lista está vacía, división por 0
```

**Filtrar con comprensión de listas** (muy usada en R11):

```python
baratos = [p for p in precios if p < 20]
encontrados = [p for p in productos if texto in p['nombre'].casefold()]
```

## 8. Diccionarios (R7)

```python
cliente = {'nombre': 'Ana', 'ciudad': 'Granada', 'activo': True}

cliente['ciudad'] = 'Sevilla'        # modificar
cliente['telefono'] = '600000000'    # añadir clave nueva
cliente['nombre']                    # leer (KeyError si no existe)
cliente.get('email')                 # leer (None si no existe)
'nombre' in cliente                  # ¿existe la clave?
del cliente['activo']                # borrar

for clave, valor in cliente.items():
    print(clave, valor)
cliente.keys()   cliente.values()

anterior = cliente.copy()            # copia real (con = solo compartes)
```

**Lista de diccionarios** (R7E4):

```python
productos = [
    {'nombre': 'Teclado', 'precio': 25.50, 'stock': 4},
    {'nombre': 'Ratón', 'precio': 15.00, 'stock': 0},
]
disponibles = 0
for producto in productos:
    if producto['stock'] > 0:
        print(producto['nombre'])
        disponibles += 1

valor_total = sum(p['precio'] * p['stock'] for p in productos)
```

## 9. Sets y tuplas (R7)

```python
categorias = ['Periféricos', 'Pantallas', 'Periféricos']
unicas = set(categorias)         # sin repetidos y sin orden
unicas.add('Audio')   unicas.discard('Audio')
a | b    a & b    a - b          # unión, intersección, diferencia

punto = (3, 4)                   # tupla: no se puede modificar
x, y = punto                     # desempaquetar
```

## 10. Cadenas (R7)

```python
texto.strip()     texto.lower()     texto.upper()     texto.title()
texto.replace('a', 'b')
texto.split(';')                 # 'Ana;Granada' -> ['Ana', 'Granada']
';'.join(['Ana', 'Granada'])      # -> 'Ana;Granada'
'\n'.join(lineas)                  # lista de líneas -> un solo texto
texto.startswith('PED')   texto.endswith('.csv')
len(texto)   texto[0]   texto[-1]   texto[:3]
```

**Búsqueda sin distinguir mayúsculas** (R7E5): pasa a minúsculas los dos lados.

```python
texto = input('Texto de búsqueda: ').strip().lower()
coincidencias = []
for producto in productos:
    if texto in producto.lower():
        coincidencias.append(producto)
```

## 11. Funciones (R8)

```python
def calcular_subtotal(precio, cantidad):
    return precio * cantidad

def clasificar_stock(stock):
    if stock == 0:
        return 'Agotado'
    elif stock <= 5:
        return 'Stock bajo'
    else:
        return 'Stock suficiente'

# Valor por defecto (siempre al final de los parámetros)
def aplicar_descuento(importe, porcentaje=0):
    return importe - importe * porcentaje / 100

aplicar_descuento(100)                  # 100.0
aplicar_descuento(100, porcentaje=10)   # 90.0
```

**Devolver un diccionario o None** (R8E4):

```python
def resumir_importes(importes):
    if len(importes) == 0:
        return None
    total = sum(importes)
    return {'total': total, 'media': total / len(importes),
            'minimo': min(importes), 'maximo': max(importes)}

resumen = resumir_importes([10, 20, 30])
if resumen is not None:
    print(resumen)
```

**Devolver varios valores** (R8E5):

```python
def pedir_datos():
    cliente = input('Cliente: ')
    precio = float(input('Precio: '))
    return cliente, precio          # devuelve una tupla

cliente, precio = pedir_datos()
```

**Descomponer un programa** (R8E5): `pedir_datos()` → `calcular_total()` → `mostrar_resumen()` → `main()`, y al final `main()`.

Recuerda: sin `return` la función devuelve `None`; las variables de dentro son locales.

## 12. Excepciones (R9)

```python
try:
    precio = float(input('Precio: '))
except ValueError:
    print('Debes introducir un número válido (usa el punto decimal).')
```

**Pedir hasta que sea válido** (R9E1):

```python
precio = -1
while precio < 0:
    try:
        precio = float(input('Precio (>= 0): '))
        if precio < 0:
            print('No puede ser negativo.')
    except ValueError:
        print('Número no válido.')
        precio = -1          # para que el while siga
```

**Función reutilizable `leer_entero`** (R9E2):

```python
def leer_entero(mensaje, minimo, maximo):
    numero = minimo - 1
    while numero < minimo or numero > maximo:
        try:
            numero = int(input(mensaje))
            if numero < minimo or numero > maximo:
                print(f'Introduce un número entre {minimo} y {maximo}.')
        except ValueError:
            print('Debes introducir un número entero.')
            numero = minimo - 1
    return numero
```

**Variante que devuelve None en vez de pedir** (R11):

```python
def convertir_entero(texto, minimo=0):
    try:
        numero = int(texto)
    except ValueError:
        return None
    return numero if numero >= minimo else None

stock = None
while stock is None:
    stock = convertir_entero(input('Stock: '))
    if stock is None:
        print('Introduce un stock entero no negativo.')
```

Extra: `except (ValueError, ZeroDivisionError):`, `except FileNotFoundError:`, bloque `finally:` (se ejecuta siempre) y `raise ValueError('mensaje')` para lanzar tú el error.

## 13. Ficheros: txt y CSV (R9)

Modos de `open`: `'r'` leer, `'w'` escribir (**borra lo anterior**), `'a'` añadir al final. Usa siempre `with` (cierra solo) y `encoding='utf-8'`.

```python
from pathlib import Path

ruta = Path(__file__).with_name('clientes.txt')   # junto al .py
ruta.exists()                                      # ¿existe el fichero?
```

**Texto plano** (R9E3):

```python
with open(ruta, 'w', encoding='utf-8') as archivo:
    for cliente in clientes:                  # cada cliente = 'Ana;Granada'
        archivo.write(cliente + '\n')

with open(ruta, 'r', encoding='utf-8') as archivo:
    for linea in archivo:
        print(linea.rstrip('\n'))              # quita el salto de línea
```

**CSV con diccionarios** (R9E4, R11): `newline=''` es obligatorio al escribir.

```python
import csv

CAMPOS = ['nombre', 'precio', 'stock']

with open(ruta, 'w', newline='', encoding='utf-8') as archivo:
    escritor = csv.DictWriter(archivo, fieldnames=CAMPOS)
    escritor.writeheader()                    # primera fila con los nombres
    escritor.writerows(productos)             # lista de dicts

with open(ruta, 'r', newline='', encoding='utf-8') as archivo:
    lector = csv.DictReader(archivo)
    for fila in lector:
        print(f"{fila['nombre']}: {fila['precio']} EUR")
```

**Al leer un CSV todo llega como texto.** Hay que convertir (R11E2):

```python
clientes.append({
    'nombre': fila['nombre'],
    'precio': float(fila['precio']),
    'stock': int(fila['stock']),
    'activo': fila['activo'].strip().lower() == 'true',   # texto -> bool
})
```

Patrón de «cargar si existe»: `if RUTA_CSV.exists():` antes de abrir; si no, devuelve lista vacía.

## 14. Módulos (R9E5)

```python
# calculos.py
def calcular_subtotal(precio, cantidad):
    return precio * cantidad

def aplicar_descuento(importe, porcentaje):
    return importe - importe * porcentaje / 100
```

```python
# main.py (en la misma carpeta)
from calculos import calcular_subtotal, aplicar_descuento

def main():
    subtotal = calcular_subtotal(10, 3)
    print(aplicar_descuento(subtotal, 5))

if __name__ == '__main__':      # solo ejecuta main() si lanzas ESTE fichero
    main()
```

Otras formas: `import calculos` (se usa `calculos.calcular_subtotal(...)`) y `import calculos as c`. Se importa por el nombre del fichero **sin** `.py`.

## 15. Programación orientada a objetos (R10)

**Clase con constructor y métodos** (R10E1, R10E2):

```python
class Producto:
    def __init__(self, nombre, precio, stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock

    def vender(self, cantidad):
        if cantidad <= 0 or cantidad > self.stock:
            return False
        self.stock -= cantidad
        return True

    def reponer(self, cantidad):
        if cantidad > 0:
            self.stock += cantidad

    def mostrar(self):
        print(f'{self.nombre} | {self.precio:.2f} EUR | Stock: {self.stock}')

producto = Producto('Ratón', 12.50, 5)    # crear objeto
producto.vender(2)                         # llamar método
print(producto.stock)                      # leer atributo
```

**Método que devuelve texto** (R10E3):

```python
    def ficha(self):
        return f'{self.nombre} | {self.email} | {self.ciudad}'
```

**Herencia** (R10E4): la hija reutiliza el constructor del padre con `super().__init__`:

```python
class Empleado:
    def __init__(self, nombre, salario):
        self.nombre = nombre
        self.salario = salario

class Comercial(Empleado):
    def __init__(self, nombre, salario, ventas):
        super().__init__(nombre, salario)
        self.ventas = ventas

    def calcular_bonus(self):
        return self.ventas * 0.05
```

**Composición: un objeto que contiene otros** (R10E5, R11E3):

```python
class LineaPedido:
    def __init__(self, producto, cantidad):
        self.producto = producto           # es un objeto Producto
        self.cantidad = cantidad

    def subtotal(self):
        return self.producto.precio * self.cantidad

class Pedido:
    def __init__(self, cliente):
        self.cliente = cliente
        self.lineas = []                   # lista de LineaPedido

    def agregar_linea(self, producto, cantidad):
        if not producto.vender(cantidad):  # descuenta stock y avisa si no hay
            return False
        self.lineas.append(LineaPedido(producto, cantidad))
        return True

    def total(self):
        return sum(linea.subtotal() for linea in self.lineas)
```

Clases en otro fichero: `from modelos import Producto, Pedido`.

Extra: `__str__(self)` devuelve el texto que sale con `print(objeto)`.

## 16. Plantilla de proyecto integrador (R11)

Estructura que repiten los tres proyectos: constantes arriba, funciones de lógica (sin `print`), y `main()` con el menú y todos los `print`.

```python
import csv
from pathlib import Path

RUTA_CSV = Path(__file__).with_name('inventario.csv')
CAMPOS = ['nombre', 'precio', 'stock']

def encontrar_producto(productos, nombre):
    for producto in productos:
        if producto['nombre'].casefold() == nombre.casefold():
            return producto
    return None

def anadir_producto(productos, nombre, precio, stock):
    if not nombre:
        return 'nombre_vacio'
    if encontrar_producto(productos, nombre) is not None:
        return 'duplicado'
    productos.append({'nombre': nombre, 'precio': precio, 'stock': stock})
    return 'anadido'

def modificar_stock(productos, nombre, nuevo_stock):
    producto = encontrar_producto(productos, nombre)
    if producto is None:
        return False
    producto['stock'] = nuevo_stock
    return True

def buscar_productos(productos, texto):
    busqueda = texto.casefold()
    return [p for p in productos if busqueda in p['nombre'].casefold()]

def formatear_producto(numero, producto):
    return f"{numero}. {producto['nombre']} | {producto['precio']:.2f} EUR | Stock: {producto['stock']}"

def guardar_csv(productos):
    with open(RUTA_CSV, 'w', newline='', encoding='utf-8') as archivo:
        escritor = csv.DictWriter(archivo, fieldnames=CAMPOS)
        escritor.writeheader()
        escritor.writerows(productos)
    return len(productos)

def main():
    productos = []
    opcion = ''
    while opcion != '0':
        print('\n1) Listar\n2) Añadir\n3) Modificar stock\n4) Buscar\n5) Guardar\n0) Salir')
        opcion = input('Opción: ').strip()

        if opcion == '1':
            if not productos:
                print('No hay productos.')
            for numero, producto in enumerate(productos, start=1):
                print(formatear_producto(numero, producto))
        elif opcion == '5':
            print(f'Guardados {guardar_csv(productos)} productos.')
        elif opcion != '0':
            print('Opción no válida.')

if __name__ == '__main__':
    main()
```

**Ideas clave del patrón:**

- Las funciones devuelven **códigos de resultado** (`'anadido'`, `'duplicado'`, `'faltan_datos'`) o `True/False`; `main()` decide el mensaje.
- «Buscar un elemento» = recorrer y devolver el elemento o `None`; se comprueba con `is None` / `is not None`.
- Comprobar duplicados sin distinguir mayúsculas: `.casefold()` en los dos lados. Con `any(...)` si es una condición sobre toda la lista: `any(c['email'].casefold() == email.casefold() for c in clientes)`.
- «Desactivar» un registro = cambiar `activo` a `False`, no borrarlo.
- Lista vacía → mostrar «No hay …» con `if not lista:`.
- Guardar y cargar CSV como funciones aparte; al cargar, convertir tipos.

## 17. Errores típicos y cómo arreglarlos

| Error / síntoma | Causa habitual | Solución |
|---|---|---|
| `TypeError` al sumar texto y número | `input()` sin convertir | `int()` / `float()` o usar f-string |
| `ValueError: invalid literal for int()` | letras, o un decimal metido en `int()` | `try/except ValueError`; usar `float` para decimales |
| `NameError` | variable mal escrita o no definida aún | revisar el nombre y el orden |
| `IndentationError` | sangría mezclada | 4 espacios en todo el bloque |
| `IndexError` | posición fuera de la lista | comprobar `len()` o recorrer con `for` |
| `KeyError` | clave inexistente en el dict | `.get('clave')` o `'clave' in dic` |
| `ZeroDivisionError` | media de lista vacía | `if len(lista) == 0:` antes de dividir |
| `FileNotFoundError` | ruta incorrecta | `Path(__file__).with_name(...)` y `.exists()` |
| El bucle no acaba | olvidaste volver a pedir/actualizar la variable | revisar la condición del `while` |
| Faltaba el último número | `range(1, n)` no incluye `n` | `range(1, n + 1)` |
| Cambias una copia y se altera el original | `copia = original` | `original.copy()` |
| La función devuelve `None` | falta `return` | añadir `return` |
| `AttributeError` en una clase | olvidaste `self.` | `self.atributo` dentro de los métodos |
| Se perdió el contenido del fichero | abriste con `'w'` | usar `'a'` para añadir |

## 18. Repaso de última hora

1. Lee el enunciado y subraya **entradas**, **cálculos** y **salida exacta** (formato, decimales, textos).
2. Escribe primero el esqueleto: `input` → conversión → cálculo → `print`.
3. Si hay decisiones, ordena los `if/elif` de lo más específico a lo más general.
4. Si hay repetición: ¿sé cuántas veces? → `for`. ¿Depende de una condición? → `while`.
5. Si se repite código, hazlo función. Si hay datos con varios campos, usa dict; si además tienen comportamiento, usa clase.
6. Prueba con un caso normal, uno límite (0, vacío, negativo) y uno erróneo (letras).
