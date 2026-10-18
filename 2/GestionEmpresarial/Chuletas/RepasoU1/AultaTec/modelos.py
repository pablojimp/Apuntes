class Producto:
    def __init__(self,referencia,nombre,categoria,precio,stock):
        self.referencia = referencia
        self.nombre = nombre
        self.categoria = categoria
        self.precio = precio
        self.stock = stock
    
    def codigo(self):
        return f'REF-{self.referencia:03d}'
    
    def vender(self, cantidad):
        if cantidad <= 0 or cantidad > self.stock:
            venta = False
        else:
            self.stock -= cantidad
            venta = True
            
        return venta
    
    def reponer(self,cantidad):
        if cantidad > 0:
            self.stock += cantidad
        else:
            return None
        
class Cliente:
    def __init__(self,nombre,email,puntos_extra=0, tipo='normal'):
        self.puntos_extra = puntos_extra
        self.tipo = tipo
        self.nombre = nombre
        self.email = email
        
    def puntos_descuento(self, subtotal):
        if subtotal < 200:
            descuento = 0
        elif subtotal < 500:
            descuento = 5
        else:
            descuento = 10

        descuento += self.puntos_extra

        if descuento > 15:
            descuento = 15

        return descuento

                
                
            

    
class ClientePremium(Cliente):
    def __init__(self,nombre,email):
        super().__init__(nombre, email, 7, 'premium')
              
class LineaPedido:
    def __init__(self,producto, cantidad, precio_unitario):
        self.producto = producto
        self.cantidad = cantidad
        self.precio_unitario = precio_unitario
        
    def importe(self):
        return self.cantidad * self.precio_unitario
        
    def tipo_iva(self):
        if self.producto.categoria == 'Libros':
            iva = 4
        else:
            iva = 21
        return iva
            
class Pedido:
    def __init__(self,numero, cliente):
        self.numero = numero
        self.cliente = cliente
        self.estado = 'borrador'
        self.lineas =  []
    
    def codigo(self):
        return f'PED-{self.numero:04d}'
        
    def anadir_linea(self, producto, cantidad):
        if (self.estado != 'borrador'
                or cantidad <= 0
                or producto is None):
            return False

        for linea in self.lineas:
            if linea.producto.referencia == producto.referencia:
                linea.cantidad += cantidad
                return True

        self.lineas.append(
            LineaPedido(producto, cantidad, producto.precio)
        )
        return True     
    
    def subtotal(self):
        total = 0
        for linea in self.lineas:
            total += linea.importe()
        
        return total
    
    def descuento(self):
        subtotal_descuento = self.subtotal()
        pct = self.cliente.puntos_descuento(subtotal_descuento)
        return subtotal_descuento * pct / 100
            
    def iva(self):
        total = 0
        subtotal_descuento = self.subtotal()
        pct = self.cliente.puntos_descuento(subtotal_descuento)
        for linea in self.lineas:
            total += linea.importe() * (1 - pct / 100) * linea.tipo_iva() / 100
        
        return total
        
    
    def total(self):
        return self.subtotal() - self.descuento() + self.iva()
            
    def confirmar(self):
        if self.estado != 'borrador' or len(self.lineas) == 0:
            return None

        lineas_con_mas_cantidad_stock = []

        for linea in self.lineas:
            if linea.cantidad > linea.producto.stock:
                lineas_con_mas_cantidad_stock.append(
                    linea.producto.nombre
                )

        if len(lineas_con_mas_cantidad_stock) > 0:
            return lineas_con_mas_cantidad_stock

        for linea in self.lineas:
            linea.producto.vender(linea.cantidad)

        self.estado = 'confirmado'
        return []
    
    def cancelar(self):
        if self.estado == 'cancelado':
            confirmacion = False
        elif self.estado == 'borrador':
            self.estado = 'cancelado'
            confirmacion = True
        elif self.estado == 'confirmado':
            for linea in self.lineas:
                linea.producto.reponer(linea.cantidad)
            
            self.estado = 'cancelado'
            confirmacion = True
            
        return confirmacion
            
            
            
        
    
