CREATE DATABASE bolera;

USE bolera;

INSERT INTO
    CLIENTES (
        id number PRIMARY KEY,
        nombre varchar(50),
        direccion varchar(50),
        telefono varchar(20)
    )
INSERT INTO
    PISTAS (
        id number PRIMARY KEY,
        capacidad number,
        estado boolean
    )
INSERT INTO
    RESERVAS (
        id number PRIMARY KEY,
        fecha date,
        hora time,
        duraccion time,
        IDCliente number,
        FOREIGN KEY (IDCliente) references CLIENTES (id),
        IDReserva number,
        FOREIGN KEY (IDReserva) references PISTAS (id)
    )
INSERT INTO
    EMPLEADOS (
        id number PRIMARY KEY,
        nombre varchar(50),
        puesto varchar(50),
        fecha date,
        IDPista number,
        FOREIGN KEY (IDPista) references PISTAS (id)
    )
INSERT INTO
    PAGOS (
        id number PRIMARY KEY,
        monto decimal,
        fecha date,
        metodo varchar(50),
        IDReservas number,
        FOREIGN KEY (IDReservas) references RESERVAS (id)
    )
INSERT INTO
    PROMOCIONES (
        id number PRIMARY KEY,
        nombre varchar(50),
        descripcion varchar(50),
        porcentaje number
    )