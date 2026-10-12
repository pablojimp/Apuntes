class Producto:
    def __init__(self, nombre, precio, stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock
        
    def mostrar(self):
        print(f"Nombre: {self.nombre}, {self.precio:.2f}€, {self.stock} Unidades")
        

