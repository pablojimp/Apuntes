


numeroPedidos = int(input("Escribe cuantos pedidos vas a introducir: "))
if numeroPedidos <= 0:
    print(f"No puedes poner valores menores a 0")
else:
    for i in range(numeroPedidos):
        if i < 9:
            print(f"PED-00{i+1}")
        elif i < 99:
            print(f"PED-0{i+1}")
        else:
            print(f"PED-{i+1}")