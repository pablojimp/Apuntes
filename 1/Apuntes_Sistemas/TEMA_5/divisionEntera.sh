#!/bin/bash
validar_argumentos() {
    if [ $# -ne $(( $1 + 1 )) ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    else
        return 0
    fi
}

divisionEntera() {
    validar_argumentos 2 "$@"
    if [ $? -ne 0 ]; then
        return 1
    fi
    if [ "$2" -eq 0 ]; then
    echo "El divisor no puede ser 0"
    return 1
    else
    echo $(("$1" / "$2" ))
    fi
}