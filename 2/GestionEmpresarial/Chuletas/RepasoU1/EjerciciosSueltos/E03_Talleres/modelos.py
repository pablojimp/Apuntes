"""Clases de dominio: centro de talleres. Sin print() ni input()."""


class Participante:
    def __init__(self, email, nombre):
        self.email = email
        self.nombre = nombre


class Taller:
    def __init__(self, codigo, titulo, plazas):
        self.codigo = codigo
        self.titulo = titulo
        self.plazas = plazas


class Inscripcion:
    def __init__(self, email_participante, codigo_taller):
        self.email_participante = email_participante
        self.codigo_taller = codigo_taller


class CentroTalleres:
    """Gestiona participantes, talleres e inscripciones (relacionados por email y código)."""

    def __init__(self):
        self.participantes = {}
        self.talleres = {}
        self.inscripciones = []

    # --- altas ---
    def alta_taller(self, codigo, titulo, plazas):
        codigo = codigo.strip().upper()
        if not codigo or not titulo.strip():
            return False, "Código y título no pueden estar vacíos."
        if codigo in self.talleres:
            return False, "Ya existe un taller con ese código."
        if plazas <= 0:
            return False, "Las plazas deben ser mayores que cero."
        self.talleres[codigo] = Taller(codigo, titulo.strip(), plazas)
        return True, "Taller creado."

    def alta_participante(self, email, nombre):
        email = email.strip().lower()
        if "@" not in email or not nombre.strip():
            return False, "Email (con @) y nombre son obligatorios."
        if email in self.participantes:
            return False, "Ese email ya está registrado."
        self.participantes[email] = Participante(email, nombre.strip())
        return True, "Participante dado de alta."

    # --- inscripciones ---
    def _existe(self, email, codigo):
        return any(i.email_participante == email and i.codigo_taller == codigo
                   for i in self.inscripciones)

    def inscribir(self, email, codigo):
        email, codigo = email.strip().lower(), codigo.strip().upper()
        if email not in self.participantes:
            return False, "Participante inexistente."
        if codigo not in self.talleres:
            return False, "Taller inexistente."
        if self._existe(email, codigo):
            return False, "Ya está inscrito en ese taller."
        if self.plazas_libres(codigo) <= 0:
            return False, "El taller está completo."
        self.inscripciones.append(Inscripcion(email, codigo))
        return True, "Inscripción realizada."

    def cancelar(self, email, codigo):
        email, codigo = email.strip().lower(), codigo.strip().upper()
        for i, ins in enumerate(self.inscripciones):
            if ins.email_participante == email and ins.codigo_taller == codigo:
                del self.inscripciones[i]
                return True, "Inscripción cancelada."
        return False, "Esa inscripción no existe."

    # --- consultas ---
    def inscritos(self, codigo):
        codigo = codigo.strip().upper()
        return [self.participantes[i.email_participante]
                for i in self.inscripciones if i.codigo_taller == codigo]

    def plazas_libres(self, codigo):
        t = self.talleres[codigo]
        return t.plazas - sum(1 for i in self.inscripciones if i.codigo_taller == codigo)

    def ocupacion(self, codigo):
        t = self.talleres[codigo]
        return round((t.plazas - self.plazas_libres(codigo)) / t.plazas * 100, 1)

    def buscar_participantes(self, fragmento):
        f = fragmento.strip().lower()
        return [p for p in self.participantes.values() if f in p.nombre.lower()]

    def talleres_de(self, email):
        email = email.strip().lower()
        return [self.talleres[i.codigo_taller] for i in self.inscripciones
                if i.email_participante == email]

    def ranking(self):
        """Talleres ordenados por porcentaje de ocupación (descendente)."""
        return sorted(((t, self.ocupacion(t.codigo)) for t in self.talleres.values()),
                      key=lambda par: par[1], reverse=True)