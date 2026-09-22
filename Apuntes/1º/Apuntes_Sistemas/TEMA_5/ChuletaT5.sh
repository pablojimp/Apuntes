#!/bin/bash

# Función para validar que se pasan los argumentos correctos
validar_argumentos() {
    if [ $# -lt $(( $1 + 1 )) ]; then
        echo "Hay que pasar $1 argumentos o mas"
        return 1
    else
        return 0
    fi
}

# 1. Función validar_numero - Valida si un argumento es un número entero
validar_numero() {
    validar_argumentos 1 $@ || return 1
    
    if [ "$1" -eq "$1" ] 2>/dev/null; then
        echo "true"
        return 0
    else
        echo "false"
        return 1
    fi
}


# ============================================
# OPERADORES DE COMPARACIÓN NUMÉRICA
# ============================================
# -eq   igual                [ "$a" -eq "$b" ]
# -ne   distinto             [ "$a" -ne "$b" ]
# -gt   mayor que            [ "$a" -gt "$b" ]
# -lt   menor que            [ "$a" -lt "$b" ]
# -ge   mayor o igual        [ "$a" -ge "$b" ]
# -le   menor o igual        [ "$a" -le "$b" ]

a=10
b=5

if [ "$a" -gt "$b" ]; then echo "$a es mayor que $b"; fi
if [ "$a" -ge "$b" ]; then echo "$a es mayor o igual que $b"; fi
if [ "$b" -lt "$a" ]; then echo "$b es menor que $a"; fi
if [ "$b" -le "$a" ]; then echo "$b es menor o igual que $a"; fi
if [ "$a" -eq "$a" ]; then echo "$a es igual a $a"; fi
if [ "$a" -ne "$b" ]; then echo "$a es distinto a $b"; fi


# ============================================
# OPERADORES DE CADENAS DE TEXTO
# ============================================
# -z    cadena vacía         [ -z "$var" ]
# -n    cadena no vacía      [ -n "$var" ]
# =     iguales              [ "$a" = "$b" ]
# !=    distintas            [ "$a" != "$b" ]

cadena=""
nombre="hola"

if [ -z "$cadena" ];  then echo "cadena está vacía"; fi
if [ -n "$nombre" ];  then echo "nombre no está vacío"; fi
if [ "$nombre" = "hola" ];  then echo "nombre es igual a hola"; fi
if [ "$nombre" != "adios" ]; then echo "nombre es distinto a adios"; fi


# ============================================
# OPERADORES DE FICHEROS Y DIRECTORIOS
# ============================================
# -f    es un fichero        [ -f "$ruta" ]
# -d    es un directorio     [ -d "$ruta" ]
# -e    existe               [ -e "$ruta" ]
# -r    permiso lectura      [ -r "$ruta" ]
# -w    permiso escritura    [ -w "$ruta" ]
# -x    permiso ejecución    [ -x "$ruta" ]
# -s    fichero no vacío     [ -s "$ruta" ]

ruta="/tmp"

if [ -d "$ruta" ]; then echo "$ruta es un directorio"; fi
if [ -e "$ruta" ]; then echo "$ruta existe"; fi
if [ -r "$ruta" ]; then echo "$ruta tiene permisos de lectura"; fi
if [ -w "$ruta" ]; then echo "$ruta tiene permisos de escritura"; fi
if [ -x "$ruta" ]; then echo "$ruta tiene permisos de ejecución"; fi


# ============================================
# OPERADORES LÓGICOS
# ============================================
# &&    AND (y)              [ cond1 ] && [ cond2 ]
# ||    OR (o)               [ cond1 ] || [ cond2 ]
# !     NOT (negación)       [ ! condicion ]

if [ "$a" -gt 0 ] && [ "$b" -gt 0 ]; then echo "a y b son positivos"; fi
if [ "$a" -gt 100 ] || [ "$b" -gt 0 ]; then echo "al menos uno cumple la condición"; fi
if [ ! -z "$nombre" ]; then echo "nombre no está vacío (usando !)"; fi






# EJERCICIO 1
calcular_maximo() {
validar_argumentos 2 "$@" || return 1

    maximo=$1

    for numero in "$@"; do
        if [ "$numero" -gt "$maximo" ]; then
            maximo=$numero
        fi
    done
    echo "El máximo es: $maximo "
    echo "Lista de numeros recibidos: [$@]"
}
calcular_maximo 7 6 64 8 7 92 8 4 



archivos_max_peso() {
validar_argumentos 1 "$@" || return 1

    ruta="$1"
    max=$(ls -lS "$ruta" | head -2 | tail -1 | awk '{print $5}')
    find "$ruta" -type f -size "${max}c" -maxdepth 1
 find "$ruta" -maxdepth 1 -type f -size "${max}c"
}


borrar_grandes() {
    validar_argumentos 1 $@ || return 1

    archivos=$(lista_archivos $1)
    for archivo in $archivos; do
        rm -rf "$1/$archivo"
    done
}