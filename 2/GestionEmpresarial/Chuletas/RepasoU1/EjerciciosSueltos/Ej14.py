





def leer_entero(texto):
    try:
        numero = int(texto)
    except ValueError:
        numero = None
        
    return numero
        
def dividir(a, b):
    try:
        numero = a / b
    except ZeroDivisionError:
        numero = "No se puede dividir entre cero"
    
    return numero
    

print(leer_entero("25"))       # 25
print(leer_entero("hola"))     # None
print(dividir(10, 2))           # 5.0
print(dividir(10, 0))           # No se puede dividir entre cero
