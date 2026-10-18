

def procesar_precios(precios):
    precios_procesados = []
    for precio in precios:
        if precio >= 30:
            precios_procesados.append(precio - (precio * (10 / 100)))
    
    
    return precios_procesados
    
    
precios = [12.5, 80, 150, 9.99, 45, 200, 32.5, 5]