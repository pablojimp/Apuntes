-- EJERCICIO 1
SELECT nombre,salario FROM techcorp_db.empleados;
SELECT * FROM techcorp_db.empleados;
SELECT nombre FROM techcorp_db.empleados WHERE departamento = "it" and ciudad= "Madrid";
SELECT nombre FROM techcorp_db.empleados WHERE salario > 3000 and salario <= 6000;
SELECT distic ciudad FROM techcorp_db.empleados;
SELECT nombre FROM techcorp_db.empleados WHERE (departamento = "marketing" or departamento = "ventas") and salario > 5000;
select nombre from techcorp_db.empleados where departamento != "recursos humanos";
SELECT nombre FROM techcorp_db.clientes where ciudad = "barcelona";
SELECT nombre FROM techcorp_db.empleados where edad < 30 and salario > 4000;
SELECT nombre FROM techcorp_db.empleados where salario >= 3500 and departamento = "desarrollo"

-- EJERCICIO 2
SELECT goles_local,goles_visitante, goles_local + goles_visitante AS goles_total FROM ejercicio42.partidos Where goles_local + goles_visitante > 4;
SELECT nombre_jugador FROM ejercicio42.jugadores where id_equipo = 1;
SELECT id_partido,goles_local,goles_visitante FROM ejercicio42.partidos where goles_local > goles_visitante;
SELECT * FROM ejercicio42.equipos ORDER BY nombre_equipo;
SELECT * FROM ejercicio42.jugadores where posicion = "Delantero" AND goles > 20;
SELECT avg(goles_local+goles_visitante) as promedio_equipo, id_equipo_local FROM ejercicio42.partidos where id_equipo_local = 1 or id_equipo_visitante = 1;
SELECT * FROM ejercicio42.partidos where fecha>"2022-12-31" and fecha < "2023-02-01";
SELECT id_equipo, COUNT(nombre_jugador) FROM ejercicio42.jugadores WHERE id_equipo = 1;
SELECT nombre_equipo, ciudad, fundado FROM ejercicio42.equipos ORDER BY ciudad, fundado DESC;
SELECT id_equipo, AVG(edad) AS edad_promedio FROM ejercicio42.jugadores GROUP BY id_equipo ORDER BY id_equipo DESC, edad_promedio DESC;
SELECT id_equipo,avg(goles) as promedio_goles, avg(asistencias) as promedio_asistencias FROM ejercicio42.jugadores group by id_equipo order by promedio_goles desc, promedio_asistencias;
SELECT id_equipo_local, SUM(goles_local) AS total_goles FROM ejercicio42.partidos GROUP BY id_equipo_local ORDER BY total_goles DESC;

-- EJERCICIO 3 
SELECT nombre as Nombre_Equipo, ciudad as Ciudad_Equipo FROM basketball_db.equipos;
SELECT nombre, puntos_por_juego FROM basketball_db.jugadores ORDER BY puntos_por_juego desc;
SELECT nombre, length(nombre) as Longitud FROM basketball_db.equipos order by Longitud desc;
Select sum(campeonatos) from equipos group by ciudad;

-- EJ 5
SELECT concat(nombre,apellido) as Concatenado FROM gobierno.ciudadano;
SELECT SUBSTRING(nombre, 1 , 3) as 3Letras  FROM gobierno.ciudadano;
select nombre,length(nombre) as Longitud from ciudadano;
SELECT REPLACE(descripcion, 'hospitales', 'clínicas') FROM actividad;
SELECT trim(nombre) FROM gobierno.ministerio;
SELECT round(presupuesto_asignado) FROM gobierno.actividad;
SELECT ingresos_anuales - (Select avg(ingresos_anuales) from ciudadano) FROM gobierno.ciudadano;
SELECT round(presupuesto , 0) FROM gobierno.ministerio;
SELECT FLOOR(1 + (RAND() * 100)) as id_Unico_Temp FROM gobierno.actividad;
SELECT DATEDIFF(NOW(), fecha_creacion )/ 365 AS antiguedad FROM ministerio;
SELECT * ,DATE_FORMAT(fecha_inicio, '%d/%m/%Y') as fecha_ini,DATE_FORMAT(fecha_fin, '%d/%m/%Y') as fecha_end FROM actividad;
SELECT DATEDIFF(fecha_fin, fecha_inicio ) FROM actividad;
SELECT *,EXTRACT(YEAR FROM fecha_nacimiento),EXTRACT(month FROM fecha_nacimiento)  FROM ciudadano;
SELECT nombre, apellido,fecha_nacimiento, EXTRACT(YEAR FROM fecha_nacimiento) AS ano_nacimiento, EXTRACT(MONTH FROM fecha_nacimiento) AS mes_nacimiento
FROM ciudadano WHERE EXTRACT(YEAR FROM fecha_nacimiento) > 1990;
SELECT Sum(DATEDIFF(fecha_fin, fecha_inicio)) as Duracion_total FROM actividad;

-- Ejercicio 6

-- Ejercicios de MySQL - Base de Datos de Películas (Extendida)

-- Ejercicios (Ampliados)
-- 1. Listar todos los títulos de las películas.
    SELECT titulo FROM cine_db.pelicula;

-- 2. Mostrar los géneros de las películas sin repetir.
SELECT distinct(genero) FROM cine_db.pelicula;

-- 3. Seleccionar el título y año de todas las películas estrenadas después del año 2000.
    SELECT titulo, anio from cine_db.pelicula where anio > 2000;


-- 4. Listar los nombres de todos los directores y sus países de origen.

SELECT nombre, pais_origen from cine_db.director;
-- 5. Mostrar los títulos de las películas con duración mayor a 150 minutos.
    SELECT * FROM cine_db.pelicula where duracion > 150;
-- 6. Seleccionar el título de las películas del género 'Drama'.
SELECT * FROM cine_db.pelicula where genero = "Drama";

-- 7. Mostrar los id de los actores que participan en la película 'Titanic'.
-- Enunciado: Mostrar los id de los actores asociados con el id de 'Titanic'.



-- 8. Contar cuántas películas hay en cada género.

-- 9. Mostrar los directores nacidos después de 1950.


-- 10. Listar los títulos de las películas y su duración ordenados de mayor a menor.


-- 12. Seleccionar las películas cuya duración está entre 120 y 180 minutos.


-- 13. Mostrar los títulos de las películas ordenados por año de estreno.


-- 14. Calcular el promedio de duración de las películas.

-- 15. Mostrar los actores que no nacieron en EE.UU.


-- 17. Mostrar el id de las películas que tienen más de un actor en su reparto.


-- 18. Calcular el número total de actores en la base de datos.


-- 19. Mostrar las películas que no tienen actores en el reparto.

-- 20. Seleccionar las películas estrenadas en los últimos 10 años.


-- 22. Dime la moda del año de nacimiento de los actores.
SELECT anio_nacimiento, COUNT(anio_nacimiento) as frecuencia
FROM actor
GROUP BY anio_nacimiento
ORDER BY frecuencia DESC;
