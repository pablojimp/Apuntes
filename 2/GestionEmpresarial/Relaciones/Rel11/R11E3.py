def main():
    productos = [Producto("Teclado", 25.0, 10), Producto("Ratón", 12.5, 5)]
    pedidos = [Pedido(1)]
    ejecutar = True
    while ejecutar:
        opcion = pedir_opcion()
        if opcion == "0":
            ejecutar = False

        elif opcion == "1":
            aniadirLinea(pedidos, productos)

        elif opcion == "2":
            mostrarPedidos(pedidos)

        elif opcion == "3":
            calcularTotal(pedidos)

        else:
            print("Opción no válida.")


def pedir_opcion():
    opcion_menu = input("\n1) Añadir líneas a un pedido \n2) Listado detalle \n3) Calcular el total \n0) Salir.\nIntroducir opcion: ")
    return opcion_menu


def aniadirLinea(pedidos_db, productos_db):
    try:
        id_pedido = int(input("Id del pedido: "))
    except ValueError:
        print("El id debe ser un número.")
        return

    pedido = busquedaPedido(id_pedido, pedidos_db)
    if pedido is None:
        print("Pedido no encontrado.")
        return

    nombre = input("Nombre del producto: ")
    producto = busquedaProducto(nombre, productos_db)
    if producto is None:
        print("Producto no encontrado.")
        return

    try:
        cantidad = int(input("Cantidad: "))
    except ValueError:
        print("La cantidad debe ser un número entero.")
        return

    if cantidad <= 0:
        print("La cantidad debe ser mayor que 0.")
    elif cantidad > producto.stock:
        print(f"No hay suficiente stock (disponible: {producto.stock}).")
    else:
        producto.stock -= cantidad
        pedido.lineas.append(LineaPedido(cantidad, producto))
        print("Línea añadida correctamente.")


def busquedaPedido(id_buscar, pedidos_db):
    for pedido in pedidos_db:
        if pedido.id == id_buscar:
            return pedido


def busquedaProducto(nombre, productos_db):
    for producto in productos_db:
        if producto.nombre == nombre:
            return producto


def mostrarPedidos(pedidos_db):
    for pedido in pedidos_db:
        print(f"Pedido {pedido.id}")
        for linea in pedido.lineas:
            print(f"   {linea.producto.nombre} x{linea.cantidad} = {linea.subtotal()}€")


def calcularTotal(pedidos_db):
    for pedido in pedidos_db:
        print(f"Pedido {pedido.id}: {pedido.total()}€")


class Producto:
    def __init__(self, nombre, precio, stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock


class LineaPedido:
    def __init__(self, cantidad, producto):
        self.cantidad = cantidad
        self.producto = producto

    def subtotal(self):
        return self.cantidad * self.producto.precio


class Pedido:
    def __init__(self, id):
        self.id = id
        self.lineas = []

    def total(self):
        total = 0
        for linea in self.lineas:
            total += linea.subtotal()
        return total


main()