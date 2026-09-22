#!/bin/bash
validar_argumentos() {
    if [ $# -ne $(( $1 + 1 )) ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    else
        return 0
    fi
}

buscar_archivos_grandes() {
validar_argumentos 2 "$@"


local ruta="$1"
local size_mb="$2"
local bytes=$(( size_mb * 1024 * 1024 ))
local comando=$(find "$ruta" -type f -size "+${bytes}c")

if [ -z "$comando" ];then

echo "No hay archivos mayores a" $size_mb "MB"
else
$comando
fi

}

buscar_archivos_grandes $1 $2
