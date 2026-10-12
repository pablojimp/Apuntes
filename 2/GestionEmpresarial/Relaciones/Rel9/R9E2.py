
def leer_entero(mensaje, minimo, maximo):
    numero_valido = False
    while not numero_valido:
        try:
            numero = int(input(mensaje))
            numero_valido = minimo <= numero <= maximo
            if not numero_valido:
                print(f"El número debe estar entre {minimo} y {maximo}")
        except ValueError:
            print("Eso no es un número entero, inténtalo de nuevo")
    return numero

cantidad = leer_entero("Introduce una cantidad entre 1 y 100: ", 1, 100)
print(f"Has elegido: {cantidad}")