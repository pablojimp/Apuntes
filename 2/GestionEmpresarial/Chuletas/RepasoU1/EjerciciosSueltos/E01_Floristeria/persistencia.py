"""Lectura/escritura de CSV. Sin print() ni input()."""

# TODO: define funciones de carga y guardado que devuelvan resultados.
import csv
import modelos
def cargar_csv_productos(ruta,CSV_CABECERAS_PRODUCTOS):
    lista_devolver = []
    if ruta.exists():
        with open(ruta, 'r', newline='', encoding='utf-8') as archivo:
            lector = csv.DictReader(archivo)
            for fila in lector:
                try:
                    lista_devolver.append(
                        modelos.Producto(
                            fila[f'{CSV_CABECERAS_PRODUCTOS[0]}'],
                                         fila[f'{CSV_CABECERAS_PRODUCTOS[1]}'],
                                         fila[f'{CSV_CABECERAS_PRODUCTOS[2]}'],
                                         float(fila[f'{CSV_CABECERAS_PRODUCTOS[3]}']),
                                         int(fila[f'{CSV_CABECERAS_PRODUCTOS[4]}'])))
                except ValueError:
                    pass
    
    return lista_devolver


def cargar_csv_ventas(ruta):
    lista_devolver = []
    if ruta.exists():
        with open(ruta, 'r', newline='', encoding='utf-8') as archivo:
            lector = csv.DictReader(archivo)
            for fila in lector:
                try:
                    lista_devolver.append(
                        {
                            'numero':f'{fila['numero']}',
                            'cliente':f'{fila['cliente']}',
                            'codigo_producto':f'{fila['codigo_producto']}',
                            'cantidad':f'{fila['cantidad']}',
                            'precio_unitario':f'{fila['precio_unitario']}'
                        }
                    )
                except ValueError:
                    pass
    
    return lista_devolver