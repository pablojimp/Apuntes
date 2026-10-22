"""Punto de entrada. Centro de talleres: inscripciones y plazas.
Toda la interacción (print/input) vive aquí."""
from pathlib import Path

from persistencia import cargar_centro, guardar_centro

BASE = Path(__file__).parent
RUTAS = (BASE / "participantes.csv", BASE / "talleres.csv", BASE / "inscripciones.csv")

MENU = """
=== Centro de talleres ===
1) Participantes   2) Alta participante   3) Inscribir   4) Cancelar
5) Ver taller   6) Buscar participante   7) Guardar   8) Ranking
0) Salir"""


def pedir_numero(texto, tipo):
    try:
        return tipo(input(texto).strip())
    except ValueError:
        print("Entrada no válida: introduce un número.")
        return None


def participantes(c):
    for p in c.participantes.values():
        print(f"{p.email} - {p.nombre}")
    if not c.participantes:
        print("(no hay participantes)")


def alta(c):
    print(c.alta_participante(input("Email: "), input("Nombre: "))[1])


def inscribir(c):
    print(c.inscribir(input("Email: "), input("Código de taller: "))[1])


def cancelar(c):
    print(c.cancelar(input("Email: "), input("Código de taller: "))[1])


def ver_taller(c):
    codigo = input("Código de taller (vacío para todos): ").strip().upper()
    codigos = list(c.talleres) if codigo == "" else [codigo]
    for cod in codigos:
        if cod not in c.talleres:
            print("Taller inexistente.")
            continue
        t = c.talleres[cod]
        print(f"{t.codigo} {t.titulo}: {c.plazas_libres(cod)} plaza(s) libre(s) de {t.plazas}, "
              f"{c.ocupacion(cod):g} % de ocupación")
        for p in c.inscritos(cod):
            print(f"   - {p.nombre} <{p.email}>")


def buscar(c):
    encontrados = c.buscar_participantes(input("Fragmento del nombre: "))
    if not encontrados:
        print("(sin resultados)")
    for p in encontrados:
        talleres = ", ".join(t.titulo for t in c.talleres_de(p.email)) or "ninguno"
        print(f"{p.nombre} <{p.email}> -> talleres: {talleres}")


def guardar(c):
    guardar_centro(c, *RUTAS)
    print("Datos guardados.")


def ranking(c):
    for t, pct in c.ranking():
        print(f"{t.titulo}: {pct:g} %")


def main():
    centro = cargar_centro(*RUTAS)
    acciones = {1: participantes, 2: alta, 3: inscribir, 4: cancelar,
                5: ver_taller, 6: buscar, 7: guardar, 8: ranking}
    opcion = -1
    while opcion != 0:
        print(MENU)
        opcion = pedir_numero("Opción: ", int)
        if opcion is None:
            opcion = -1
        elif opcion in acciones:
            acciones[opcion](centro)
        elif opcion != 0:
            print("Opción no válida.")
    print("¡Hasta pronto!")


if __name__ == "__main__":
    main()