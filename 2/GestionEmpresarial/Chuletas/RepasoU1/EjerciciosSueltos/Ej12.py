

class Motor:
    def __init__(self,potencia):
        self.potencia = potencia
    
    def mostrar_info(self):
        return f'Motor de {self.potencia} CV'
        

class Coche:
    def __init__(self,marca,motor):
        self.marca = marca
        self.motor = motor
        
    def mostrar_info(self):
        return f'{self.marca} - Motor de {self.motor.potencia} CV'
        
        
        

motor = Motor(120)
coche = Coche('Toyota', motor)
print(motor.mostrar_info())
print(coche.mostrar_info())
    