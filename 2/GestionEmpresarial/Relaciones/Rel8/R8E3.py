def aplicar_descuento(importe, porcentaje=0):
    return importe - (importe * (porcentaje / 100))


coste = float(input("Introduce el importe: "))

print(f"El importe sin descuento: {aplicar_descuento(coste)}, y con el 10% de descuento: {aplicar_descuento(coste, 10)}")