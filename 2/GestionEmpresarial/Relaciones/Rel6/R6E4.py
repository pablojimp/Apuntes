
activo = True
while activo:
    opcion=int(input(f"1.Alta ficticia\n2.Consulta ficticia\n3.Informe ficticio\n0.Salir\nIntroduce Opcion: "))
    if opcion == 1:
        print(f"\nAlta correcta.\n")
    elif opcion == 2:
        print(f"\nConsulta correcta.\n")
    elif opcion == 3:
        print(f"\nInforme correcto.\n")
    elif opcion == 0:
        activo = False
    else: 
        print("\nOpción no válida\n")
    