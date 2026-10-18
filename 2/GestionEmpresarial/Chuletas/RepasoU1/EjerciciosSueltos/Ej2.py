
# Una tienda guarda las ventas de cada día en una lista:



# Crea una función resumir_ventas(ventas) que devuelva un diccionario con estos datos:
# - 'total': suma de todas las ventas.
# - 'media': media de ventas.
# - 'dias_sin_ventas': número de días en los que las ventas fueron 0.
# - 'dias_buenos': número de días con ventas iguales o superiores a 100.
# Si la lista está vacía, devuelve None.
# Reglas
# 1. Usa un bucle for.
# 2. Usa acumuladores y contadores.
# 3. Devuelve un diccionario con las cuatro claves solicitadas.
# 4. No uses print() dentro de la función.
# 5. Prueba la función con la lista dada y también con [].
# Pista: necesitarás una variable para acumular las ventas y dos contadores. 
# Para calcular la media, recuerda comprobar antes si la lista está vacía.
# Te toca. Envíame tu código del ejercicio 2 y lo revisamos antes de subir al siguiente nivel.



def resumir_ventas(ventas):
    lista = {}
    lista['dias_sin_ventas'] = 0
    lista['dias_buenos'] = 0
    lista['total'] = sum(ventas)
    
    if len(ventas) > 0:
        lista['media'] = sum(ventas) / len(ventas)
    else:
        lista = None
    
    for venta in ventas:
        if venta == 0:
            lista['dias_sin_ventas'] += 1
        elif venta >= 100:
            lista['dias_buenos'] += 1
    
    
    return lista

ventas = [120.50, 80.00, 0, 230.75, 45.00, 160.00, 95.50]
resumen = resumir_ventas(ventas)

print(resumen)