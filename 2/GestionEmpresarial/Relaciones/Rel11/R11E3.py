# Relación 11 - Ejercicio 03: Gestor de pedidos (programa principal)
# Regla: todas las impresiones se hacen únicamente desde main().
from modelos import Producto, Pedido


def convertir_cantidad(texto):
    """Devuelve una cantidad positiva o None si el dato es inválido."""
    try:
        cantidad = int(texto)
    except ValueError:
        return None
    return cantidad if cantidad > 0 else None


def convertir_indice(texto, total_productos):
    """Devuelve el índice de producto (empezando en 0) o None."""
    try:
        indice = int(texto) - 1
    except ValueError:
        return None
    return indice if 0 <= indice < total_productos else None


def listar_productos(productos):
    """Devuelve el listado de productos como líneas de texto."""
    return [
        f"{numero}. {producto.nombre} | {producto.precio:.2f} EUR | Stock: {producto.stock}"
        for numero, producto in enumerate(productos, start=1)
    ]


def anadir_linea(pedido, productos, indice, cantidad):
    """Intenta añadir una línea y devuelve True si hay stock suficiente."""
    return pedido.agregar_linea(productos[indice], cantidad)


def mostrar_pedido(pedido):
    """Devuelve un listado de líneas; la impresión se hace en main()."""
    if not pedido.lineas:
        lineas = ["El pedido está vacío."]
    else:
        lineas = [f"Pedido de {pedido.cliente}:"]
        for linea in pedido.lineas:
            lineas.append(
                f"{linea.producto.nombre} | {linea.cantidad} x "
                f"{linea.producto.precio:.2f} = {linea.subtotal():.2f} EUR"
            )
    lineas.append(f"Total: {pedido.total():.2f} EUR")
    return lineas


def main():
    productos = [
        Producto("Teclado", 25.50, 8),
        Producto("Ratón", 12.75, 5),
        Producto("Monitor", 149.99, 2),
    ]
    cliente = input("Nombre del cliente: ").strip()
    pedido = Pedido(cliente)
    opcion = ""

    while opcion != "0":
        print("\n1) Ver productos y stock")
        print("2) Añadir línea al pedido")
        print("3) Listar detalle del pedido")
        print("4) Calcular total")
        print("0) Salir")
        opcion = input("Opción: ").strip()

        if opcion == "1":
            for linea in listar_productos(productos):
                print(linea)

        elif opcion == "2":
            for linea in listar_productos(productos):
                print(linea)
            indice = convertir_indice(input("Número de producto: "), len(productos))
            if indice is None:
                print("Producto no válido.")
            else:
                cantidad = None
                while cantidad is None:
                    cantidad = convertir_cantidad(input("Cantidad: "))
                    if cantidad is None:
                        print("Introduce una cantidad entera mayor que cero.")
                if anadir_linea(pedido, productos, indice, cantidad):
                    print("Línea añadida al pedido.")
                else:
                    print("No hay stock suficiente. No se ha añadido la línea.")

        elif opcion == "3":
            for linea in mostrar_pedido(pedido):
                print(linea)

        elif opcion == "4":
            print(f"Total: {pedido.total():.2f} EUR")

        elif opcion != "0":
            print("Opción no válida.")


if __name__ == "__main__":
    main()
