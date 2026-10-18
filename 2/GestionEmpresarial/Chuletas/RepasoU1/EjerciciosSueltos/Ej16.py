
import csv

CAMPOS = ['producto', 'precio', 'cantidad']

def cargar_ventas(ruta):
    objetos = []
    try:
        with open(ruta, 'r', newline='', encoding='utf-8') as archivo:
            lector = csv.DictReader(archivo)
            for fila in lector:
                try:
                    objetos.append(
                        {
                        'producto': fila['producto'],
                        'precio': float(fila['precio']),
                        'cantidad': int(fila['cantidad'])
                        }
                    )
                except ValueError:
                    pass
            return objetos
    except FileNotFoundError:
        return objetos
            
