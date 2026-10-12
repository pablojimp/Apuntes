contador = 1
with open("clientes.txt", "w", encoding="utf-8") as archivo:
    while contador <= 3:
        nombre = input("Introduce el nombre del cliente: ")
        ciudad = input(f"Introduce el nombre de la ciudad de {nombre}: ")
        archivo.write(f"{nombre};{ciudad}\n")
        contador += 1