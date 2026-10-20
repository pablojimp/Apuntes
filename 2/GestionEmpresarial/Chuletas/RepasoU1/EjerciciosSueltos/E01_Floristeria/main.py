"""Punto de entrada. Completa el ejercicio siguiendo el PDF."""
import csv

import persistencia
from pathlib import Path
import modelos


# -----------------------------------------
# -------------- funciones ----------------
# -----------------------------------------

def menu(mesaje_mostrar):
    print(mesaje_mostrar)
    opcion = input('Opción: ').strip()
    return opcion


def cargar_datos(ruta):
    return persistencia.cargar_csv_productos(ruta, CSV_CABECERAS_PRODUCTOS)


def cargar_datos_ventas(ruta):
    return persistencia.cargar_csv_ventas(ruta)


def mostrar_lista(lista):
    for objeto in lista:
        print(objeto)


def mostrar_diccionario(lista):
    for objeto in lista:
        # Comillas dobles por fuera: dentro del f-string usamos comillas simples
        print(f"Venta: {objeto['numero']} - Cliente {objeto['cliente']} - Producto {objeto['codigo_producto']} - {objeto['cantidad']}U - {objeto['precio_unitario']}€/U")


def buscar_objeto_codigo(datos, codigo):
    for objeto in datos:
        if objeto.codigo == codigo:
            return objeto
    return None


def generar_venta(datos, linea_venta):
    codigo = input(f'Introduce el codigo del objeto "{CODIGO_FLORES}..." : ').strip().upper()
    objeto = buscar_objeto_codigo(datos, codigo)
    if objeto is not None:
        try:
            cantidad = int(input(f'Introduce cuanta cantidad de {objeto.nombre} quieres : '))
            if cantidad > 0:
                linea_venta.append(modelos.LineaVenta(objeto, cantidad, objeto.precio))
                print("Línea añadida")
            else:
                print("La cantidad tiene que ser mayor que 0")
        except ValueError:
            print("Cantidad no válida")
    else:
        print("No hemos encontrado el objeto")

    return linea_venta


def cerrar_venta(datos, linea_venta, ventas_lista):
    # Si no hay líneas, devolvemos None (antes 'venta' no existía y petaba el return)
    if len(linea_venta) == 0:
        print("Ve a la opcion 4 y crea una Linea de Venta")
        return None

    nombre = input("Introduce el nombre del cliente: ")
    # int(...) porque en el CSV el número viene como texto
    numero = int(ventas_lista[-1]['numero']) + 1 if ventas_lista else 1
    venta = modelos.Venta(numero, nombre)

    for linea in linea_venta:
        objeto = buscar_objeto_codigo(datos, linea.producto.codigo)
        if objeto is not None:
            if linea.cantidad <= linea.producto.stock:
                linea.producto.stock -= linea.cantidad
                venta.lineas.append(linea)
                print(f'El producto: {linea.producto.nombre}, se ha vendido con exito ahora tiene {linea.producto.stock} unidades. Se realiza la venta')
            else:
                print(f'El producto: {linea.producto.nombre}, solo tiene {linea.producto.stock} unidades, has pedido {linea.cantidad}. No se realiza la venta')

    return venta


def guardar_venta(ventas, ruta):
    if len(ventas) > 0:
        # newline='' evita líneas en blanco extra en Windows
        with open(ruta, 'w', encoding='utf-8', newline='') as archivo:
            escritor = csv.DictWriter(archivo, fieldnames=CSV_CABECERAS_VENTAS)
            escritor.writeheader()       # primera fila con los nombres
            escritor.writerows(ventas)   # una fila por cada diccionario
        print("Ventas guardadas")


def reponer_producto(datos):
    codigo = input(f'Introduce el codigo del objeto "{CODIGO_FLORES}..." : ').strip().upper()
    objeto = buscar_objeto_codigo(datos, codigo)
    repuesta = None
    if objeto is not None:
        try:
            elementos_aniadir = int(input(f'Introduce cuanto quieres reponer para {objeto.nombre}: '))
            objeto.reponer(elementos_aniadir)
            repuesta = True
        except ValueError:
            repuesta = False
    return repuesta


def alta_producto(datos):
    # len(CODIGO_FLORES) en vez de un 3 fijo; y si no hay productos, empezamos en 1
    numero = int(datos[-1].codigo[len(CODIGO_FLORES):]) + 1 if datos else 1
    nuevo_codigo = f"{CODIGO_FLORES}{numero:02d}"
    nombre = input("Introduce el nombre del nuevo producto: ")
    categoria = input(f'Introduce la categoria de {nombre}: ')
    try:
        precio = float(input("Introduce el precio: "))
        while precio <= 0:
            precio = float(input("Introduce el precio (Mayor de 0): "))
        stock = int(input("Introduce el stock: "))
        while stock <= 0:
            stock = int(input("Introduce el stock (Mayor de 0): "))
        respuesta = modelos.Producto(nuevo_codigo, nombre, categoria, precio, stock)
    except ValueError:
        respuesta = None

    return respuesta


CODIGO_FLORES = "FLO"
CSV_CABECERAS_PRODUCTOS = ["codigo", "nombre", "categoria", "precio", "stock"]
CSV_CABECERAS_VENTAS = ["numero", "cliente", "codigo_producto", "cantidad", "precio_unitario"]
ruta_productos = Path(__file__).with_name('productos.csv')   # junto al .py
ruta_ventas = Path(__file__).with_name('ventas.csv')

MENSAJE_MENU = '\n1) Ver productos \n2) Alta \n3) Reponer \n4) Nueva venta / añadir líneas \n5) Cerrar venta \n6) Consultar ventas \n7) Guardar \n0) Salir'


def main():
    ejecutar = True
    # Se cargan UNA sola vez, antes del bucle
    datos = cargar_datos(ruta_productos)
    ventas = cargar_datos_ventas(ruta_ventas)
    linea_venta = []

    while ejecutar:
        opcion_usuario = menu(MENSAJE_MENU)

        if opcion_usuario == "1":
            mostrar_lista(datos)

        elif opcion_usuario == "2":
            objeto = alta_producto(datos)
            if objeto is not None:
                datos.append(objeto)
                print("Objeto dado de alta")
            else:
                print("No hemos podido registrar el objeto, revisa los campos...")

        elif opcion_usuario == "3":
            respuesta = reponer_producto(datos)
            if respuesta:
                print("Se han añadido al stock")
            elif respuesta is None:
                print("No hemos encontrado el objeto")
            else:
                print("No hemos podido reponer el objeto. Revisa cuanto querias introducir...")

        elif opcion_usuario == "4":
            generar_venta(datos, linea_venta)

        elif opcion_usuario == "5":
            venta_actual = cerrar_venta(datos, linea_venta, ventas)

            if venta_actual is not None:
                for linea in venta_actual.lineas:
                    ventas.append({
                        'numero': venta_actual.numero,
                        'cliente': venta_actual.cliente,
                        'codigo_producto': linea.producto.codigo,
                        'cantidad': linea.cantidad,
                        'precio_unitario': linea.precio_unitario
                    })
                # Vaciamos las líneas: si no, la siguiente venta repetiría las anteriores
                linea_venta.clear()

        elif opcion_usuario == "6":
            mostrar_diccionario(ventas)

        elif opcion_usuario == "7":
            guardar_venta(ventas, ruta_ventas)

        elif opcion_usuario == "0":
            ejecutar = False

        else:
            print("Introduce opciones validas")


if __name__ == "__main__":
    main()