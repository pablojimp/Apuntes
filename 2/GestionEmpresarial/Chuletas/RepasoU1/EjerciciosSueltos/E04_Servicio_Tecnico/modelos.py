"""Clases de dominio: servicio técnico (herencia). Sin print() ni input()."""

ESTADOS = ["pendiente", "en curso", "finalizado"]
TARIFA_REPARACION = 25.0
TARIFA_REMOTA = 20.0


class Trabajo:
    tipo = "trabajo"

    def __init__(self, codigo, cliente, horas, estado="pendiente"):
        self.codigo = codigo
        self.cliente = cliente
        self.horas = horas
        self.estado = estado

    def calcular_importe(self):
        raise NotImplementedError

    def cambiar_estado(self, nuevo):
        """Solo permite avanzar un paso: pendiente -> en curso -> finalizado."""
        nuevo = nuevo.strip().lower()
        if nuevo not in ESTADOS:
            return False, "Estado desconocido."
        if ESTADOS.index(nuevo) != ESTADOS.index(self.estado) + 1:
            return False, f"Transición no permitida: {self.estado} -> {nuevo}."
        self.estado = nuevo
        return True, f"Estado cambiado a {nuevo}."

    def cambiar_horas(self, horas):
        if self.estado == "finalizado":
            return False, "No se puede editar un trabajo finalizado."
        if horas <= 0:
            return False, "Las horas deben ser mayores que cero."
        self.horas = horas
        return True, f"Horas actualizadas. Nuevo importe: {self.calcular_importe():.2f} €."

    def precio_pieza_csv(self):
        return 0

    def __str__(self):
        return (f"{self.codigo:<6} {self.tipo:<10} {self.cliente:<12} {self.horas:g} h "
                f"{self.estado:<10} {self.calcular_importe():>8.2f} €")


class Reparacion(Trabajo):
    tipo = "reparacion"

    def __init__(self, codigo, cliente, horas, precio_pieza=0.0, estado="pendiente"):
        super().__init__(codigo, cliente, horas, estado)
        self.precio_pieza = precio_pieza

    def calcular_importe(self):
        return round(self.horas * TARIFA_REPARACION + self.precio_pieza, 2)

    def precio_pieza_csv(self):
        return f"{self.precio_pieza:g}"


class AsistenciaRemota(Trabajo):
    tipo = "remota"

    def calcular_importe(self):
        return round(self.horas * TARIFA_REMOTA, 2)


class ServicioTecnico:
    def __init__(self):
        self.trabajos = {}

    def alta(self, tipo, codigo, cliente, horas, precio_pieza=0.0):
        tipo = tipo.strip().lower()
        codigo = codigo.strip().upper()
        if tipo not in ("reparacion", "remota"):
            return False, "Tipo de trabajo desconocido."
        if not codigo:
            return False, "El código no puede estar vacío."
        if codigo in self.trabajos:
            return False, "Ya existe un trabajo con ese código."
        if not cliente.strip():
            return False, "El cliente no puede estar vacío."
        if horas <= 0:
            return False, "Las horas deben ser mayores que cero."
        if tipo == "reparacion":
            if precio_pieza < 0:
                return False, "El precio de la pieza no puede ser negativo."
            self.trabajos[codigo] = Reparacion(codigo, cliente.strip(), horas, precio_pieza)
        else:
            self.trabajos[codigo] = AsistenciaRemota(codigo, cliente.strip(), horas)
        return True, "Trabajo dado de alta."

    def cambiar_estado(self, codigo, nuevo):
        t = self.trabajos.get(codigo.strip().upper())
        if t is None:
            return False, "Trabajo inexistente."
        return t.cambiar_estado(nuevo)

    def cambiar_horas(self, codigo, horas):
        t = self.trabajos.get(codigo.strip().upper())
        if t is None:
            return False, "Trabajo inexistente."
        return t.cambiar_horas(horas)

    def buscar(self, cliente="", tipo="", estado=""):
        c, ti, es = cliente.strip().lower(), tipo.strip().lower(), estado.strip().lower()
        return [t for t in self.trabajos.values()
                if c in t.cliente.lower() and (not ti or t.tipo == ti) and (not es or t.estado == es)]

    def resumen(self):
        por_estado = {e: 0 for e in ESTADOS}
        for t in self.trabajos.values():
            por_estado[t.estado] += 1
        total = round(sum(t.calcular_importe() for t in self.trabajos.values()
                          if t.estado == "finalizado"), 2)
        return por_estado, total