--CREACIÓN DE TABLAS.
CREATE TABLE sede (
    id_sede INT PRIMARY KEY,
    pais VARCHAR (100),
    ciudad VARCHAR (50), 
    direccion VARCHAR (100),
    telefono INT (9),
    director VARCHAR (20)
 
);

CREATE TABLE proyecto (
    id_proyecto INT PRIMARY KEY,
    titulo VARCHAR(20),
    f_incio DATE, 
    f_fin DATE,
    responsabilidad VARCHAR(20),
    presupuesto INT
);

CREATE TABLE actuacion (
    id_actuacion INT PRIMARY KEY,
    inversion INT,
    descripcion VARCHAR(50)

);

CREATE TABLE poblacion (
    id_poblacion INT PRIMARY KEY,
    nombre VARCHAR (20),
    pais VARCHAR (10),
    habitantes INT 

);

CREATE TABLE sede_proyecto (
    id_sede INT,
    id_proyecto INT,
    PRIMARY KEY (id_sede, id_proyecto)
    FOREIGN KEY (id_sede) REFERENCES sede(id_sede)
    FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto)

);

CREATE TABLE proyecto_actuacion (
    id_proyecto INT,
    id_actuacion INT,
    PRIMARY KEY (id_proyecto, id_actuacion),
    FOREIGN KEY (id_proyecto) REFERENCES proyecto (id_proyecto),
    FOREIGN KEY (id_actuacion) REFERENCES actuacion (id_actuacion)

);

CREATE TABLE actuacion_poblacion (
    id_actuacion INT,
    id_poblacion INT,
    PRIMARY KEY (id_actuacion, id_poblacion),
    FOREIGN KEY ( id_actuacion) REFERENCES actuacion (id_actuacion),
    FOREIGN KEY ( id_poblacion) REFERENCES poblacion (id_poblacion)

);