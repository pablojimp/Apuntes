




# Crea una función gestionar_stock(inventario, producto, cantidad) que:
# 1. Si el producto no existe, devuelva 'Producto no encontrado'.
# 2. Si cantidad es menor o igual a cero, devuelva 'Cantidad no válida'.
# 3. Si todo es válido, sume la cantidad al stock del producto y devuelva el nuevo stock de ese producto como número entero.
# Ejemplos:
# gestionar_stock(inventario, 'raton', 3)    # devuelve 13gestionar_stock(inventario, 'monitor', 2)  # devuelve 2gestionar_stock(inventario, 'tablet', 4)   # devuelve 'Producto no encontrado'gestionar_stock(inventario, 'cable', 0)    # devuelve 'Cantidad no válida'



# Importante: modifica el diccionario original; no crees uno nuevo.
# Pista: para comprobar si una clave existe en un diccionario puedes usar if producto not in inventario:.
# Escribe tu función y pruébala con al menos dos de los ejemplos.

inventario = {'raton': 10,
              'teclado': 5,
              'monitor': 0,    
              'cable': 20}

def gestionar_stock(inventario, producto, cantidad):
    
    if not inventario[f'{producto}']: 
        mensaje = "Producto no encontrado"   
    elif cantidad <= 0:
        mensaje = "Cantidad no válida"
    else:
        inventario[f'{producto}'] += cantidad
        mensaje = inventario[f'{producto}']
        
    return mensaje
        
        
        
print(gestionar_stock(inventario, 'raton', 3))