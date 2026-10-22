"""Lectura/escritura de CSV. Sin print() ni input()."""
import csv
from pathlib import Path

from modelos import CentroTalleres


def _filas(ruta):
    ruta = Path(ruta)
    if not ruta.exists():
        return []
    with open(ruta, newline="", encoding="utf-8") as f:
        return list(csv.DictReader(f))


def cargar_centro(ruta_part, ruta_tall, ruta_insc):
    """Reconstruye el centro. Las inscripciones pasan por inscribir(), así que una carga
    nunca genera inscripciones a emails/talleres inexistentes, duplicadas ni por encima del aforo."""
    centro = CentroTalleres()
    filas_t = _filas(ruta_tall)
    if not Path(ruta_tall).exists():
        centro.alta_taller("T01", "Cerámica", 2)
        centro.alta_taller("T02", "Fotografía", 3)
        centro.alta_taller("T03", "Cocina", 4)
    for f in filas_t:
        try:
            centro.alta_taller(f["codigo"], f["titulo"], int(f["plazas"]))
        except (ValueError, KeyError, TypeError):
            continue
    for f in _filas(ruta_part):
        try:
            centro.alta_participante(f["email"], f["nombre"])
        except (KeyError, TypeError):
            continue
    for f in _filas(ruta_insc):
        try:
            centro.inscribir(f["email_participante"], f["codigo_taller"])
        except (KeyError, TypeError):
            continue
    return centro


def guardar_centro(centro, ruta_part, ruta_tall, ruta_insc):
    with open(ruta_part, "w", newline="", encoding="utf-8") as f:
        w = csv.writer(f)
        w.writerow(["email", "nombre"])
        for p in centro.participantes.values():
            w.writerow([p.email, p.nombre])
    with open(ruta_tall, "w", newline="", encoding="utf-8") as f:
        w = csv.writer(f)
        w.writerow(["codigo", "titulo", "plazas"])
        for t in centro.talleres.values():
            w.writerow([t.codigo, t.titulo, t.plazas])
    with open(ruta_insc, "w", newline="", encoding="utf-8") as f:
        w = csv.writer(f)
        w.writerow(["email_participante", "codigo_taller"])
        for i in centro.inscripciones:
            w.writerow([i.email_participante, i.codigo_taller])