-- Soluciones a los ejercicios

-- 1. Listar todos los nombres de las procesiones.
SELECT nombre FROM semana_santa.procesion;

-- 2. Mostrar los barrios donde se realizan las procesiones, sin repetir.
SELECT DISTINCT barrio FROM semana_santa.procesion;

-- 3. Obtener el nombre y la hora de inicio de todas las procesiones que comienzan después de las 18:00.
SELECT nombre, hora_inicio FROM semana_santa.procesion where hora_inicio > "18:00:00";

-- 4. Seleccionar el nombre y estilo de todos los pasos.
SELECT nombre,estilo FROM semana_santa.paso;

-- 5. Mostrar el nombre de las hermandades que tienen más de 100 costaleros.
SELECT * FROM semana_santa.hermandad where numero_costaleros > 100;

-- 6. Listar las procesiones que ocurren el Viernes Santo.
SELECT * FROM semana_santa.procesion where dia_semana = "Viernes Santo";

-- 7. Mostrar los puntos de paso de las procesiones que pasan por 'Catedral'.
SELECT * FROM semana_santa.itinerario;

-- 8. Obtener las procesiones que tienen lugar en el barrio 'Centro'.
SELECT * FROM semana_santa.itinerario where punto = "Catedral";

-- 9. Listar los estilos de pasos únicos.
SELECT DISTINCT estilo FROM semana_santa.paso;

-- 10. Mostrar los nombres de los pasos que pesan más de 1900 kg.
SELECT * FROM semana_santa.paso where peso > 1900;

-- 11. Listar los pasos cuyo peso esté entre 1800 y 2200 kg.
SELECT * FROM semana_santa.paso where peso > 1800 and peso < 2200;

-- 12. Mostrar las hermandades fundadas antes del año 1600.
SELECT * FROM semana_santa.hermandad where antiguedad < 1600;


-- 13. Seleccionar las procesiones que comienzan después de las 19:00 y están en el barrio 'Realejo'.

SELECT * FROM semana_santa.procesion where barrio = "Realejo" and hora_inicio > "19:00:00";


-- 14. Listar las hermandades que tienen más de 80 costaleros o fueron fundadas después de 1900.
SELECT * FROM semana_santa.hermandad where numero_costaleros > 80 or antiguedad > 1900;

-- 15. Mostrar las procesiones que no se realizan el Domingo de Ramos.
SELECT * FROM semana_santa.procesion where dia_semana != "Domingo de Ramos";
-- 16. Mostrar todas las procesiones ordenadas por la hora de inicio en orden ascendente.
SELECT * FROM semana_santa.procesion order by hora_inicio desc;

-- 17. Listar las hermandades ordenadas por antigüedad de forma descendente.
select * from hermandad order by antiguedad desc;

-- 18. Seleccionar los pasos ordenados por peso y, en caso de empate, por estilo alfabético.
SELECT * FROM semana_santa.paso order by peso desc , estilo asc;

-- 20. Mostrar los puntos de paso de las procesiones ordenados por hora de paso en orden descendente.
SELECT * FROM semana_santa.itinerario order by hora_paso asc;
-- 21. Contar cuántas procesiones hay en total.


-- 22. Obtener el peso promedio de todos los pasos.


-- 23. Calcular el número máximo de costaleros en una hermandad.


-- 24. Obtener el número de procesiones que se realizan en el barrio 'Albaicín'.


-- 25. Sumar el peso de todos los pasos.
SELECT sum(peso) FROM semana_santa.paso;

-- 26. Agrupar las procesiones por barrio y contar cuántas procesiones hay en cada uno.
SELECT barrio, count(*) as procesiones FROM semana_santa.procesion group by barrio;

-- 27. Calcular el peso total de los pasos agrupados por estilo.
SELECT estilo, sum(peso) AS peso_total 
FROM semana_santa.paso 
GROUP BY estilo;

-- 28. Mostrar las hermandades agrupadas por número de costaleros, filtrando aquellas con más de 100 costaleros.


-- 29. Obtener el número de procesiones que tienen puntos de paso después de las 20:00.


-- 30. Agrupar las hermandades por antigüedad y contar cuántas hay en cada rango.


-- 31. Concatenar el nombre y barrio de cada procesión en un único campo, separados por un guion.

-- 32. Mostrar las procesiones cuyos nombres contienen más de 10 caracteres.

-- 33. Seleccionar los nombres de las procesiones que contienen la palabra 'Soledad'.

-- 34. Mostrar las hermandades ordenadas por el número de costaleros en orden ascendente.


-- 35. Listar los nombres de los pasos en los que la palabra 'Virgen' no aparece.


-- 36. Calcular la diferencia entre el peso máximo y mínimo de los pasos.


-- 37. Mostrar solo las procesiones cuyo nombre no empieza con 'La'.


-- 38. Formatear la hora de inicio de las procesiones en formato de 12 horas con AM/PM.


-- 39. Mostrar solo la hora (sin minutos ni segundos) del paso por cada punto del itinerario.


-- 40. Seleccionar las procesiones que tienen su inicio en las próximas 6 horas a partir de la fecha y hora actual.




-- EXTRAS
-- 41. Redondear el peso de los pasos a la centena más cercana.
SELECT *, round(peso,-3) FROM semana_santa.paso ;


-- 42. Mostrar el peso de los pasos dividido entre 1000, con dos decimales.


-- 43. Generar un número aleatorio entre 1 y 100.


select anio_nacimiento from actor group by anio_nacimiento having count(*)=(select max(conteo) from (SELECT count( *) as conteo, anio_nacimiento FROM actor GROUP BY anio_nacimiento) p);