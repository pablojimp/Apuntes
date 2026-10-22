"""Lectura/escritura de CSV. Sin print() ni input()."""
import csv
from pathlib import Path

from modelos import Carta, Coleccion

CAMPOS = ["codigo", "nombre", "tipo", "rareza", "valor"]


def cartas_iniciales():
    return [Carta("PK01", "Pikachu", "Eléctrico", "Común", 5.0),
            Carta("PK02", "Charizard", "Fuego", "Rara", 30.0),
            Carta("PK03", "Bulbasaur", "Planta", "Común", 4.0)]


def cargar(ruta):
    ruta = Path(ruta)
    if not ruta.exists():
        return Coleccion(cartas_iniciales())
    coleccion = Coleccion()
    with open(ruta, newline="", encoding="utf-8") as f:
        for fila in csv.DictReader(f):
            try:
                carta = Carta(fila["codigo"], fila["nombre"], fila["tipo"],
                              fila["rareza"], float(fila["valor"]))
            except (ValueError, KeyError, TypeError):
                continue
            coleccion.anadir(carta)  # rechaza vacíos, repetidos y negativos
    return coleccion


def guardar(ruta, coleccion):
    with open(ruta, "w", newline="", encoding="utf-8") as f:
        w = csv.writer(f)
        w.writerow(CAMPOS)
        for c in coleccion.listar():
            w.writerow([c.codigo, c.nombre, c.tipo, c.rareza, f"{c.valor:g}"])