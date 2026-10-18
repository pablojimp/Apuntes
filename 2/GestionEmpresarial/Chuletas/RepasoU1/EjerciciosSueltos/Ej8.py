
def empleado_mayor_salario(empleados):
    salario_max = 0
    empleado_max = None
    if len(empleados) <= 0:
        return None
    for empleado in empleados:
        if empleado['horas'] * empleado['tarifa'] > salario_max:
            empleado_max = empleado
            salario_max =  empleado['horas'] * empleado['tarifa']
    
    return empleado_max