
# Ahora vamos a trabajar con cadenas de texto, funciones, diccionarios y bucles.
# Escribe una función analizar_texto(texto) que reciba una frase y devuelva un diccionario con:

#  'caracteres': número de caracteres, incluidos los espacios.
# - 'palabras': número de palabras.
# - 'vocales': número total de vocales (a, e, i, o, u), tanto mayúsculas como minúsculas.
# - 'palabra_mas_larga': la palabra más larga de la frase. Si hay empate, puedes devolver cualquiera de las más largas.
# Si la frase está vacía o solo contiene espacios, devuelve None.
# Ejemplo de prueba:
# texto = "Python es un lenguaje genial"print(analizar_texto(texto))



# Pistas, sin darte la solución:
# - len(texto) cuenta todos los caracteres.
# - texto.split() separa la frase en palabras.
# - lower() te puede ayudar con las mayúsculas.
# - Para encontrar la palabra más larga, puedes recorrer la lista de palabras y comparar sus longitudes.


def analizar_texto(texto):
    if len(texto.split()) == 0:
        return None
    resumen = {}
    contador_vocales = 0
    resumen['caracteres'] = len(texto)
    resumen['palabras'] = len(texto.split())
    for letra in texto:
        if letra.lower() in 'aeiou':
            contador_vocales += 1
            
    resumen['vocales'] = contador_vocales
    maximo_actual = 0
    for palabra in texto.split():
        if len(palabra) > maximo_actual:
            resumen['palabra_mas_larga'] = palabra
            maximo_actual = len(palabra)
        
    return resumen

    
texto = "Python es un lenguaje genial"
print(analizar_texto(texto))