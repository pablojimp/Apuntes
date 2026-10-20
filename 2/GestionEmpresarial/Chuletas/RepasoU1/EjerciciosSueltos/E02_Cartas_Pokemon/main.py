"""Punto de entrada. Completa el ejercicio siguiendo el PDF."""


from pathlib import Path
import modelos
import persistencia
def menu(mesaje_mostrar):
    print(mesaje_mostrar)
    opcion = input('Opción: ').strip()
    return opcion

def mostrar_datos(datos):
    for objeto in datos.diccionario_cartas:
        print(objeto)
        
def buscar_carta_numero(datos,codigo):
    existe = False
    for carta in datos.diccionario_cartas:
        if carta.codigo == codigo:
            existe = True
    return existe

    
    
def aniadir_carta(datos):
    mensaje = ""

    numero = input(f"Introduce el codigo de la nueva carta ({CODIGO_CARTAS:02d}): ")
    existe = buscar_carta_numero(datos, numero)

    if existe:
        mensaje = "La carta ya existe"
    else:
        nombre = input("Introduce el nombre de la nueva carta: ")
        tipo = input(f"Introduce el tipo de {nombre}: ")
        rareza = input(f"Introduce la rareza de {nombre}: ")

        try:
            valor = int(input("Introduce el valor de la carta: "))
            carta = modelos.Carta(numero, nombre, tipo, rareza, valor)
            datos.diccionario_cartas.append(carta)
            mensaje = "Carta añadida correctamente"

        except ValueError:
            mensaje = "El valor debe ser un número entero"

    return mensaje

CODIGO_CARTAS = "PK"    
MENSAJE_MENU = "1) Listar \n2) Añadir \n3) Eliminar \n4) Buscar/filtrar \n5) Intercambiar \n6) Estadísticas \n7) Guardar \n0) Salir."
ruta = Path(__file__).with_name('cartas.csv')
def main():
    ejecutar = True
    datos_inciales = persistencia.cargar_csv_productos(ruta)
    datos = datos_inciales
    while ejecutar:
        opcion_usuario = menu(MENSAJE_MENU)
        if opcion_usuario == "1":
            mostrar_datos(datos)
        if opcion_usuario == "2":
            print(aniadir_carta(datos))

if __name__ == "__main__":
    main()
