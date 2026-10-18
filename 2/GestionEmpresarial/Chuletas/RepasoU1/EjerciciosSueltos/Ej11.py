
class Empleado:
    def __init__(self,nombre,salario):
        self.nombre = nombre
        self.salario = salario
    
    def mostrar_info(self):
        return f'{self.nombre} - Salario: {self.salario}€'
        
        
class Gerente(Empleado):
    def __init__(self,nombre,salario,departamento):
        super().__init__(nombre,salario)
        self.departamento = departamento
        
    def mostrar_info(self):
        return f'{self.nombre} - Salario: {self.salario}€ - Departamento: {self.departamento}'
        
empleado = Empleado('Luis', 1800)
gerente = Gerente('Ana', 2500, 'Ventas')
print(empleado.mostrar_info())
print(gerente.mostrar_info())



# Resultado esperado:
# Luis - Salario: 1800€
# Ana - Salario: 2500€ - Departamento: Ventas


