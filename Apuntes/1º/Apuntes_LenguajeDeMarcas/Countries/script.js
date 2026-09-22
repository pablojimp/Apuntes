
async function obtenerPaisNombre(nombrePais) {
    const apiUrl = "https://restcountries.com/v3.1/name/";
    try {
        const respuesta = await fetch(`${apiUrl}${nombrePais}`);
        if (!respuesta.ok) {
            throw new Error("No se encontró el País");
        }
        const datos = await respuesta.json();
        mostrarPais(datos[0]);
    } catch (error) {
        console.error("Error al obtener el País:", error);
    }
}


function mostrarPais(datos) {
    const contenedor = document.getElementById("resultado-nombre");
    let lenguas = "", dineros = "";
    for (const nombre in datos.languages) {
        lenguas += `<li>${datos.languages[nombre]}</li>`;
    }
    for (const dinero in datos.currencies) {
        dineros += `<li>${datos.currencies[dinero].name} (${datos.currencies[dinero].symbol})</li>`;
    }
    contenedor.classList.add("tarjeta-detalle")
    contenedor.innerHTML = `
        <img src="${datos.flags.svg}">
        <p>${datos.name.common}</p>
        <p>${datos.name.official}</p>
        <p>${datos.capital}</p>
        <p>${datos.region}</p>
        <p>${datos.subregion}</p>
        <p>${datos.population}</p>
        <ul>${lenguas}</ul>
        <ul>${dineros}</ul>
        `;

}
document.getElementById("form-nombre").addEventListener("submit", function (event) {
    event.preventDefault();
    const input = document.getElementById("input-nombre").value.trim().toLowerCase();
    if (input) {
        obtenerPaisNombre(input);
    }
});



document.querySelectorAll(".btn-region").forEach(boton => {
    boton.addEventListener("click", function () {
        const region = this.dataset.region;
        obtenerPaisesPorRegion(region);
    });
});

async function obtenerPaisesPorRegion(region) {
    const respuesta = await fetch(`https://restcountries.com/v3.1/region/${region}`);
    const datos = await respuesta.json();
    mostrarRegion(datos);
}


function mostrarRegion(datos) {
    const contenedor = document.getElementById("resultado-region");
    contenedor.innerHTML = "";
    datos.slice(0,12).forEach(pais => {
        const tarjeta = document.createElement("div");
        tarjeta.classList.add("tarjeta");

        tarjeta.innerHTML = `
            <img src="${pais.flags.svg}">
            <h3>${pais.name.common}</h3>
            <p><strong>Capital:</strong> ${pais.capital[0]}</p>
            <p><strong>Población:</strong> ${pais.population}</p>
        `;

        contenedor.appendChild(tarjeta);
    });
}




document.getElementById("form-capital").addEventListener("submit", function (event) {
    event.preventDefault();
    const input = document.getElementById("input-capital").value.trim().toLowerCase();
    if (input) {
        obtenerPaisCapital(input);
    }
});

async function obtenerPaisCapital(capital) {
    const apiUrl = "https://restcountries.com/v3.1/capital/"
    try {
        const respuesta = await fetch(`${apiUrl}${capital}`);
        if (!respuesta.ok) {
            throw new Error("No se encontró el País");
        }
        const datos = await respuesta.json();
        mostrarPaisCapital(datos[0]);
    } catch (error) {
        console.error("Error al obtener el País:", error);
    }
}

function mostrarPaisCapital(datos) {
    const contenedor = document.getElementById("resultado-capital");
    let lenguas = "", dineros = "";
    for (const nombre in datos.languages) {
        lenguas += `<li>${datos.languages[nombre]}</li>`;
    }
    for (const dinero in datos.currencies) {
        dineros += `<li>${datos.currencies[dinero].name} (${datos.currencies[dinero].symbol})</li>`;
    }
    contenedor.innerHTML = `
        <img src="${datos.flags.svg}">
        <p>${datos.name.common}</p>
        <p>${datos.name.official}</p>
        <p>${datos.capital}</p>
        <p>${datos.region}</p>
        <p>${datos.subregion}</p>
        <p>${datos.population}</p>
        <ul>${lenguas}</ul>
        <ul>${dineros}</ul>
        `;
}


document.getElementById("form-codigo").addEventListener("submit", function (event) {
    event.preventDefault();
    const input = document.getElementById("input-codigo").value.trim().toLowerCase();
    if (input) {
        obtenerPaisCodigo(input);
    }
});

async function obtenerPaisCodigo(codigo) {
    const apiUrl = "https://restcountries.com/v3.1/alpha/"
    try {
        const respuesta = await fetch(`${apiUrl}${codigo}`);
        if (!respuesta.ok) {
            throw new Error("No se encontró el País");
        }
        const datos = await respuesta.json();
        mostrarPaisCodigo(datos[0]);
    } catch (error) {
        console.error("Error al obtener el País:", error);
    }
}

function mostrarPaisCodigo(datos) {
    const contenedor = document.getElementById("resultado-codigo");
    let lenguas = "", dineros = "";
    for (const nombre in datos.languages) {
        lenguas += `<li>${datos.languages[nombre]}</li>`;
    }
    for (const dinero in datos.currencies) {
        dineros += `<li>${datos.currencies[dinero].name} (${datos.currencies[dinero].symbol})</li>`;
    }
    contenedor.innerHTML = `
        <img src="${datos.flags.svg}">
        <p>${datos.name.common}</p>
        <p>${datos.name.official}</p>
        <p>${datos.capital}</p>
        <p>${datos.region}</p>
        <p>${datos.subregion}</p>
        <p>${datos.population}</p>
        <ul>${lenguas}</ul>
        <ul>${dineros}</ul>
        `;
}

const botonrapido = document.getElementById("btn-todos")
botonrapido.addEventListener("click", function () {
    obtenerPaisesRapidos();
});

async function obtenerPaisesRapidos() {
    const apiUrl = "https://restcountries.com/v3.1/all?fields=name,flags,capital,population"
    try {
        const respuesta = await fetch(`${apiUrl}`);
        if (!respuesta.ok) {
            throw new Error("No se encontró el País");
        }
        const datos = await respuesta.json();
        mostrarPaisesRapidos(datos);
    } catch (error) {
        console.error("Error al obtener el País:", error);
    }
}



function mostrarPaisesRapidos(datos) {
    const contenedor = document.getElementById("resultado-todos");
    contenedor.innerHTML = "";
    for (let i = 0; i < 12; i++) {

        const tarjeta = document.createElement("div");
        tarjeta.classList.add("tarjeta");

        tarjeta.innerHTML = `
                <img src="${datos[i].flags.svg}">
                <h3>${datos[i].name.common}</h3>
                <p><strong>Capital:</strong> ${datos[i].capital[0]}</p>
                <p><strong>Población:</strong> ${datos[i].population}</p>
            `;

        contenedor.appendChild(tarjeta);
    }
};