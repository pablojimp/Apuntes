
class Producto:
    def __init__(self, nombre, precio, stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock
        
    def mostrar(self):
        print(f"Nombre: {self.nombre}, {self.precio:.2f}€, {self.stock} Unidades")
        
    def vender(self,cantidad):
        vendido = False
        if self.stock >= cantidad:
            self.stock = self.stock-cantidad
            vendido = True
        return vendido

        
    def reponer(self,cantidad):
        self.stock += cantidad
    