lista = ["Teclado", "Ratón", "Monitor"]

lista.remove("Ratón")
lista.append("Webcam")


lineas = []

for numero, producto in enumerate(lista, start=1):
    lineas.append(f"{numero}. {producto}")

print("\n".join(lineas))
