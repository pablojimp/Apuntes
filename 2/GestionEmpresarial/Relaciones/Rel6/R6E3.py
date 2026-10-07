
activo = True
contador = 1
total = 0
while activo:
    cuenta = float(input("Introduce el importe: "))
    if cuenta != 0:
        total += cuenta
        contador += 1
    else:
        activo = False
print(f"Se han registrado {contador} cuentas y el total es de {total:.2f}€")