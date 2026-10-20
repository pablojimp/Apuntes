"""Clases de dominio: colección de cartas Pokémon. Sin print() ni input()."""


class Carta:
    def __init__(self, codigo, nombre, tipo, rareza, valor):
        self.codigo = codigo
        self.nombre = nombre
        self.tipo = tipo
        self.rareza = rareza
        self.valor = valor

    def __str__(self):
        return f"{self.codigo:<5} {self.nombre:<12} {self.tipo:<10} {self.rareza:<8} {self.valor:>7.2f} €"


class Coleccion:
    def __init__(self, cartas=None):
        self.cartas = {}  # diccionario por código
        for c in (cartas or []):
            self.cartas[c.codigo] = c

    def anadir(self, carta):
        codigo = carta.codigo.strip().upper()
        if not codigo:
            return False, "El código no puede estar vacío."
        if codigo in self.cartas:
            return False, "Ya existe una carta con ese código."
        if carta.valor < 0:
            return False, "El valor no puede ser negativo."
        if not carta.nombre.strip():
            return False, "El nombre no puede estar vacío."
        carta.codigo = codigo
        self.cartas[codigo] = carta
        return True, "Carta añadida."

    def eliminar(self, codigo):
        if self.cartas.pop(codigo.strip().upper(), None) is None:
            return False, "No existe esa carta."
        return True, "Carta eliminada."

    def listar(self):
        return list(self.cartas.values())

    def buscar(self, texto):
        """Búsqueda por nombre o tipo, sin distinguir mayúsculas/minúsculas."""
        t = texto.strip().lower()
        return [c for c in self.cartas.values() if t in c.nombre.lower() or t in c.tipo.lower()]

    def filtrar_rareza(self, rareza):
        r = rareza.strip().lower()
        return [c for c in self.cartas.values() if c.rareza.lower() == r]

    def intercambiar(self, codigo_antiguo, nueva):
        """Atómico: primero valida TODO; solo entonces elimina e incorpora."""
        antiguo = codigo_antiguo.strip().upper()
        nuevo = nueva.codigo.strip().upper()
        if antiguo not in self.cartas:
            return False, "La carta a intercambiar no existe."
        if not nuevo:
            return False, "El código nuevo no puede estar vacío."
        if nuevo in self.cartas:
            return False, "El código nuevo ya está ocupado."
        if nueva.valor < 0 or not nueva.nombre.strip():
            return False, "Datos de la carta nueva no válidos."
        nueva.codigo = nuevo
        del self.cartas[antiguo]
        self.cartas[nuevo] = nueva
        return True, "Intercambio realizado."

    def valor_total(self):
        return round(sum(c.valor for c in self.cartas.values()), 2)

    def total_cartas(self):
        return len(self.cartas)

    def por_rareza(self):
        cuenta = {}
        for c in self.cartas.values():
            cuenta[c.rareza] = cuenta.get(c.rareza, 0) + 1
        return cuenta

    def top(self, n=3):
        return sorted(self.cartas.values(), key=lambda c: c.valor, reverse=True)[:n]