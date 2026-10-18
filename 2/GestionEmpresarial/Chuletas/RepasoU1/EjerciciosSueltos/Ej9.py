

class Producto:
    def __init__(self, nombre, precio, stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock
        
    def mostrar_info(self):
        return f'{self.nombre} - Precio: {self.precio}€ - Stock: {self.stock}'
        
    def vender(self,cantidad):
        if cantidad <= 0:
            return False
        elif self.stock < cantidad:
            return False
        else:
            self.stock -= cantidad
            return True 

        

producto = Producto('Ratón', 15.5, 10)
print(producto.mostrar_info())
print(producto.vender(3))
print(producto.stock)
print(producto.vender(20))
print(producto.vender(0))





