
def buscar_productos_caros(precios, minimo):
    resultado = []
    for nombre, coste in precios.items():
        if coste >= minimo:
            resultado.append(nombre)
    
    return resultado       

precios = {    
           'raton': 15.50,    
           'teclado': 25.00,    
           'monitor': 150.00,    
           'cable': 5.00,    
           'webcam': 45.00}