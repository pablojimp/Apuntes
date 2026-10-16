import csv


def main():
    productos = cargar_csv()
    ejecutar = True
    while ejecutar:
        opcion = pedir_opcion()
        if opcion == "0":
            ejecutar = False

        elif opcion == "1":
            listar_productos(productos)

        elif opcion == "2":
            aniadir_producto(productos)

        elif opcion == "3":
            modificar_stock(productos)

        elif opcion == "4":
            nombre = input("Introduce el nombre del producto: ")
            producto = buscar_nombre(nombre, productos)
            if producto is not None:
                print(producto)
            else:
                print("Producto no encontrado.")

        elif opcion == "5":
            guardar_csv(productos)

        else:
            print("Opción no válida.")


def pedir_opcion():
    opcion_menu = input("\n 1) Listar productos \n 2) Añadir producto \n 3) Modificar stock \n 4) Buscar por nombre \n 5) Guardar en CSV \n 0) Salir.\n Introducir opcion: ")
    return opcion_menu


def pedir_entero(mensaje):
    resultado = None
    try:
        numero = int(input(mensaje))
        if numero < 0:
            print("No puede ser negativo.")
        else:
            resultado = numero
    except ValueError:
        print("Debe ser un número entero.")
    return resultado


def pedir_decimal(mensaje):
    resultado = None
    try:
        numero = float(input(mensaje))
        if numero < 0:
            print("No puede ser negativo.")
        else:
            resultado = numero
    except ValueError:
        print("Debe ser un número.")
    return resultado


def listar_productos(productos_db):
    if len(productos_db) > 0:
        for producto in productos_db:
            print(producto)
    else:
        print("No hay productos.")


def aniadir_producto(productos_db):
    nombre = input("Introduce el nombre del producto: ")
    precio = pedir_decimal("Introduce el precio del producto: ")
    if precio is not None:
        stock = pedir_entero("Introduce el stock del producto: ")
        if stock is not None:
            productos_db.append({"nombre": nombre, "precio": precio, "stock": stock})
            print("Producto añadido.")


def modificar_stock(productos_db):
    nombre = input("Introduce el nombre del producto: ")
    producto = buscar_nombre(nombre, productos_db)
    if producto is not None:
        nuevo_stock = pedir_entero("Introduce el nuevo número de stock: ")
        if nuevo_stock is not None:
            producto["stock"] = nuevo_stock
            print("Stock modificado.")
    else:
        print("Producto no encontrado.")


def buscar_nombre(nombre, productos_db):
    encontrado = None
    for producto in productos_db:
        if producto["nombre"] == nombre:
            encontrado = producto
    return encontrado


def guardar_csv(productos_db):
    with open("productos.csv", "w", newline="", encoding="utf-8") as archivo:
        escritor = csv.DictWriter(archivo, fieldnames=["nombre", "precio", "stock"])
        escritor.writeheader()
        escritor.writerows(productos_db)
    print("Productos guardados correctamente.")


def cargar_csv():
    productos_db = []
    try:
        with open("productos.csv", "r", newline="", encoding="utf-8") as archivo:
            for fila in csv.DictReader(archivo):
                productos_db.append({"nombre": fila["nombre"],"precio": float(fila["precio"]),"stock": int(fila["stock"])})
    except FileNotFoundError:
        print("Todavía no existe el archivo productos.csv.")
    return productos_db


main()