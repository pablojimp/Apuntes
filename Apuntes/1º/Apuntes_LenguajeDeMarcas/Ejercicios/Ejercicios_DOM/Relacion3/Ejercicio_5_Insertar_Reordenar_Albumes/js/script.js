let albumes = document.getElementById("albumes");
let talco = document.getElementById("talco");
let pegatina = document.createElement("li");
let locos = document.createElement("li");

// Nuevo li antes de Talco
pegatina.textContent = '"Xapomelon" - La Pegatina';
albumes.insertBefore(pegatina, talco);

// Nuevo li al final
locos.textContent = '"Street Gigs" - The Locos';
albumes.appendChild(locos);