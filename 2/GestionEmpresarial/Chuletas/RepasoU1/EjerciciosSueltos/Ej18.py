
def main():
    ejecutar = True
    opcion = ''
    while ejecutar:
        print('\n1) Sumar\n2) Restar\n3) Multiplicar\n4) Dividir\n0) Salir')
        opcion = input('Opción: ').strip()

        if opcion == '1':
            print(sumar())
        elif opcion == '2':
            print(restar())
        elif opcion == '3':
            print(multiplicar())
        elif opcion == '4':
            print(divir())
        elif opcion == '0':
            ejecutar = False
        else:
            print('Introduce una opcion valida')
            
            




def sumar():
     try:
         a = float(input("Primer número: "))
         b = float(input("Segundo número: "))
         solucion = a + b
     except ValueError:
         solucion = "Debes introducir números válidos"
        
     return solucion
    
    
    
def restar():
     try:
         a = float(input("Primer número: "))
         b = float(input("Segundo número: "))
         solucion = a - b
     except ValueError:
         solucion = "Debes introducir números válidos"
        
     return solucion
    
    
    
def multiplicar():
     try:
         a = float(input("Primer número: "))
         b = float(input("Segundo número: "))
         solucion = a * b
     except ValueError:
         solucion = "Debes introducir números válidos"
        
     return solucion


def divir():
     try:
        a = float(input("Primer número: "))
        b = float(input("Segundo número: "))
        if b != 0:
            solucion = a / b
        else:
            solucion = " El segundo numero debe ser mayor a 0"

            
     except ValueError:
         solucion = "Debes introducir números válidos"
        
     return solucion

main()