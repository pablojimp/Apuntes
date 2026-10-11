# Crea una lista con al menos cuatro diccionarios de productos. Cada producto
# tendrá nombre, categoría, precio y stock. Recorre la lista y muestra solo los
# productos con stock mayor que 0. Al final indica cuántos están disponibles

productos = [
    {"nombre": "Teclado", "categoria": "Periféricos", "precio": 25.50, "stock": 4},
    {"nombre": "Ratón", "categoria": "Periféricos", "precio": 15.00, "stock": 0},
    {"nombre": "Monitor", "categoria": "Pantallas", "precio": 180.00, "stock": 3},
    {"nombre": "Webcam", "categoria": "Periféricos", "precio": 45.00, "stock": 2}
]
lista = []

for producto in productos:
    if producto["stock"] > 0:
        lista.append(producto["nombre"])
    
print("\n".join(lista))
print(f"Estan disponibles: {len(lista)}")