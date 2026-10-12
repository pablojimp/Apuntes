import calculos

cantidad = int(input("Introduce cuantos elementos vas a comprar: "))
precio = float(input("Introduce el precio de los elementos que has comprado: "))
porcentaje = int(input("Introduce el porcentaje de descuento que quieres aplicar: "))

print(f"Subtotal: {calculos.calcular_subtotal(precio,cantidad)} €")
print(f"Descuento: {calculos.aplicar_descuento(calculos.calcular_subtotal(precio,cantidad),porcentaje)} €")