#!/bin/bash
validar_argumentos() {
    if [ $# -ne $(( $1 + 1 )) ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    else
        return 0
    fi
}

AreaCirculo() {
    validar_argumentos 1 "$@"
    if [ $? -ne 0 ]; then
        return 1
    fi

    local pi=3.1415


    if [ $(echo "$1 <=0" | bc) -eq 1 ]; then
    echo "El radio debe ser mayor que 0"
    return 1
    else
    echo "scale=2; $pi * $1 * $1" | bc
    fi

}