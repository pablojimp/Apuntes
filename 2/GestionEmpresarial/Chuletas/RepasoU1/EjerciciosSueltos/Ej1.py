




def clasificar_pedido(importe):
    if importe < 0:
        return 'Importe no válido'
    elif importe < 50:
        return 'Pedido pequeño'
    elif importe < 200:
        return 'Pedido mediano'
    else:
        return 'Pedido grande'


def calcular_descuento(importe, porcentaje=0):
    return importe - (importe * porcentaje / 100)


print(clasificar_pedido(-5))
print(clasificar_pedido(0))
print(clasificar_pedido(75))
print(clasificar_pedido(250))
print(calcular_descuento(100, 10))
print(calcular_descuento(80))
