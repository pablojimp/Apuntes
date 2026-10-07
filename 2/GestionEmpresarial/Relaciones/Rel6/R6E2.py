# Pide las ventas de 7 días mediante un bucle for. Acumula el total y calcula la
# media. Muestra ambos valores con dos decimales. No utilices todavía una lista:
# procesa cada dato a medida que se introduce.

temperaturas = 0
dias_semana = 7
total =0
for i in range(dias_semana):
    temperatura_dia = float(input(f"Introduce la temperatura del dia {i+1} de la semana: "))
    temperaturas += temperatura_dia
    total += temperaturas / dias_semana
    print(f"Media de la semana {total:.2f} | Temperatura total actual {temperaturas:.2f} ")
    
    

    

    