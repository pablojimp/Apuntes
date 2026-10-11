
categorias = ["Periféricos", "Pantallas", "Periféricos", "Audio", "Pantallas"]
productos = ["Teclado mecánico", "Ratón inalámbrico", "Monitor", "Altavoces", "Teclado básico"]

categorias_unicas = set(categorias)

print(categorias_unicas)

texto = input("Texto de búsqueda: ").strip().lower()

coincidencias = []

for producto in productos:
        if texto in producto.lower():
            coincidencias.append(producto)
print("\n".join(coincidencias))