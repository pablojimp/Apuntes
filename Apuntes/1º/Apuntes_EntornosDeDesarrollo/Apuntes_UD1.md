# Git y sus usos #

## **1. Terminos iniciales para conocer Git y que funciones tiene**

- **Repositorio** : Una carpeta donde Git realiza un seguimiento de tu proyecto y su historial.
- **Clonar** : Hacer una copia de un repositorio remoto en tu ordenador.
- **Commit** : Guarda una instantánea de los cambios preparados.
- **Pull** : Obtén los últimos cambios de un repositorio remoto.
- **Push** : Envía tus cambios a un repositorio remoto.
- **main** : Representa la rama principal en el repositorio local. 
- **origin/main** : Es un punto de referencia que indica la rama actual en el repositorio local. 
- **stash** : almacenar temporalmente los cambios locales

## **2. Instalacion Inicial de Git**

En windows usaremos la aplicacion `Git bash`, una vez que tengamos esta aplicacion lo primero sera configurar nuestro nombre 

``` bash
git config --global user.name "Your Name"
```


Despues de esto configuraremos nuestro correo electronico

``` bash
git config --global user.email "you@example.com"
```

Y haciendo uso de `--global` podremos poner esta configuracion para todos nuestros proyectos

A la hora de crear un nuevo proyecto deberemos hacer uso de `mkdir` y `cd` para crear una nueva carpeta y entrar a ella despues de esto iniciaremos git

``` bash
git init
```

Una vez que hemos hecho esto crearemos un archivo el cual usaremos para subirlo, en mi caso sera un archivo `index.html`

## **3. Empezamos a subir archivos**

Subiremos el archivo `index.html` con el siguiente comando
``` bash
git add index.html
```

Asi subimos solo un archivo pero podemos usar otros comandos mas utiles para subir todo directamente
``` bash
git add --all
```

## **4. Crearemos un commit con mensaje**

De esta forma crearemos un commit con un mensaje

``` bash
git commit -m "your message"
```

Asi podremos ver el historico de los commits

``` bash
git log
```