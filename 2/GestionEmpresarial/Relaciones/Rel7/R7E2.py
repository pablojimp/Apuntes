# Crea una lista con cinco precios. Recorre la lista y muestra cada valor. Después
# calcula cantidad de precios, suma, mínimo, máximo y media. Puedes usar len(),
# sum(), min() y max().


## VERSION PABLO

lista = [40.50 , 30.45 , 35.87 , 654.54 , 45.87]

minimo = min(lista)
maximo = max(lista)
total = sum(lista)
media = total/len(lista)

print(f"Minimo de la lista: {minimo:.2f}€")
print(f"Maximo de la lista: {maximo:.2f}€")
print(f"Total de la lista: {total:.2f}€")
print(f"Media de la lista: {media:.2f}€")



## VERSION CLASE

precios = [12.50, 25.00, 8.75, 40.00, 18.25]

lineas = []

for precio in precios:
    lineas.append(f"{precio:.2f} EUR")

cantidad = len(precios)
total = sum(precios)
minimo = min(precios)
maximo = max(precios)
media = total / cantidad

lineas.append(f"Cantidad: {cantidad}")
lineas.append(f"Suma: {total:.2f} EUR")
lineas.append(f"Mínimo: {minimo:.2f} EUR")
lineas.append(f"Máximo: {maximo:.2f} EUR")
lineas.append(f"Media: {media:.2f} EUR")

print("\n".join(lineas))
