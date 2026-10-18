
def sumar(a, b):
    try:
        a = float(a)
        b = float(b)
        solucion = a + b
    except ValueError:
        solucion = "Debes introducir números válidos"
        
    return solucion
    
    
    
def restar(a, b):
    try:
        a = float(a)
        b = float(b)
        solucion = a - b
    except ValueError:
        solucion = "Debes introducir números válidos"
        
    return solucion
    
    
    
def multiplicar(a, b):
    try:
        a = float(a)
        b = float(b)
        solucion = a * b
    except ValueError:
        solucion = "Debes introducir números válidos"
        
    return solucion
    



# TODO Version Examen

# def sumar(a, b):
#     try:
#         a = float(input("Primer número: "))
#         b = float(input("Segundo número: "))
#         solucion = a + b
#     except ValueError:
#         solucion = "Debes introducir números válidos"
        
#     return solucion
    
    
    
# def restar(a, b):
#     try:
#         a = float(input("Primer número: "))
#         b = float(input("Segundo número: "))
#         solucion = a - b
#     except ValueError:
#         solucion = "Debes introducir números válidos"
        
#     return solucion
    
    
    
# def multiplicar(a, b):
#     try:
#         a = float(input("Primer número: "))
#         b = float(input("Segundo número: "))
#         solucion = a * b
#     except ValueError:
#         solucion = "Debes introducir números válidos"
        
#     return solucion
    
