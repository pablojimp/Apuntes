 #!/bin/bash 
cadena=$1  
contrasenas=$( cat rockyou.txt | grep $cadena) 
 numero=$( echo $contrasenas | wc -w ) 
 if [ $(($numero)) -gt 5 ]; then 

echo $contrasenas 
echo "Lo sentimos, esta cadena es demasiado insegura para usarse en una 
contraseña. Se han encontrado $numero contraseñas que la contienen."
 else 
echo $contrasenas 
echo "Se han encontrado menos de 5 contraseñas que contengan la cadena '$cadena'"
 fi  