## Ejercicios de Herencia
### 1. Herencia con Electrodomésticos
**Enunciado:**  
Crea una clase `Electrodomestico` con los atributos `marca` y `modelo`. Luego, crea dos subclases: `Lavadora` con el atributo `capacidadCarga` y `Televisor` con el atributo `tamañoPantalla`.  
Sobrescribe el método `toString()` en cada subclase para que devuelva una cadena con los detalles del electrodoméstico.  

Implementa una clase `Main` para probar la creación de objetos y la llamada al método `toString()`.

### 2. Sistema de Gestión de Empleados
**Enunciado:**  
Crea una clase `Empleado` con los atributos `nombre` y `sueldoBase`. Luego, crea tres subclases: `Programador`, `Diseñador` y `Gerente`. Cada subclase debe tener un método `calcularSueldo()` que ajuste el sueldo base según un bonificador específico para cada tipo de empleado.

Implementa una clase `Main` para probar la creación de objetos y la llamada al método `calcularSueldo()`.

### 3. Vehículos con Tipos de Combustible
**Enunciado:**  
Crea una clase `Vehiculo` con los atributos `marca` y `tipoCombustible`. Luego, crea dos subclases: `Coche` con el atributo `numeroPuertas` y `Moto` con el atributo `cilindrada`.  
Implementa el método `toString()` en cada subclase para que devuelva una cadena con los detalles del vehículo.  

Implementa una clase `Main` para probar la creación de objetos y la llamada al método `toString()`.

### 4. Animales Domésticos y Salvajes
**Enunciado:**  
Crea una clase `Animal` con los atributos `nombre` y `tipoAlimentacion`. Luego, crea dos subclases: `Domestico` con el método `convivirConHumanos()` y `Salvaje` con el método `cazar()`. Cada método debe devolver una cadena con una acción específica relacionada con el tipo de animal.  

- `Domestico`:
    - Atributos: `dueño`
    - Método `convivirConHumanos()`: devuelve "El animal doméstico [nombre] convive con su dueño [dueño] y se alimenta de [tipoAlimentacion]."

- `Salvaje`:
    - Atributos: `habitat`
    - Método `cazar()`: devuelve "El animal salvaje [nombre] caza en su hábitat [habitat] y se alimenta de [tipoAlimentacion]."

Implementa una clase `Main` para probar la creación de objetos y la llamada a los métodos `convivirConHumanos()` y `cazar()`.

### 5. Biblioteca con Diferentes Tipos de Materiales
**Enunciado:**  
Crea una clase `MaterialBibliografico` con los atributos `titulo` y `autor`. Luego, crea dos subclases: `Libro` y `Revista`.  
Implementa el método `toString()` en ambas subclases para que devuelva una cadena con los detalles del material bibliográfico.  

- `Libro`:
    - Atributos: `numPaginas`, `genero`
    - Método `toString()`: devuelve "Libro: [titulo] por [autor], Género: [genero], Páginas: [numPaginas]."

- `Revista`:
    - Atributos: `edicion`, `periodicidad`
    - Método `toString()`: devuelve "Revista: [titulo] por [autor], Edición: [edicion], Periodicidad: [periodicidad]."

Implementa una clase `Main` para probar la creación de objetos y la llamada al método `toString()`.


---

## Ejercicios de Interfaces
### 6. Dispositivos Inteligentes
**Enunciado:**  
Define una interfaz `DispositivoInteligente` con los métodos `encender()`, `apagar()` y `conectarWiFi()`. Cada método debe devolver una cadena indicando la acción realizada.  
Luego, crea dos clases concretas: `Smartphone` y `SmartTV`. Cada clase debe implementar la interfaz y proporcionar una implementación específica para cada método.  

Implementa una clase `Main` para probar la creación de objetos y la llamada a los métodos de la interfaz.

### 7. Transporte Público con Múltiples Modos
**Enunciado:**  
Define una interfaz `Transporte` con los métodos `arrancar()` y `detener()`. Cada método debe devolver una cadena indicando la acción realizada.  
Luego, crea tres clases concretas: `Autobús`, `Metro` y `Bicicleta`. Cada clase debe implementar la interfaz y proporcionar una implementación específica para cada método según el tipo de transporte. En el caso de `Autobús`, se debe indicar la hora de salida al arrancar y la hora de parada al detener. En el caso de `Metro` se debe indicar el número de vagones al arrancar.

Implementa una clase `Main` para probar la creación de objetos y la llamada a los métodos de la interfaz.

### 8. Juegos con Interfaz de Jugador
**Enunciado:**  
Define una interfaz `Jugador` con los métodos `mover()` y `atacar()`. Cada método debe devolver una cadena indicando la acción realizada.  
Luego, crea tres clases concretas: `Guerrero`, `Mago` y `Arquero`. Cada clase debe implementar la interfaz y proporcionar una implementación específica para cada método según el tipo de jugador. 

- `Guerrero`:
    - Atributos: `nombre`, `fuerza`, `arma`
    - Método `mover()`: devuelve "El Guerrero [nombre] se mueve con fuerza [fuerza]."
    - Método `atacar()`: devuelve "El Guerrero [nombre] ataca con su [arma]."

- `Mago`:
    - Atributos: `nombre`, `mana`, `hechizo`
    - Método `mover()`: devuelve "El Mago [nombre] se desplaza utilizando su mana [mana]."
    - Método `atacar()`: devuelve "El Mago [nombre] lanza un hechizo [hechizo]."

- `Arquero`:
    - Atributos: `nombre`, `agilidad`, `arco`
    - Método `mover()`: devuelve "El Arquero [nombre] se mueve ágilmente con agilidad [agilidad]."
    - Método `atacar()`: devuelve "El Arquero [nombre] dispara una flecha con su [arco]."

Implementa una clase `Main` para probar la creación de objetos y la llamada a los métodos de la interfaz.

### 9. Instrumentos Musicales
**Enunciado:**  
Define una interfaz `InstrumentoMusical` con los métodos `tocar()` y `afinar()`. Cada método debe devolver una cadena indicando la acción realizada.  
Luego, crea dos clases concretas: `Guitarra` y `Piano`. Cada clase debe implementar la interfaz y proporcionar una implementación específica para cada método.  

- `Guitarra`:
    - Atributos: `marca`, `tipoCuerdas`
    - Método `tocar()`: devuelve "La guitarra de marca [marca] está tocando una melodía."
    - Método `afinar()`: devuelve "La guitarra de marca [marca] con cuerdas [tipoCuerdas] está siendo afinada."

- `Piano`:
    - Atributos: `marca`, `tipoTeclas`
    - Método `tocar()`: devuelve "El piano de marca [marca] está tocando una pieza clásica."
    - Método `afinar()`: devuelve "El piano de marca [marca] con teclas [tipoTeclas] está siendo afinado."

Implementa una clase `Main` para probar la creación de objetos y la llamada a los métodos de la interfaz.

### 10. Robots con Múltiples Capacidades
**Enunciado:**  
Define dos interfaces:  
- `Movil` con el método `moverse()`, que debe devolver una cadena indicando la acción realizada.  
- `Trabajador` con el método `realizarTarea()`, que debe devolver una cadena indicando la acción realizada.  

Luego, crea una clase concreta `Robot` que implemente ambas interfaces y proporcione una implementación específica para cada método.  

- `Robot`:
    - Atributos: `modelo`, `capacidadBateria`
    - Método `moverse()`: devuelve "El Robot modelo [modelo] con batería [capacidadBateria]% se desplaza hacia el destino programado."
    - Método `realizarTarea()`: devuelve "El Robot modelo [modelo] con batería [capacidadBateria]% realiza la tarea asignada eficientemente."

Implementa una clase `Main` para probar la creación de objetos y la llamada a los métodos de las interfaces.

## Ejercicios de Clases Abstractas
### 11. Figuras Geométricas con Cálculo de Áreas
**Enunciado:**  
Crea una **clase abstracta** `Figura` que tenga un método abstracto `calcularArea()`. Luego, crea dos clases concretas: `Triangulo` y `Cuadrado`. La clase `Triangulo` debe tener los atributos `base` y `altura`, y su método `calcularArea()` debe devolver el área del triángulo. La clase `Cuadrado` debe tener el atributo `lado`, y su método `calcularArea()` debe devolver el área del cuadrado.  

Implementa una clase `Main` para probar la creación de objetos y la llamada al método `calcularArea()`.

### 12. Vehículos con Métodos Abstractos
**Enunciado:**  
Crea una **clase abstracta** `Vehiculo` que tenga los métodos abstractos `arrancar()` y `detener()`. Luego, crea dos clases concretas: `Moto` y `Camion`. La clase `Moto` debe implementar los métodos `arrancar()` y `detener()` con el comportamiento específico de una motocicleta. La clase `Camion` debe implementar los métodos `arrancar()` y `detener()` con el comportamiento específico de un camión.  

Implementa una clase `Main` para probar la creación de objetos y la llamada a los métodos `arrancar()` y `detener()`.

### 13. Animales con Tipos de Sonidos
**Enunciado:**  
Crea una **clase abstracta** `Animal` que tenga un método abstracto `hacerSonido()`. Luego, crea dos clases concretas: `Leon` y `Elefante`. La clase `Leon` debe implementar el método `hacerSonido()` para devolver el sonido característico de un león. La clase `Elefante` debe implementar el método `hacerSonido()` para devolver el sonido característico de un elefante. 

Implementa una clase `Main` para probar la creación de objetos y la llamada al método `hacerSonido()`.

### 14. Productos en una Tienda Online
**Enunciado:**  
Crea una **clase abstracta** `Producto` con los atributos `nombre` y `precio`, y un método abstracto `toString()`. Luego, crea dos clases concretas: `Electronico` y `Ropa`. La clase `Electronico` debe tener un atributo adicional `garantia` y su método `toString()` debe devolver una cadena con los detalles del producto electrónico. La clase `Ropa` debe tener un atributo adicional `talla` y su método `toString()` debe devolver una cadena con los detalles de la prenda de ropa.  

Implementa una clase `Main` para probar la creación de objetos y la llamada al método `toString()`.

### 15. Empleados con Diferentes Roles
**Enunciado:**  
Crea una **clase abstracta** `Empleado` que tenga un método abstracto `calcularSueldo()`. Luego, crea dos clases concretas: `Gerente` y `Asistente`. La clase `Gerente` debe tener un atributo adicional `bono` y su método `calcularSueldo()` debe devolver el sueldo base más el bono. La clase `Asistente` debe tener un atributo adicional `horasExtras` y su método `calcularSueldo()` debe devolver el sueldo base más el pago por horas extras.  

Implementa una clase `Main` para probar la creación de objetos y la llamada al método `calcularSueldo()`.

## Bonus
### 16. 
