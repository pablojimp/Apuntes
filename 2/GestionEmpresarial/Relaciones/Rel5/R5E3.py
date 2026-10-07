# Pide el total de un pedido y si el cliente es premium mediante una respuesta S/N.
# Un pedido es prioritario si supera 500 EUR o si el cliente es premium y supera 250
# EUR. En cualquier otro caso es normal. Usa and y or.

# Comprobación

# Comprueba 600/N, 300/S y 200/S.

total = float(input("Introduce el total del pedido: "))
cliente = input("El cliente es premium (S/N): ").upper()

if(cliente != "S" or cliente != "N"):
    print(f"Introduce S o N")

if(total >= 500 or (cliente == "S" and total >= 250)):
    respuesta = "Prioritario"
else:
    respuesta = "Normal"

print(f"El pedido es {respuesta}")