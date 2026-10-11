
def pedir_datos():
    datos = {
        "cliente": input("Introduce el nombre del cliente: "),
        "precio": float(input("Introduce el precio: ")),
        "cantidad": int(input("Introduce la cantidad: ")),
        "descuento": int(input("Introduce el descuento: "))
    }
    return datos

def calcular_total(informacion):
    return informacion["precio"] * informacion["cantidad"] - ((informacion["precio"] * informacion["cantidad"]) * (informacion["descuento"] / 100))

def mostrar_resumen(informacionCliente, informacionPrecios):
    print("\nResumen del pedido")
    print(f"Cliente: {informacionCliente['cliente']}")
    print(f"Precio: {informacionCliente['precio']:.2f}")
    print(f"Cantidad: {informacionCliente['cantidad']}")
    print(f"Descuento: {informacionCliente['descuento']}%")
    print(f"Total: {informacionPrecios:.2f}")

    

def main():
    datos = pedir_datos()
    total = calcular_total(datos)
    mostrar_resumen(datos,total)
    
main()