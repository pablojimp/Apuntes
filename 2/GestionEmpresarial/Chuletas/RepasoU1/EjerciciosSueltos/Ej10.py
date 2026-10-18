
class CuentaBancaria:
    def __init__(self,titular,saldo=0):
        self.titular = titular
        self.saldo = saldo
        
    def depositar(self,cantidad):
        if cantidad <= 0:
            return False
        else:
            self.saldo += cantidad
            return True
            
    def retirar(self,cantidad):
        if cantidad <= 0:
            return False
        elif self.saldo < cantidad:
            return False
        else:
            self.saldo -= cantidad
            return True

    def consultar_saldo(self):
        return f'Titular: {self.titular} - Saldo: {self.saldo}€'
