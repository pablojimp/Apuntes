# Crea una aplicación de consola con un menú: 1) listar productos, 2) añadir
# producto, 3) modificar stock, 4) buscar por nombre, 5) guardar en CSV, 0) salir.
# Representa los productos con diccionarios dentro de una lista. Divide el programa
# en funciones. Valida las entradas numéricas con try/except.

# Comprobación

# El menú debe repetirse con una condición explícita hasta elegir 0. Al guardar,
# el CSV debe incluir todos los productos actuales.

import csv

def main():
    ejecutar = True
    while ejecutar:
        opcion = pedir_opcion()
        if opcion == "0":
            ejecutar = False
        elif opcion == "1":
            listar_productos()       
        elif opcion == "2":
            aniadir_producto()
        elif opcion == "3":
            modificar_stock(input("Introduce el nombre del producto: "), int(input("Introduce el nuevo numero de stock")))
        elif opcion == "4":
            buscar_nombre(input("Introduce el nombre del producto: "))
            
def buscar_nombre(nombre):
    # Leer todas las filas
    with open('productos.csv', mode='r', newline='', encoding='utf-8') as archivo_csv:
        lector_dict = csv.DictReader(archivo_csv)
        for fila in lector_dict:
            if nombre == fila["nombre"]:
                print(fila)

            
        
def pedir_opcion():
    opcion_menu = input("\n 1) Listar productos \n 2) Añadir producto \n 3) Modificar stock \n 4) Buscar por nombre \n 5) Guardar en CSV \n 0) Salir.\n Introducir opcion: ")
    return opcion_menu
    
def listar_productos():
    with open("productos.csv", "r", newline="", encoding="utf-8") as fila_mostrar:
        for fila in csv.DictReader(fila_mostrar):
            print(fila)
 
def modificar_stock(nombre, nuevo_stock):
    textos = []

    # Leer todas las filas
    with open('productos.csv', mode='r', newline='', encoding='utf-8') as archivo_csv:
        lector_dict = csv.DictReader(archivo_csv)

        for fila in lector_dict:
            if nombre == fila["nombre"]:
                fila["stock"] = nuevo_stock

            textos.append(fila)

    # Escribir todas las filas actualizadas
    with open("productos.csv", "w", newline="", encoding="utf-8") as fila_escribir:
        escritor = csv.DictWriter(
            fila_escribir,
            fieldnames=["nombre", "precio", "stock"]
        )
        escritor.writeheader()
        escritor.writerows(textos)
                           
def aniadir_producto():
    textos = []
    
    # Leo todas las filas y las guardo en una variable
    with open('productos.csv', mode='r', newline='', encoding='utf-8') as archivo_csv:
        lector_dict = csv.DictReader(archivo_csv)
        for fila in lector_dict:
            textos.append(fila) 
            
            
    # Añado la nueva linea
    textos.append({"nombre": input("Introduce el nombre del producto: "), 
                             "precio": int(input("Introduce el precio del producto: ")),
                             "stock": int(input("Introduce el stock del producto: "))})
            
    # Reescribo el archivo productos.csv con la nueva linea 
    with open("productos.csv", "w", newline="", encoding="utf-8") as fila_escribir:
                escritor = csv.DictWriter(fila_escribir, fieldnames=["nombre", "precio", "stock"])
                escritor.writeheader()
                escritor.writerows(textos)

main()