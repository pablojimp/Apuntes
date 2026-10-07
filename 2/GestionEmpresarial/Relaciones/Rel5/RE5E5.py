# Pide las ventas mensuales de tienda, web y teléfono. Indica cuál ha obtenido la
# cifra mayor. Si dos o tres canales empatan en el máximo, informa de que existe
# empate en lugar de inventar un ganador.

# Comprobación

# Prueba un caso con ganador único y otro con empate


ventas = {
    "tienda": float(input("Ventas de tienda: ")),
    "web": float(input("Ventas de web: ")),
    "telefono": float(input("Ventas de telefono: "))
}
maximo = max(ventas.values())

ganadores = []

for canal, venta in ventas.items():
    if venta == maximo:
        ganadores.append(canal)

if len(ganadores) == 1:
    print(f"El canal que mas ha vendido es {ganadores[0]}")
else:
    print(f"Existe un empate entre: {ganadores}")