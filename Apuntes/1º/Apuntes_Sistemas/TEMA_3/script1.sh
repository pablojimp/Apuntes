#!/bin/bash
opcion=$1 
if [ $opcion == 'm' ]; then 
echo "El resultado es: $(($2 * $3))"
 elif [ $opcion == 'r' ]; then 
echo "El resultado es: $(($2 - $3))"
 elif [ $opcion == 's' ]; then 
echo "El resultado es: $(($2 + $3))"
 elif [ $opcion == 'd' ]; then 
echo "El resultado es: $(($2 / $3))"
 else 
echo "Elija otra opcion, esta es incorrecta."
 fi