"""Lectura/escritura de CSV. Sin print() ni input()."""
import csv
from pathlib import Path

from modelos import ServicioTecnico, ESTADOS

CAMPOS = ["tipo", "codigo", "cliente", "horas", "estado", "precio_pieza"]


def cargar(ruta):
    """Reconstruye el subtipo correcto a partir del campo 'tipo'."""
    servicio = ServicioTecnico()
    ruta = Path(ruta)
    if not ruta.exists():
        return servicio
    with open(ruta, newline="", encoding="utf-8") as f:
        for fila in csv.DictReader(f):
            try:
                tipo = fila["tipo"].strip().lower()
                horas = float(fila["horas"])
                estado = fila["estado"].strip().lower()
                pieza = float(fila["precio_pieza"]) if fila["precio_pieza"].strip() else 0.0
                if estado not in ESTADOS:
                    continue
                ok, _ = servicio.alta(tipo, fila["codigo"], fila["cliente"], horas, pieza)
                if ok:
                    servicio.trabajos[fila["codigo"].strip().upper()].estado = estado
            except (ValueError, KeyError, TypeError):
                continue
    return servicio


def guardar(ruta, servicio):
    with open(ruta, "w", newline="", encoding="utf-8") as f:
        w = csv.writer(f)
        w.writerow(CAMPOS)
        for t in servicio.trabajos.values():
            w.writerow([t.tipo, t.codigo, t.cliente, f"{t.horas:g}", t.estado, t.precio_pieza_csv()])