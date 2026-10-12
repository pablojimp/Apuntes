    # Gestiona una lista de clientes ficticios. Cada cliente tendrá nombre, email, ciudad y
    # activo. Permite alta, listado, búsqueda por texto, desactivación y guardado/carga
    # desde un fichero CSV. Organiza cada operación en una función distinta


import csv

def main():
        clientes = []
        ejecutar = True
        while ejecutar:
            opcion = pedir_opcion()
            if opcion == "0":
                ejecutar = False
                
            elif opcion == "1":
                altaCliente(clientes)
                
            elif opcion == "2":
                mostrarClientes(clientes)
                
            elif opcion == "3":
                nombre = input("Introduce el nombre del cliente que quieres buscar: ")
                cliente = busquedaCliente(nombre, clientes)
                if cliente is not None:
                    print(cliente)
                else:
                    print("Cliente no encontrado.")
                    
            elif opcion == "4":
                
                nombre = input(" Introduce el nombre del cliente que quieres desactivar: ")
                desactivarCliente(nombre, clientes)
                
            elif opcion == "5":
                
                accion = input("¿Cargar o guardar CSV? (C/G): ").upper()

                if accion == "C":
                    clientes = cargarCsv(clientes)
                elif accion == "G":
                    guardarCsv(clientes)
                else:
                    print("Opción no válida.")
                
def cargarCsv(clientes_db):
    try:
        with open("clientes.csv", "r", newline="", encoding="utf-8") as archivo:
            lector = csv.DictReader(archivo)
            clientes_db.clear()

            for fila in lector:
                cliente = Cliente(fila["nombre"],fila["email"],fila["ciudad"],fila["activo"].lower() == "true")
                clientes_db.append(cliente)
        print("Clientes cargados correctamente.")
    except FileNotFoundError:
        print("Todavía no existe el archivo clientes.csv.")
    return clientes_db
                
def guardarCsv(clientes_db):
    with open("clientes.csv", "w", newline="", encoding="utf-8") as archivo:
        escritor = csv.DictWriter(archivo,fieldnames=["nombre", "email", "ciudad", "activo"])
        escritor.writeheader()
        for cliente in clientes_db:
            escritor.writerow({"nombre": cliente.nombre,"email": cliente.email,"ciudad": cliente.ciudad,"activo": cliente.activo})
    print("Clientes guardados correctamente.")
                
def desactivarCliente(nombre, clientes_db):
    cliente = busquedaCliente(nombre, clientes_db)
    if cliente is not None:
        cliente.activo = False
        print(cliente)
    else:
        print("Cliente no encontrado.")
                               

def mostrarClientes(clientes_db):
    if len(clientes_db) > 0:
        for cliente in clientes_db:
            print(cliente)
                    
              
def pedir_opcion():
        opcion_menu = input("\n 1) Alta persona \n 2) Listado personas \n 3) Busqueda personaje \n 4) Desactivacion cliente \n 5) Guardar / Cargar en CSV \n 0) Salir.\n Introducir opcion: ")
        return opcion_menu           

def altaCliente(clientes_db):
        nombre = input(" Introduce el nombre del nuevo cliente: ")
        email = input(" Introduce el email del nuevo cliente: ")
        ciudad = input(" Introduce la ciudad del nuevo cliente: ")
        clientes_db.append(Cliente(nombre,email,ciudad,True))
        
def busquedaCliente(nombre,clientes_db):
        for cliente in clientes_db:
            if cliente.nombre == nombre:
                return cliente
        

        
        
        
        
class Cliente:
    
    def __init__(self, nombre, email, ciudad, activo):
        self.nombre = nombre
        self.email = email
        self.ciudad = ciudad
        self.activo = activo

    def __str__(self):
        return f" Nombre: {self.nombre}, Email: {self.email}, Ciudad: {self.ciudad}, Status: {"Activo" if self.activo else "Desactivado"}"
                    
main()