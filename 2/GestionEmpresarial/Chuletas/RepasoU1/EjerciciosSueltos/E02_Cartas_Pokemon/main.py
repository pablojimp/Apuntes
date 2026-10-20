"""Punto de entrada. Colección de cartas Pokémon: intercambios.
Toda la interacción (print/input) vive aquí."""
from pathlib import Path

from modelos import Carta
from persistencia import cargar, guardar

RUTA = Path(__file__).parent / "cartas.csv"

MENU = """
=== Cartas Pokémon ===
1) Listar   2) Añadir   3) Eliminar   4) Buscar/filtrar
5) Intercambiar   6) Estadísticas   7) Guardar   8) Top 3
0) Salir"""


def pedir_numero(texto, tipo):
    try:
        return tipo(input(texto).strip().replace(",", "."))
    except ValueError:
        print("Entrada no válida: introduce un número.")
        return None


def pedir_carta(codigo_texto="Código: "):
    codigo = input(codigo_texto)
    nombre = input("Nombre: ")
    tipo = input("Tipo: ")
    rareza = input("Rareza: ")
    valor = pedir_numero("Valor (€): ", float)
    if valor is None:
        return None
    return Carta(codigo, nombre, tipo, rareza, valor)


def mostrar(cartas):
    if not cartas:
        print("(sin resultados)")
    for c in cartas:
        print(c)


def anadir(col):
    carta = pedir_carta()
    if carta is not None:
        print(col.anadir(carta)[1])


def eliminar(col):
    print(col.eliminar(input("Código a eliminar: "))[1])


def buscar(col):
    modo = input("Buscar por (1) nombre/tipo o (2) rareza: ").strip()
    if modo == "1":
        mostrar(col.buscar(input("Texto: ")))
    elif modo == "2":
        mostrar(col.filtrar_rareza(input("Rareza: ")))
    else:
        print("Opción no válida.")


def intercambiar(col):
    antiguo = input("Código de la carta a entregar: ")
    nueva = pedir_carta("Código de la carta nueva: ")
    if nueva is not None:
        print(col.intercambiar(antiguo, nueva)[1])


def estadisticas(col):
    print(f"Cartas: {col.total_cartas()} | Valor total: {col.valor_total():.2f} €")
    for rareza, n in col.por_rareza().items():
        print(f"  {rareza}: {n}")


def guardar_datos(col):
    guardar(RUTA, col)
    print("Colección guardada.")


def main():
    col = cargar(RUTA)
    acciones = {1: lambda c: mostrar(c.listar()), 2: anadir, 3: eliminar,
                4: buscar, 5: intercambiar, 6: estadisticas, 7: guardar_datos,
                8: lambda c: mostrar(c.top(3))}
    opcion = -1
    while opcion != 0:
        print(MENU)
        opcion = pedir_numero("Opción: ", int)
        if opcion is None:
            opcion = -1
        elif opcion in acciones:
            acciones[opcion](col)
        elif opcion != 0:
            print("Opción no válida.")
    print("¡Hasta pronto!")


if __name__ == "__main__":
    main()