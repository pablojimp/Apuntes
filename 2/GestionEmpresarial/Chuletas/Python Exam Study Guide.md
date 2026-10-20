# Python Exam Study Guide: the 4 Projects

**Short answer to your question: yes, the 4 exercises are the same exercise in different clothes.** If you learn one skeleton, you can write any of them (and any new one the teacher invents).

---

## 1. What all 4 projects have in common

| Piece | Always the same |
|---|---|
| **Files** | `main.py` (menu + `print`/`input`), `modelos.py` (classes), `persistencia.py` (CSV) |
| **Entry point** | `if __name__ == "__main__": main()` |
| **Storage in memory** | A **dict keyed by a unique code/email** (`self.productos[codigo]`) or a list |
| **Manager class** | One class that owns the dict and has the business methods (`Floristeria`, `Coleccion`, `CentroTalleres`, `ServicioTecnico`) |
| **Validation** | Reject empty, duplicate, negative, unknown. Return `(False, "message")` |
| **Return style** | Methods **return** `(ok, message)` or data. They never print |
| **Menu** | `while opcion != 0:` with an explicit condition (never `while True` + `break`) |
| **Input errors** | `try/except ValueError` around `int()` / `float()` |
| **CSV** | `csv` module, `with open(..., encoding="utf-8", newline="")`, header row, load at start, save on a menu option |
| **Loading safely** | Skip bad rows with `try/except`, and reuse the same validation methods |
| **Extra** | One "voluntary extension" (sort/top3/ranking/cancel/edit) |

### What changes in each one

| Project | Special idea the teacher is testing |
|---|---|
| 01 Floristería | **Stock changes**: valid line reduces stock once; invalid line changes nothing. **Discount on total** (≥ 50 € → 10 %). Nested objects (Venta → LineaVenta → Producto). CSV with **one row per line** |
| 02 Cartas | **Atomic operation** (exchange: validate everything first, then change). Search case-insensitive. Aggregates (total value, count per rarity) |
| 03 Talleres | **Relations by key** (email, code), capacity limit, no duplicate enrolments. Percentage of occupation. Three CSVs. Load must not create orphan enrolments |
| 04 Servicio técnico | **Inheritance + polymorphism** (`calcular_importe()` differs). **State machine** (pendiente → en curso → finalizado, no skipping/going back). CSV `tipo` column to rebuild the right subclass |

---

## 2. The golden rules (the teacher checks these)

1. **No `print()` or `input()` inside classes, methods or helper functions.** Only inside `main()` (and small UI functions called from main, which is how I wrote it; if he is strict, put everything in `main()`).
2. Menu loop with an **explicit condition**: `while opcion != 0:`. No `while True: ... break`.
3. `try/except ValueError` when converting input.
4. **No negative quantities, no repeated keys, no half-done operations.**
5. Methods **return** data / `bool` / tuple / string.
6. CSV: `csv` module, `with open(...)`, `encoding="utf-8"`, `newline=""`.
7. No pandas, no database, no APIs.
8. At least `main.py` + `modelos.py`.

---

## 3. The skeleton to memorize (works for all 4)

### 3.1 `modelos.py`

```python
class Entidad:                                   # e.g. Producto / Carta / Taller
    def __init__(self, codigo, nombre, precio, stock):
        self.codigo = codigo
        self.nombre = nombre
        self.precio = precio
        self.stock = stock

    def __str__(self):                           # returns text, does NOT print
        return f"{self.codigo} {self.nombre} {self.precio:.2f} €"


class Gestor:                                    # manager class
    def __init__(self):
        self.items = {}                          # dict keyed by code

    def alta(self, codigo, nombre, precio, stock):
        codigo = codigo.strip().upper()
        if not codigo:
            return False, "Empty code."
        if codigo in self.items:
            return False, "Duplicate code."
        if precio < 0 or stock < 0:
            return False, "Negative value."
        self.items[codigo] = Entidad(codigo, nombre, precio, stock)
        return True, "Added."

    def eliminar(self, codigo):
        if self.items.pop(codigo.strip().upper(), None) is None:
            return False, "Not found."
        return True, "Deleted."

    def buscar(self, texto):
        t = texto.strip().lower()
        return [x for x in self.items.values() if t in x.nombre.lower()]
```

### 3.2 `persistencia.py`

```python
import csv
from pathlib import Path

def cargar(ruta):
    gestor = Gestor()
    ruta = Path(ruta)
    if not ruta.exists():
        return gestor                       # or return default data
    with open(ruta, newline="", encoding="utf-8") as f:
        for fila in csv.DictReader(f):
            try:
                gestor.alta(fila["codigo"], fila["nombre"],
                            float(fila["precio"]), int(fila["stock"]))
            except (ValueError, KeyError):
                continue                    # skip bad rows
    return gestor

def guardar(ruta, gestor):
    with open(ruta, "w", newline="", encoding="utf-8") as f:
        w = csv.writer(f)
        w.writerow(["codigo", "nombre", "precio", "stock"])   # header
        for x in gestor.items.values():
            w.writerow([x.codigo, x.nombre, x.precio, x.stock])
```

### 3.3 `main.py`

```python
def pedir_numero(texto, tipo):
    try:
        return tipo(input(texto).strip().replace(",", "."))
    except ValueError:
        print("Invalid number.")
        return None

def main():
    gestor = cargar("datos.csv")
    opcion = -1
    while opcion != 0:                       # explicit condition
        print("1) List  2) Add  3) Search  7) Save  0) Exit")
        opcion = pedir_numero("Option: ", int)
        if opcion is None:
            opcion = -1
        elif opcion == 1:
            for x in gestor.items.values():
                print(x)
        elif opcion == 2:
            precio = pedir_numero("Price: ", float)
            stock = pedir_numero("Stock: ", int)
            if precio is not None and stock is not None:
                print(gestor.alta(input("Code: "), input("Name: "), precio, stock)[1])
        elif opcion == 7:
            guardar("datos.csv", gestor)
        elif opcion != 0:
            print("Invalid option.")

if __name__ == "__main__":
    main()
```

> Note `print(gestor.alta(...)[1])`: the class returns `(ok, message)` and **main** prints the message.

---

## 4. Project by project: classes and methods

### Project 01: Floristería Lila

| Class | Attributes | Methods |
|---|---|---|
| `Producto` | codigo, nombre, categoria, precio, stock | `__str__` |
| `LineaVenta` | producto, cantidad, precio_unitario | `subtotal()` |
| `Venta` | numero, cliente, lineas (list) | `agregar_linea()`, `subtotal()`, `descuento()`, `total()`, `detalle()` |
| `Floristeria` (manager) | productos (dict), ventas_cerradas (list), venta_actual | `alta_producto`, `reponer`, `siguiente_numero`, `nueva_venta`, `agregar_linea`, `cerrar_venta`, `cancelar_venta`, `importe_acumulado` |

**Key logic: stock only changes after ALL validations pass, and only once**

```python
def agregar_linea(self, codigo, cantidad):
    producto = self.productos.get(codigo.strip().upper())
    if self.venta_actual is None:   return False, "No open sale."
    if producto is None:            return False, "Unknown product."
    if cantidad <= 0:               return False, "Quantity must be > 0."
    if cantidad > producto.stock:   return False, "Not enough stock."
    producto.stock -= cantidad                  # only here
    self.venta_actual.agregar_linea(producto, cantidad)
    return True, "Line added."
```

**Discount on the total (not per line):**

```python
def descuento(self):
    sub = self.subtotal()
    return round(sub * 0.10, 2) if sub >= 50 else 0.0

def total(self):
    return round(self.subtotal() - self.descuento(), 2)
```

Tests: 3 orchids = 54 € subtotal → total **48.60 €**. 2 orchids + 4 tulips = **45 €**, no discount.

**Cancel sale (extension):** loop the lines and give stock back: `linea.producto.stock += linea.cantidad`.

**CSV for sales:** one row per line → columns `numero,cliente,codigo_producto,cantidad,precio_unitario`. On load, group rows by `numero` using a dict `{numero: Venta}`.

### Project 02: Cartas Pokémon

| Class | Attributes | Methods |
|---|---|---|
| `Carta` | codigo, nombre, tipo, rareza, valor | `__str__` |
| `Coleccion` | cartas (dict by code) | `anadir`, `eliminar`, `listar`, `buscar`, `filtrar_rareza`, `intercambiar`, `valor_total`, `total_cartas`, `por_rareza`, `top` |

**Atomic exchange: check everything BEFORE touching anything**

```python
def intercambiar(self, codigo_antiguo, nueva):
    antiguo = codigo_antiguo.strip().upper()
    nuevo = nueva.codigo.strip().upper()
    if antiguo not in self.cartas:  return False, "Old card doesn't exist."
    if not nuevo:                   return False, "Empty code."
    if nuevo in self.cartas:        return False, "New code is taken."
    del self.cartas[antiguo]        # only now change things
    self.cartas[nuevo] = nueva
    return True, "Exchanged."
```

**Case-insensitive search:** `t in c.nombre.lower() or t in c.tipo.lower()`.

**Count per rarity:**

```python
cuenta = {}
for c in self.cartas.values():
    cuenta[c.rareza] = cuenta.get(c.rareza, 0) + 1
```

**Top 3:** `sorted(self.cartas.values(), key=lambda c: c.valor, reverse=True)[:3]`.

Tests: initial value **39 €** (5 + 30 + 4). Exchanging PK02 for a card with code PK03 must fail and **PK02 stays**.

### Project 03: Centro de talleres

| Class | Attributes | Methods |
|---|---|---|
| `Participante` | email, nombre | |
| `Taller` | codigo, titulo, plazas | |
| `Inscripcion` | email_participante, codigo_taller | |
| `CentroTalleres` | participantes (dict), talleres (dict), inscripciones (list) | `alta_taller`, `alta_participante`, `inscribir`, `cancelar`, `inscritos`, `plazas_libres`, `ocupacion`, `buscar_participantes`, `talleres_de`, `ranking` |

**Enrol: all four validations**

```python
def inscribir(self, email, codigo):
    email, codigo = email.strip().lower(), codigo.strip().upper()
    if email not in self.participantes:      return False, "Unknown participant."
    if codigo not in self.talleres:          return False, "Unknown workshop."
    if self._existe(email, codigo):          return False, "Already enrolled."
    if self.plazas_libres(codigo) <= 0:      return False, "Workshop is full."
    self.inscripciones.append(Inscripcion(email, codigo))
    return True, "Enrolled."
```

**Free places and occupation:**

```python
def plazas_libres(self, codigo):
    t = self.talleres[codigo]
    return t.plazas - sum(1 for i in self.inscripciones if i.codigo_taller == codigo)

def ocupacion(self, codigo):
    t = self.talleres[codigo]
    return (t.plazas - self.plazas_libres(codigo)) / t.plazas * 100
```

2 places and 1 enrolled → **1 free, 50 %**.

**Cancel a non-existent enrolment must not affect others:** search the list; if not found `return False`, don't delete anything.

**Ranking:** `sorted(..., key=lambda par: par[1], reverse=True)`.

**Loading CSVs:** load participants and workshops first, then call `inscribir()` for each enrolment row. Invalid, duplicate or over-capacity rows are rejected automatically. Relate by **codes and emails, never by copying objects into the CSV**.

### Project 04: Servicio técnico (inheritance)

| Class | Attributes | Methods |
|---|---|---|
| `Trabajo` (base) | codigo, cliente, horas, estado | `calcular_importe()` (abstract), `cambiar_estado()`, `cambiar_horas()` |
| `Reparacion(Trabajo)` | + precio_pieza | `calcular_importe()` = horas × 25 + pieza |
| `AsistenciaRemota(Trabajo)` | – | `calcular_importe()` = horas × 20 |
| `ServicioTecnico` (manager) | trabajos (dict) | `alta`, `cambiar_estado`, `cambiar_horas`, `buscar`, `resumen` |

**Inheritance syntax (very likely asked):**

```python
class Trabajo:
    tipo = "trabajo"
    def __init__(self, codigo, cliente, horas, estado="pendiente"):
        self.codigo = codigo
        self.cliente = cliente
        self.horas = horas
        self.estado = estado

    def calcular_importe(self):
        raise NotImplementedError

class Reparacion(Trabajo):
    tipo = "reparacion"
    def __init__(self, codigo, cliente, horas, precio_pieza=0.0, estado="pendiente"):
        super().__init__(codigo, cliente, horas, estado)   # parent constructor
        self.precio_pieza = precio_pieza

    def calcular_importe(self):                            # override
        return round(self.horas * 25 + self.precio_pieza, 2)

class AsistenciaRemota(Trabajo):
    tipo = "remota"
    def calcular_importe(self):
        return round(self.horas * 20, 2)
```

**Polymorphism:** `sum(t.calcular_importe() for t in trabajos)`: Python calls the right version for each object.

**State machine (only one step forward):**

```python
ESTADOS = ["pendiente", "en curso", "finalizado"]

def cambiar_estado(self, nuevo):
    nuevo = nuevo.strip().lower()
    if nuevo not in ESTADOS:
        return False, "Unknown state."
    if ESTADOS.index(nuevo) != ESTADOS.index(self.estado) + 1:
        return False, "Transition not allowed."
    self.estado = nuevo
    return True, "State changed."
```

**CSV with `tipo` column to rebuild the subclass:**

```python
if tipo == "reparacion":
    trabajo = Reparacion(codigo, cliente, horas, precio_pieza)
else:
    trabajo = AsistenciaRemota(codigo, cliente, horas)
```

Tests: 2 h + 40 € piece = **90 €**; remote 1.5 h = **30 €**; pending → finalized rejected without changing the state.

---

## 5. Python snippets the teacher may ask for

```python
# Filtering with a list comprehension
caras = [c for c in cartas.values() if c.valor > 10]

# Sorting
ordenadas = sorted(lista, key=lambda x: x.valor, reverse=True)

# Sum with condition
total = sum(t.calcular_importe() for t in trabajos if t.estado == "finalizado")

# Count with a dictionary
cuenta = {}
for x in lista:
    cuenta[x.rareza] = cuenta.get(x.rareza, 0) + 1

# Check if any element satisfies something
existe = any(i.email == email and i.taller == codigo for i in inscripciones)

# Case-insensitive contains
if texto.lower() in nombre.lower(): ...

# Round money / format
f"{valor:.2f} €"        # 2 decimals
f"{pct:g} %"            # 50.0 -> 50

# Remove from list safely: find index, then del
for i, ins in enumerate(lista):
    if ins.email == email:
        del lista[i]
        break              # fine inside a for loop; just don't use it for the MENU
```

> The "no `break`" rule is about **menus** (`while True` + `break`). A `break` or `return` inside a search loop is fine.

---

## 6. What he may ask on the exam (and how to answer)

| Possible request | How to do it |
|---|---|
| "Create a new project (library, gym, hotel, vet...)" | Same skeleton: entity class + manager class with a dict + validations + CSV + menu |
| "Add a method that returns the total / average / maximum" | `sum()`, `sum()/len()`, `max(..., key=...)` over `.values()` |
| "Add a search by name fragment" | List comprehension with `.lower()` and `in` |
| "Filter by category / state / type" | Another condition in the comprehension |
| "Sort by X" | `sorted(key=lambda ...)` |
| "Top N" | `sorted(...)[:N]` |
| "Reject duplicates / negatives / empty" | `if` checks at the top, return `(False, msg)` |
| "Make this operation atomic" | Validate everything first, modify last |
| "Cancel / undo operation" | Reverse exactly what was done (e.g. return stock) |
| "Add a subclass with a different calculation" | Inherit, `super().__init__`, override the method |
| "Save/load CSV with accents" | `encoding="utf-8"`, `newline=""` |
| "Load without duplicates or orphans" | Reuse your validation methods when loading |
| "Percentage / free places / discount" | Arithmetic in a method that returns a number |
| "Explain why `print` isn't inside the class" | Separation: classes = logic (reusable, testable), `main` = user interface |
| "Why a dictionary?" | O(1) lookup by key and keys are unique by construction |
| "Why `try/except ValueError`?" | `int("abc")` raises `ValueError`; we catch it so the program doesn't crash |
| "What does `if __name__ == '__main__'` do?" | Runs `main()` only when the file is executed directly, not when imported |
| "Difference between list and dict here" | List keeps order/duplicates; dict gives fast unique-key access |
| "What is `super()`?" | Calls the parent class (constructor/method) |
| "What is polymorphism?" | Same method name, different behaviour per class (`calcular_importe`) |

---

## 7. Common mistakes to avoid

- Writing `print`/`input` in a class.
- Modifying stock/state **before** validating (leaves partial changes).
- Forgetting `.strip()` / `.lower()` / `.upper()` on codes and emails → false "not found".
- Comparing a string to a number (`"3" > 2` fails): convert with `int()`/`float()` first.
- Forgetting the CSV **header** or `newline=""`.
- Saving objects instead of **codes** (CSV only holds text).
- Using `while True` + `break` for the menu.
- Not converting CSV values back to `int`/`float` when loading.
- Mutating a list while looping over it (loop over a copy, or find the index then delete).
- Not handling decimal comma (`1,5`): use `.replace(",", ".")`.
- Float rounding: use `round(x, 2)`.

---

## 8. 10-minute exam routine

1. Read the statement and **underline**: entities, unique key, validations, special rule (discount / atomic / inheritance / capacity).
2. Write the entity classes (`__init__` + `__str__`).
3. Write the manager class with `alta`, `eliminar`/`cancelar`, `buscar`, and the special method.
4. Write `cargar` / `guardar`.
5. Write `main()` with `pedir_numero`, the menu loop `while opcion != 0`, and one branch per option.
6. Test the cases in the statement (valid, invalid, restart and reload).

Good luck on the exam! 🍀
