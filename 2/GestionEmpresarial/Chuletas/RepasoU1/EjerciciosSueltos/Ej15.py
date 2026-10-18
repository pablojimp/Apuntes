

def leer_numeros(ruta):
    numeros = []
    try:
        with open(ruta, 'r', encoding='utf-8') as archivo:
            for linea in archivo:
                linea = linea.strip()
                try:
                    linea = int(linea)
                    numeros.append(linea)
                except ValueError:
                    pass
        return numeros
    except FileNotFoundError:
        return numeros