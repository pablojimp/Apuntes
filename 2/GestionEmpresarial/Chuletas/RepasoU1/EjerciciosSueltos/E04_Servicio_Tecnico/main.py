"""Punto de entrada. Servicio técnico: órdenes y herencia.
Toda la interacción (print/input) vive aquí."""
from pathlib import Path

from persistencia import cargar, guardar

RUTA = Path(__file__).parent / "trabajos.csv"

MENU = """
=== Servicio técnico ===
1) Listar   2) Alta reparación   3) Alta remota   4) Cambiar estado
5) Buscar/filtrar   6) Resumen   7) Guardar   8) Cambiar horas
0) Salir"""


def pedir_numero(texto, tipo):
    try:
        return tipo(input(texto).strip().replace(",", "."))
    except ValueError:
        print("Entrada no válida: introduce un número.")
        return None


def mostrar(trabajos):
    if not trabajos:
        print("(sin resultados)")
    for t in trabajos:
        print(t)


def alta_reparacion(s):
    codigo, cliente = input("Código: "), input("Cliente: ")
    horas = pedir_numero("Horas: ", float)
    pieza = pedir_numero("Precio de la pieza (€): ", float)
    if horas is not None and pieza is not None:
        print(s.alta("reparacion", codigo, cliente, horas, pieza)[1])


def alta_remota(s):
    codigo, cliente = input("Código: "), input("Cliente: ")
    horas = pedir_numero("Horas: ", float)
    if horas is not None:
        print(s.alta("remota", codigo, cliente, horas)[1])


def cambiar_estado(s):
    print(s.cambiar_estado(input("Código: "), input("Nuevo estado (pendiente/en curso/finalizado): "))[1])


def buscar(s):
    cliente = input("Cliente (fragmento, vacío = todos): ")
    tipo = input("Tipo (reparacion/remota, vacío = todos): ")
    estado = input("Estado (vacío = todos): ")
    mostrar(s.buscar(cliente, tipo, estado))


def resumen(s):
    por_estado, total = s.resumen()
    for estado, n in por_estado.items():
        print(f"{estado}: {n}")
    print(f"Importe total finalizados: {total:.2f} €")


def cambiar_horas(s):
    codigo = input("Código: ")
    horas = pedir_numero("Nuevas horas: ", float)
    if horas is not None:
        print(s.cambiar_horas(codigo, horas)[1])


def guardar_datos(s):
    guardar(RUTA, s)
    print("Datos guardados.")


def main():
    servicio = cargar(RUTA)
    acciones = {1: lambda s: mostrar(list(s.trabajos.values())), 2: alta_reparacion,
                3: alta_remota, 4: cambiar_estado, 5: buscar, 6: resumen,
                7: guardar_datos, 8: cambiar_horas}
    opcion = -1
    while opcion != 0:
        print(MENU)
        opcion = pedir_numero("Opción: ", int)
        if opcion is None:
            opcion = -1
        elif opcion in acciones:
            acciones[opcion](servicio)
        elif opcion != 0:
            print("Opción no válida.")
    print("¡Hasta pronto!")


if __name__ == "__main__":
    main()