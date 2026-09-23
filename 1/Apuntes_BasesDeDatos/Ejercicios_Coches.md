# Ejercicios sobre JOINs - Base de Datos Coches

## Descripción

Estos 20 ejercicios están basados en la base de datos **coches**, que contiene información de personas y sus vehículos. La mayoría de los ejercicios requieren el uso de **JOINS** para combinar datos de diferentes tablas.

**Tablas disponibles:**

- **personas**: id, nombre, apellido, sexo, fecha_nacimiento, provincia, municipio, nivel_estudios, ingresos_anuales, estado_civil, nivel_socioeconomico, ocupacion, madre, padre
- **coches**: id, id_dueño, marca, modelo, año_fabricacion, matricula, color

---

## Nivel 1: INNER JOIN Básicos

### 1. Muéstrame las Personas y sus coches (solo los que tengan algun coche)

SELECT \*  
FROM coches  
INNER JOIN personas ON coches.id_dueño = personas.id;

### 2. Coches con información de dueños como su nombre y su provincia

SELECT nombre, municipio  
FROM personas  
INNER JOIN coches ON personas.id = coches.id_dueño;

### 3. Personas que tienen coches y su estado civil.

SELECT nombre, estado_civil
FROM personas  
INNER JOIN coches ON personas.id = coches.id_dueño;

### 4. Coches de personas ricas (niv socioeconomico alto)

SELECT \*
FROM coches  
INNER JOIN personas ON coches.id_dueño = personas.id where nivel_socioeconomico = "Alto";

### 5. Ocupaciones de dueños de coches mayores de 30 años

SELECT \*
FROM coches  
INNER JOIN personas ON coches.id_dueño = personas.id where DATEDIFF(NOW(), fecha_nacimiento) / 365.25 > 30;

---

## Nivel 2: LEFT JOIN

### 6. Todas las personas y sus coches (incluyendo sin coches)

SELECT \*  
FROM personas  
LEFT JOIN coches ON personas.id = coches.id_dueño;

### 7. Personas sin coches registrados

SELECT \*  
FROM personas  
LEFT JOIN coches ON coches.id_dueño IS NULL;

### 8. Provincias con y sin representación de coches

SELECT DISTINCT provincia  
FROM personas  
LEFT JOIN coches ON personas.id = coches.id_dueño;

### 9. Nivel de estudios de las personas sin coche

SELECT nombre,nivel_estudios
FROM personas  
LEFT JOIN coches ON coches.id_dueño IS NULL;

### 10. Personas jubiladas con sus vehículos

SELECT \*
FROM coches  
left JOIN personas ON coches.id_dueño = personas.id where DATEDIFF(NOW(), fecha_nacimiento) / 365.25 > 65;

---

## Nivel 3: JOINS con Agregaciones

### 11. Número de coches por persona

SELECT personas.id,personas.nombre,COUNT(coches.id) AS total_coches
FROM personas  
LEFT JOIN coches ON personas.id = coches.id_dueño
GROUP BY personas.id;

### 12. Marca más común entre personas de cada provincia

SELECT personas.provincia,Coches.marca,COUNT(coches.id) AS total
FROM personas
INNER JOIN coches ON personas.id = coches.id_dueño
WHERE coches.marca GROUP BY personas.provincia, coches.marca ORDER BY personas.provincia, total DESC;

### 13. Promedio de edad de dueños por marca de coche

SELECT coches.marca, AVG(DATEDIFF(NOW(), fecha_nacimiento) / 365.25) AS promedio_edad
FROM coches
INNER JOIN personas ON coches.id_dueño = personas.id
GROUP BY coches.marca
ORDER BY promedio_edad DESC;

### 14. Total de ingresos de dueños por color de coche

SELECT color, COUNT(\*) AS cantidad_coches, sum(ingresos_anuales) AS total_ingresosporcolor
FROM coches
INNER JOIN personas ON coches.id_dueño = personas.id
GROUP BY color
ORDER BY cantidad_coches DESC;

### 15. Municipios con más coches

SELECT personas.municipio, COUNT(\*) AS cantidad_coches
FROM coches
INNER JOIN personas ON coches.id_dueño = personas.id
GROUP BY municipio
ORDER BY cantidad_coches DESC;

---

## Nivel 4: JOINS Complejos (Autojoins y múltiples tablas)

### 16. Padres e hijos y sus coches

SELECT
p1.nombre AS nombre_padre,
p2.nombre AS nombre_hijo,
c1.modelo AS coche_padre,
c2.modelo AS coche_hijo
FROM personas p1
INNER JOIN personas p2 ON p1.id = p2.padre
LEFT JOIN coches c1 ON c1.id_dueño = p1.id
LEFT JOIN coches c2 ON c2.id_dueño = p2.id;

### 17. Parejas con algún hijo y sus coches

### 18. Personas de la misma familia con más de dos coches

## Consejos para la resolución

### Sintaxis básica de JOINs:

```sql
-- INNER JOIN (solo coincidencias)
SELECT * FROM personas
INNER JOIN coches ON personas.id = coches.id_dueño;

-- LEFT JOIN (todas las de la izquierda, coincidencias si existen)
SELECT * FROM personas
LEFT JOIN coches ON personas.id = coches.id_dueño;

-- SELF JOIN (una tabla unida consigo misma con alias)
SELECT p1.nombre, p2.nombre FROM personas p1
INNER JOIN personas p2 ON p1.id = p2.padre;
```

### Puntos importantes:

- Usa **alias** para las tablas en JOINs complejos (ej: `personas p1`, `personas p2`)
- Recuerda incluir la cláusula **ON** para especificar la condición del JOIN
- Usa **GROUP BY** cuando agregues datos
- Ten cuidado con los **NULL** en campos como madre/padre
- Prueba tus JOINs paso a paso para asegurar la correcta relación entre tablas
