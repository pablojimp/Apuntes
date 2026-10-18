# Crea un programa para gestionar el inventario de una tienda.

class Producto:
    def __init__(self,nombre,precio,stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock
        
    def vender(self, cantidad):
        vendido = False
        if cantidad > 0 and self.stock >= cantidad:
            self.stock -= cantidad
            vendido = True
            
        return vendido
                     
    def reponer(self, cantidad):
        repuesto = False
        if cantidad > 0:
             self.stock += cantidad
             repuesto = True
        return repuesto
    
    def mostrar_info(self):
        return f'{self.nombre} - {self.precio}€ - Stock: {self.stock}'


def buscar_producto(productos, nombre):
    resultado = None 
    for producto in productos:
        if nombre == producto.nombre:
            resultado = producto
       
    return resultado


def productos_agotados(productos):
    agotados = []
    for producto in productos:
        if producto.stock <= 0:
            agotados.append(producto.nombre)
    
    return agotados

def menu():
    print('\n1. Mostrar productos\n2) Vender producto\n3) Reponer producto\n4) Mostrar productos agotados\n0) Salir')
    opcion = input('Opción: ').strip()
    return opcion



def main():
    ejecutar = True
    inventario = [
    Producto('Teclado', 25.99, 10),
    Producto('Raton', 15.50, 0),
    Producto('Monitor', 149.99, 5)]
    while ejecutar:
        opcion = menu()
        if opcion == "1":
            for producto in inventario:
                print(producto.mostrar_info())      
        elif opcion == "2":
            nombre_busqueda = input("Introduce el nombre del objeto que deseas: ").strip()
            producto = buscar_producto(inventario,nombre_busqueda)
            if producto != None:
                try: 
                    cantidad_vender = int(input('Introduce cuanto te quieres llevar: '))
                    if producto.vender(cantidad_vender):
                        print("Venta Confirmada")
                    else:
                        print("Error en la venta, revisa si hay stock...")
                except ValueError:
                    print("Solo se pueden poner numeros enteros")
            else:
                print("No hemos encontrado el producto")
                    
        elif opcion == "3":
            nombre_busqueda = input("Introduce el nombre del objeto que deseas: ").strip()
            producto = buscar_producto(inventario,nombre_busqueda)
            if producto != None:
                try: 
                    cantidad_reponer = int(input('Introduce cuanto quieres reponer: '))
                    if producto.reponer(cantidad_reponer):
                       print("Repuesta Confirmada")
                    else:
                        print("Error en la Repuesta, revisa la cantidad introducida...")
                except ValueError:
                    print("Solo se pueden poner numeros enteros")
            else:
                print("No hemos encontrado el producto")
                    
        elif opcion == "4":
            print(productos_agotados(inventario))      
        elif opcion == "0":
            ejecutar = False
            
          
    
# - Si el usuario vende o repone, solicita el nombre y la cantidad.
# - Controla cantidades no numéricas con ValueError.
# - Si el producto no existe, muestra un mensaje.
# - Si la venta no se puede realizar, informa de ello.
# - Repite el menú hasta que se elija 0.

main()