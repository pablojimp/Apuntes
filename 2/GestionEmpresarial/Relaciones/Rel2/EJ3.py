nombre = input("Nombre del producto: ")
precio = float(input("Precio: "))
cantidad = int(input("Cantidad: "))
descuento = float(input("Porcentaje de descuento: "))

subtotal = precio * cantidad
importeDescuento = subtotal * descuento / 100
total = subtotal - importeDescuento

print(f"\nProducto: {nombre}")
print(f"Subtotal: {subtotal:.2f} €")
print(f"Descuento: {importeDescuento:.2f} €")
print(f"Total: {total:.2f} €")
