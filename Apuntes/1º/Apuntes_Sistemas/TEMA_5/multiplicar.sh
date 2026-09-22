#!/bin/bash

validar_argumentos() {
    local esperados=3  # CAMBIAS AQUÍ el número de argumentos esperados
    
    if [ $# -ne $esperados ]; then
        echo "0"  # Error
        return 1
    else
        echo "1"  # Éxito
        return 0
    fi
}

# Llamar la función pasando los argumentos del script
resultado=$(validar_argumentos "$@")

if [ $resultado -eq 1 ]; then
