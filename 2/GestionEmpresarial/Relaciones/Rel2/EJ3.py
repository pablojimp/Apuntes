nombre = input("Nombre del producto: ")
precio = float(input("Precio: "))
cantidad = int(input("Cantidad: "))
descuento = float(input("Porcentaje de descuento: "))

subtotal = precio * cantidad
importeDescuento = subtotal * descuento / 100
total = subtotal - importeDescuento

print(f"Producto: {nombre}")
print(f"Subtotal: {subtotal} €")
print(f"Descuento: {importeDescuento} €")
print(f"Total: {total} €")
