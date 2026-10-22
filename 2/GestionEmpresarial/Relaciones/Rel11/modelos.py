# Relación 11 - Ejercicio 03: Clases del gestor de pedidos
class Producto:
    def __init__(self, nombre, precio, stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock

    def vender(self, cantidad):
        if cantidad <= 0 or cantidad > self.stock:
            return False
        self.stock -= cantidad
        return True


class LineaPedido:
    def __init__(self, producto, cantidad):
        self.producto = producto
        self.cantidad = cantidad

    def subtotal(self):
        return self.producto.precio * self.cantidad


class Pedido:
    def __init__(self, cliente):
        self.cliente = cliente
        self.lineas = []

    def agregar_linea(self, producto, cantidad):
        if not producto.vender(cantidad):
            return False
        self.lineas.append(LineaPedido(producto, cantidad))
        return True

    def total(self):
        return sum(linea.subtotal() for linea in self.lineas)
