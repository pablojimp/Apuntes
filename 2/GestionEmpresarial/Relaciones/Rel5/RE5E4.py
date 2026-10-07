# Ejercicio 04 · Gastos de envío

# Pide destino (PENINSULA, BALEARES o CANARIAS) y total del pedido. En
# PENINSULA el envío es gratuito desde 100 EUR y cuesta 6 EUR en caso contrario.
# En BALEARES cuesta 12 EUR. En CANARIAS cuesta 18 EUR. Si el destino no es
# válido, indícalo y no calcules el total final.

# Comprobación

# Normaliza el destino con strip() y upper() para aceptar diferencias de espacios
# o mayúsculas.

destino = input("Introduce el destino (PENINSULA, BALEARES, CANARIAS): ").upper().strip()
total = float(input("Introduce el total del pedido: "))

if destino != "PENINSULA" and destino != "BALEARES" and destino != "CANARIAS":
    print("No se ha podido calcular el envío, introduce PENINSULA, BALEARES o CANARIAS y verifica lo que escribes")
else:
    if destino == "PENINSULA" and total >= 100:
        envio = 0     
    elif destino == "BALEARES" :
        envio = 12  
    elif destino == "CANARIAS" :
         envio = 18  
    else:
        envio = 6
    coste_total = total + envio
    print(f"El total de su pedido direccion {destino}: {coste_total} - Con un coste de envio: {envio}")


