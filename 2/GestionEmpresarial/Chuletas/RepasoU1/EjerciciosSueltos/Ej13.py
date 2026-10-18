class Producto:
    def __init__(self,nombre,precio,stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock

    def vender(self, cantidad):
        if cantidad > 0 and self.stock >= cantidad:
            self.stock -= cantidad
            return True
        else:
            return False
        
    def reponer(self, cantidad):
        if cantidad > 0:
            self.stock += cantidad
            return True
        else:
            return False
        
    def mostrar_info(self):
        return f'{self.nombre} - {self.precio}€ - Stock: {self.stock}'
        

def productos_sin_stock(productos):
    productos_0_stock = []
    for producto in productos:
        if producto.stock < 0:
            productos_0_stock.append(producto)
            
    return productos_0_stock
            

    
p1 = Producto('Teclado', 25.99, 10)
p2 = Producto('Ratón', 15.50, 0)
p3 = Producto('Monitor', 149.99, 5)
productos = [p1, p2, p3]
print(p1.vender(3))  # True
print(p1.mostrar_info())
print(p2.vender(1))  # False
print(p2.reponer(4))  # True
print(productos_sin_stock(productos))  # []
