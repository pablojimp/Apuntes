nombre = input("Nombre: ")
nombreServicio = input("Nombre del servicio: ")
precioUnitario = input("Precio unitario: ")
cantidad = input("Cantidad: ")

cantidadInteger = int(cantidad)
precioUnitarioFloat = float(precioUnitario)

total = cantidadInteger * precioUnitarioFloat

print(f"Total: {total}")
