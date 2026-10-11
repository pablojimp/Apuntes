
stock = int(input("introduce la cantidad de stock: "))


def clasificar_stock(stock):
    resultado = ""
    if(stock<0):
        resultado = "no se acptan numeros negativos"
    elif(stock >= 0 and stock < 1):
        resultado = "Agotado" 
    elif(stock >= 1 and stock <= 5):
        resultado = "Bajo"
    elif(stock > 5):
        resultado = "Suficiente"
        
    return resultado

print(f"El stock actual es: {clasificar_stock(stock)}")