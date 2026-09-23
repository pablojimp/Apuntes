#!/bin/bash
validar_argumentos() {
    if [ $# -ne $(( $1 + 1 )) ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    else
        return 0
    fi
}

creaCarpeta() {
validar_argumentos 1 "$@"

    local ruta="$1"
    local padre=$(dirname "$ruta")

    # Validar permisos de escritura en la ruta padre
    if [ ! -w "$padre" ]; then
        echo "Error: no tienes permisos de escritura en '$padre'"
        return 1
    fi

    # Comprobar si ya existe
    if [ -d "$ruta" ]; then
        echo "Directorio '$ruta' ya existe"
        return 0
    fi

    # Crear el directorio
    if mkdir -p "$ruta"; then
        echo "Directorio '$ruta' creado"
    else
        echo "Error: no se pudo crear el directorio '$ruta'"
        return 1
    fi
}

# Ejemplo de uso
creaCarpeta "/tmp/prueba"