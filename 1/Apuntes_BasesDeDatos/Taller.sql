CREATE DATABASE taller;

USE taller;

INSERT INTO
    CLIENTES (
        id number PRIMARY KEY,
        direccion varchar(50),
        telefono varchar(20)
    )
INSERT INTO
    VEHICULO (
        matricula varchar(10) PRIMARY KEY,
        marca varchar(20),
        anio number,
        IDdueño number,
        FOREIGN KEY (IDdueño) references CLIENTES (id)
    )
INSERT INTO
    REPARACION (id number PRIMARY KEY,)