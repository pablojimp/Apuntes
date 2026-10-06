nombre = input("Nombre del producto: ")
precio = float(input("Precio: "))
cantidad = int(input("Cantidad: "))
descuento = float(input("Porcentaje de descuento: "))

subtotal = precio * cantidad
importe_descuento = subtotal * descuento / 100
total = subtotal - importe_descuento

print(f"\nProducto: {nombre}")
print(f"Subtotal: {subtotal:.2f} €")
print(f"Descuento: {importe_descuento:.2f} €")
print(f"Total: {total:.2f} €")
