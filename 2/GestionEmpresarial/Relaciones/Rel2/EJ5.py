cliente = input("Cliente: ")

producto1 = input("Nombre del primer producto: ")
precio1 = float(input("Precio del primer producto: "))
cantidad1 = int(input("Cantidad del primer producto: "))

producto2 = input("Nombre del segundo producto: ")
precio2 = float(input("Precio del segundo producto: "))
cantidad2 = int(input("Cantidad del segundo producto: "))

subtotal1 = precio1 * cantidad1
subtotal2 = precio2 * cantidad2

total = subtotal1 + subtotal2

print(f"Cliente: {cliente}")
print(f"{producto1} - {cantidad1} x {precio1:.2f} € = {subtotal1:.2f} €")
print(f"{producto2} - {cantidad2} x {precio2:.2f} € = {subtotal2:.2f} €")
print(f"Total sin impuestos: {total:.2f} €")
