
ventas = [    
          {'producto': 'Teclado', 'cantidad': 3, 'precio': 25.0},
          {'producto': 'Ratón', 'cantidad': 5, 'precio': 15.0},
          {'producto': 'Monitor', 'cantidad': 2, 'precio': 150.0},
          {'producto': 'Webcam', 'cantidad': 0, 'precio': 40.0}
          ]

def analizar_ventas(ventas):
    if not ventas:
        return None
    ventas_analisis = {}
    nombre_producto = ''
    total = 0
    articulo_mas_caro = 0
    articulos_sin_ventas = []
    for producto in ventas:
        total += producto['cantidad'] * producto['precio']
        
        if producto['cantidad'] > articulo_mas_caro:
            articulo_mas_caro = producto['cantidad'] 
            nombre_producto = producto['producto']
    
        if producto['cantidad'] == 0:
            articulos_sin_ventas.append(producto['producto'])
            
        
        
    ventas_analisis['total'] = total
    ventas_analisis['producto_mas_vendido'] = nombre_producto
    ventas_analisis['productos_sin_ventas'] = articulos_sin_ventas
    
    return ventas_analisis


# La función debe devolver un diccionario con:
# - total: suma de todas las ventas, calculadas como cantidad * precio.
# - producto_mas_vendido: nombre del producto con mayor cantidad vendida.
# - productos_sin_ventas: lista de nombres de productos cuya cantidad sea 0.
# Para estos datos, el resultado esperado es equivalente a:
# {    'total': 450.0,    
# 'producto_mas_vendido': 'Ratón',    
# 'productos_sin_ventas': ['Webcam']}

print(analizar_ventas(ventas))


# Si la lista está vacía, devuelve None.
# Pistas:
# - Recorre la lista con for venta in ventas:.
# - Accede a los valores mediante claves: venta['cantidad'], venta['precio'] y venta['producto'].
# - Utiliza una variable para acumular el total.
# - Utiliza otra variable para recordar la cantidad máxima.
# - No necesitas clases ni archivos en este ejercicio.
# Inténtalo tú primero. Envíame tu código y revisaremos la lógica antes del último ejercicio integrador.
