"""Clases de dominio: impleméntalas siguiendo el enunciado."""

# TODO: define las clases necesarias aquí.
class Producto:
    def __init__(self,codigo, nombre, categoria, precio, stock):
        self.codigo = codigo
        self.nombre = nombre
        self.categoria = categoria
        self.precio = precio
        self.stock = stock
        
    def reponer(self,cantidad):
        self.stock += cantidad
        
    def __str__(self):
        return f' ID: {self.codigo} - {self.nombre} - Categoria: {self.categoria} - {self.precio}€ - {self.stock} Unidades'
    
class LineaVenta:
    def __init__(self,producto, cantidad,precio_unitario):
        self.producto = producto
        self.cantidad = cantidad
        self.precio_unitario = precio_unitario
        
    def __str__(self):
        return f'Nombre: {self.producto.nombre} - {self.cantidad} - {self.precio_unitario}€/U'
        
class Venta:
    def __init__(self,numero, cliente):
        self.numero = numero
        self.cliente = cliente
        self.lineas = []
        
    def __str__(self):
        return f'{self.numero};{self.cliente};{self.lineas}'