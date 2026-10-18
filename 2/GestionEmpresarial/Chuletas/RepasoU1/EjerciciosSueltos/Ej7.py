
def calcular_nominas(empleados):
    empleados_resultado = []
    for empleado in empleados:
        empleados_resultado.append({
                                    'nombre': empleado['nombre'],
                                    'salario': empleado['horas'] * empleado['tarifa'],
                                    'horas_extra': empleado['horas'] - 40
                                    })
        
    return empleados_resultado




empleados = [   
             {'nombre': 'Ana', 'horas': 40, 'tarifa': 12},    
             {'nombre': 'Luis', 'horas': 35, 'tarifa': 15},    
             {'nombre': 'Marta', 'horas': 45, 'tarifa': 10},    
             {'nombre': 'Pablo', 'horas': 20, 'tarifa': 18}]