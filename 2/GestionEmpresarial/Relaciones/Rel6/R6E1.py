


numeroPedidos = int(input("Escribe cuantos pedidos vas a introducir: "))
if numeroPedidos <= 0:
    print(f"No puedes poner valores menores a 0")
else:
    for i in range(numeroPedidos):
            print(f"PED-{i+1:03d}")