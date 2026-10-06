
precio_unitario = float(input("Introduce el precio: "))
cantidad = int(input("Introduce la cantidad: "))
mostrar = True
subtotal = precio_unitario*cantidad
if(cantidad < 0 or precio_unitario < 0):
    mostrar = False
if(cantidad < 5):
    descuento = 0
elif(cantidad>= 5 and cantidad <= 9):
    descuento = 5
elif(cantidad>= 10):
    descuento = 10

total = subtotal - (subtotal * descuento / 100)  

if(mostrar):
    print(f"Subtotal: {subtotal} | Porcentaje: {descuento}% | Total: {total}")
else:
    print(f"Error no se puede mostrar numeros negativos")