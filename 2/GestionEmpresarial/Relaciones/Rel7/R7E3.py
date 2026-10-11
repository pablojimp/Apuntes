# Crea un diccionario cliente con las claves nombre, ciudad, email y activo. Muestra
# todos los campos. Después cambia la ciudad, añade la clave telefono y vuelve a
# mostrar la ficha.

cliente = {
    "nombre": "Carlos",
    "ciudad": "Granada",
    "email": "Carlos@gmail.com",
    "activo": True
    
}

cliente_anterior = cliente.copy()

cliente["ciudad"] = "Sevilla"
cliente["telefono"] = "600000000"

print(f"{cliente_anterior}\n{cliente}")

