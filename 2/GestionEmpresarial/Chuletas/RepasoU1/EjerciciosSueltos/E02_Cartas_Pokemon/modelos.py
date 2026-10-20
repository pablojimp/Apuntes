"""Clases de dominio: impleméntalas siguiendo el enunciado."""

# TODO: define las clases necesarias aquí.
class Carta:
    def __init__(self,codigo, nombre, tipo, rareza, valor):
        self.codigo = codigo
        self.nombre = nombre
        self.tipo = tipo
        self.rareza = rareza
        self.valor = valor
    def __str__(self):
        return f'Codigo: {self.codigo} - {self.nombre} - Tipo: {self.tipo} - {self.rareza} - {self.valor}€'

        
class Coleccion:
    def __init__(self, diccionario_cartas=None):
        if diccionario_cartas is None:
            diccionario_cartas = []
        self.diccionario_cartas = diccionario_cartas
        
