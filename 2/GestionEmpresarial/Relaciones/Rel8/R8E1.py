

def calcular_subtotal(precio, cantidad):
    return precio * cantidad


precio_pedido = float(input("Introduce el precio del pedido: "))
cantidad_pedido = int(input("Introduce cuantos elementos tiene el pedido: "))


subtotal = calcular_subtotal(precio_pedido, cantidad_pedido)
print(f"El total es: {subtotal:.2f}")