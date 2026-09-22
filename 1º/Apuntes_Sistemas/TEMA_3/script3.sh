 #!/bin/bash 

if [ $1 -gt 10 ] || [ $1 -lt 1 ]; then 
echo "El número debe estar entre 1 y 10" 
exit 1 
fi 

if [ $1 -le 5 ]; then 
    i=1 
while [ $i -le $1 ]; do 
        touch "archivo$i" 
        ((i++)) 
 done
 
 else 

 while [ $i -le $1 ]; do 
        mkdir "carpeta$i" 
        ((i++)) 
    done

fi