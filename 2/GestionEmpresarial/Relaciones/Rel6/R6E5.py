# Pide un número de productos y un número de meses. Usa dos bucles for anidados
# para mostrar una cuadrícula de textos del tipo "Producto 1 - Mes 1", "Producto 1 -
# Mes 2"... para todas las combinaciones

numeroMeses = int(input("Escribe cuantos meses vas a introducir: "))
numeroProductos = int(input("Escribe cuantos productos vas a introducir: "))

for i in range(numeroMeses):
    for j in range(numeroProductos):
        print(f"Producto {j+1} - Mes {i+1}")