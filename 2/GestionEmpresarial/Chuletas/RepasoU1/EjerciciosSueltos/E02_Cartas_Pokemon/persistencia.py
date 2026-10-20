"""Lectura/escritura de CSV. Sin print() ni input()."""

# TODO: define funciones de carga y guardado que devuelvan resultados.
import csv
import modelos
def cargar_csv_productos(ruta):
    lista_devolver = []
    if ruta.exists():
        with open(ruta, 'r', newline='', encoding='utf-8') as archivo:
            lector = csv.DictReader(archivo)
            for fila in lector:
                try:
                    lista_devolver.append(
                        modelos.Carta(fila['codigo'],fila['nombre'],fila['tipo'],fila['rareza'],int(fila['valor'])))
                except ValueError:
                    pass
    
    return modelos.Coleccion(lista_devolver)
