producto = input("Producto: ")
existencias = int(input("Existencias iniciales: "))
recibidas = int(input("Unidades recibidas: "))
vendidas = int(input("Unidades vendidas: "))

stockFinal = existencias + recibidas - vendidas


print(f"Producto: {producto}")
print(f"Existencias iniciales: {existencias}")
print(f"Unidades recibidas: {recibidas}")
print(f"Unidades vendidas: {vendidas}")
print(f"Stock final: {stockFinal}")
