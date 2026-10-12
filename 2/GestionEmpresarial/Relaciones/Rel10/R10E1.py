
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
            return (f"{self.nombre} -> {self.salario}, ({self.ventas})")
        


class LineaPedido:
    def __init__(self, producto, precio, cantidad):
        self.producto = producto
        self.precio = precio
        self.cantidad = cantidad
        
    def subtotal(self):
        return self.cantidad * self.precio
    
    
class Pedido:
    def __init__(self,cliente,lista_lineas):
        self.cliente = cliente
        self.lista_lineas = lista_lineas
        
    def agregar_linea(self,linea):
        self.lista_lineas.append(linea)
        
    def total(self):
        total = 0
        for linea in self.lista_lineas:
            total += linea.subtotal()
        return total
            
        
pedido = Pedido("Ana", [])
pedido.agregar_linea(LineaPedido("Teclado", 25.0, 2))
pedido.agregar_linea(LineaPedido("Ratón", 10.0, 1))
print(pedido.total())
        
