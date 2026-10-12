import csv

productos = [
    {"nombre": "Teclado", "precio": 25.99, "stock": 10},
    {"nombre": "Ratón", "precio": 12.50, "stock": 30},
    {"nombre": "Monitor", "precio": 149.00, "stock": 5},
]

# Escribir
with open("productos.csv", "w", newline="", encoding="utf-8") as f:
    escritor = csv.DictWriter(f, fieldnames=["nombre", "precio", "stock"])
    escritor.writeheader()
    escritor.writerows(productos)

# Leer
with open("productos.csv", "r", newline="", encoding="utf-8") as f:
    for fila in csv.DictReader(f):
        print(fila)