# UNIDAD DIDÁCTICA 3 – DESARROLLO DE SCRIPTS DE BASH 

### 2. Creación y Ejecución de Scripts
**Shebang:**
```bash
#!/bin/bash
```
- Indica qué intérprete usar.
- Si el script se ejecuta con `bash script.sh` el shebang no es estrictamente necesario; sí lo es para ejecutar con `./script.sh`.

**Permisos y rutas:**
```bash
# Crear
nano saludo.sh
# Hacer ejecutable
chmod +x saludo.sh
# Ejecutar
./saludo.sh
```

---

### 3. Variables en Bash — ejemplos completos y por qué
**Declaración y uso**
```bash
usuario="María"
echo "Hola, $usuario"
```
**Reglas clave:**
- No usar espacios alrededor de `=`.
- Nombres sensibles a mayúsculas.

**Variables Especiales de Bash**
 Bash proporciona variables especiales que contienen información útil durante la ejecución de scripts.
 Algunas de las más importantes son:
```bash
- $0 – Nombre del script.
- $1, $2, $3... - Argumentos pasados al script.
- $#– Número de argumentos pasados al script. 
- $?– Estado de salida del último comando (0 si fue exitoso, diferente de 0 si hubo un error)
```

**Evaluación de comandos**
```bash
fecha=$(date)
echo "Hoy es $fecha"
```

**Aritmética (solo enteros)**
```bash
a=10
b=3
suma=$((a + b))
echo "Suma: $suma"

resta=$((a - b))
echo "resta: $resta"

multiplicacion=$((a * b))
echo "multiplicacion: $multiplicacion"

division=$((a / b))
echo "division: $division"

modulo=$((a % b))
echo "modulo: $modulo"

potencia=$((a ** b))
echo "potencia: $potencia"
```


---

### 4. Condicionales y operadores de comparación — ejemplos y explicaciones
**Sintaxis if-elif-else**
```bash
#!/bin/bash
num=15
if [ "$num" -lt 10 ]; then
  echo "$num es menor que 10"
elif [ "$num" -eq 10 ]; then
  echo "$num es igual a 10"
else
  echo "$num es mayor que 10"
fi
```
**Por qué `[` y espacios:** `[` es en realidad un comando (`test`); necesita parámetros separados por espacios. Por eso `if [ "$a" -lt "$b" ]` y no `if [$a -lt $b]`.

**Operadores numéricos más usados:**
- `-eq`  Igual a, 
- `-ne`, No es igual a
- `-lt`, Menor que
- `-le`, Menor o igual que
- `-gt`, Mayor que
- `-ge`. Mayor o igual que

**Comparaciones de cadenas**
```bash
a="hola"
b="hola"
if [ "$a" = "$b" ]; then
  echo "iguales"
fi
```


### 5. Bucles FOR — ejemplos claros

**Rango simple**
```bash
for i in {1..5}; do
  echo "Número: $i"
done
```
- Notas: `{1..5}` lo expande Bash internamente a la lista `1 2 3 4 5`.

**Iterar lista de palabras**
```bash
for nombre in Juan "María López" Luis; do
  echo "Hola, $nombre"
done
```


### 6. Bucles WHILE — ejemplos y cuándo son útiles
**Contador**
```bash
contador=1
while [ $contador -le 5 ]; do
  echo "Iteración $contador"
  ((contador++))
done
```



### 7. Arrays — explicación detallada
**Declarar**
```bash
mi_array=("Juan" "María" "Luis" "Ana")
```
**Acceder**
```bash
echo "${mi_array[0]}"   # Juan
```
**Todos los elementos**
```bash
echo "${mi_array[@]}"
```
**Longitud**
```bash
echo "${#mi_array[@]}"
```
**Añadir**
```bash
mi_array+=("Carlos")
```
**Eliminar**
```bash
unset 'mi_array[2]'   # elimina el índice 2 (no reindexa)
```
**Iterar**
```bash
for nombre in "${mi_array[@]}"; do
  echo "Hola, $nombre"
done
```





### 8. Posibles Ejercicios 

Ejercicio 1 
```bash
#!/bin/bash

archivo=$1
palabras=("$@")

for (( i=${#palabras[@]}-1; i>0; i-- )); do
    echo "${palabras[$i]}" >> "$archivo"
done


Ejercicio 2 `PING`


```bash
#!/bin/bash

dominio=$1

comandoIp=$(ping $dominio | head -n 1)
zonaIp=$(echo $comandoIp | cut -d" " -f3)
ip=$(echo $zonaIp | tr -d "()")

primeraColumnaIp=$(echo $ip | cut -d"." -f1)
segundaColumnaIp=$(echo $ip | cut -d"." -f2)
terceraColumnaIp=$(echo $ip | cut -d"." -f3)
cuartaColumnaIp=$(echo $ip | cut -d"." -f4)

if [ $primeraColumnaIp -lt 0 ] || [ $primeraColumnaIp -gt 255 ] || [ $segundaColumnaIp -lt 0 ] || [ $segundaColumnaIp -gt 255 ] || [ $terceraColumnaIp -lt 0 ] || [ $terceraColumnaIp -gt 255 ] || [ $cuartaColumnaIp -lt 0 ] || [ $cuartaColumnaIp -gt 255 ]; then
    mensajeFinal="¡ERROR! No es una ip válida"
else
    mensajeFinal="La dirección IP de ese dominio sería: "$ip
fi

echo $mensajeFinal
```


Ejercicio 3 `CARPETAS`


```bash
#!/bin/bash

nombreCarpetaArchivo=$1
numero=$2

if  [ $((numero % 2)) -eq 0 ]; then
    for (( i=1; i<=numero; i++ )); do
        echo "Carpeta creada $nombreCarpetaArchivo$i"
        mkdir "$nombreCarpetaArchivo$i"
    done
else
    for (( i=1; i<=numero; i++ )); do
        echo "Archivo creado $nombreCarpetaArchivo$i"
        touch "$nombreCarpetaArchivo$i"
    done
fi



```
