// script.js

// URL base de la API
const apiUrl = "https://pokeapi.co/api/v2/pokemon/";

// Función para obtener datos de un Pokémon por su nombre o ID
async function obtenerPokemon(nombreOId) {
    try {
        const respuesta = await fetch(`${apiUrl}${nombreOId}`);
        if (!respuesta.ok) {
            throw new Error("No se encontró el Pokémon");
        }
        const datos = await respuesta.json();
        mostrarPokemon(datos);
    } catch (error) {
        console.error("Error al obtener el Pokémon:", error);
    }
}

// Función para mostrar los datos del Pokémon en la página
function mostrarPokemon(datos) {
    const contenedor = document.getElementById("pokemon-info");
    let tipos = '', stats = '', juegos = ''

    //Tipos
    for (const tipo of datos.types) {
        tipos += tipo.type.name + ", "
    }

    //Stats
    for (const stat of datos.stats) {
        stats += `<li>${stat.stat.name}: ${stat.base_stat}</li>`
    }

    for (const juego of datos.game_indices) { 
        juegos += `<li>${juego.game_index}: ${juego.version.name}</li>`  
    }

    contenedor.innerHTML = `
        <h2>${datos.name.toUpperCase()}</h2>
        <img src="${datos.sprites.front_default}" alt="Imagen de ${datos.name}">
        <p><strong>ID:</strong> ${datos.id}</p>
        <p><strong>Altura:</strong> ${datos.height / 10} m</p>
        <p><strong>Peso:</strong> ${datos.weight / 10} kg</p>
        <p><strong>Tipos:</strong>${tipos}</p>
        <p><strong>Stats:</strong></p>
        <ul>
            ${stats}
        </ul>
        <p>Experiencia Base: ${datos.base_experience}</p>
        <ul>
            ${juegos}
        </ul>
    `
}

// Manejo del formulario de búsqueda
document.getElementById("pokemon-form").addEventListener("submit", function (event) {
    event.preventDefault();
    const input = document.getElementById("pokemon-input").value.trim().toLowerCase();
    if (input) {
        obtenerPokemon(input);
    }
});