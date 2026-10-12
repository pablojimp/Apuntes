
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
    
    
class Cliente:
    def __init__(self, nombre, email, ciudad):
        self.nombre = nombre
        self.email = email
        self.ciudad = ciudad
        
    def cambiar_ciudad(self, nueva_ciudad):
        self.ciudad = nueva_ciudad
    
    
    def ficha(self):
        return (f"{self.nombre} -> {self.email}, ({self.ciudad})")
        

class Empleado:
    def __init__(self,nombre,salario):
        self.nombre = nombre
        self.salario = salario
   
class Comercial(Empleado):
        def __init__(self, nombre,salario,ventas):
            super().__init__(nombre,salario)
            self.ventas = ventas
            
        def calcular_bonus(self):
            return self.ventas * 0.05
            
        def resumen(self):
            return (f"{self.nombre} -> {self.email}, ({self.ciudad})")
        
c = Comercial("Ana", 1500, 20000)
print(c.resumen())