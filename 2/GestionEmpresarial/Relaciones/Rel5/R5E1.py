

producto = input("Introduce el nombre del producto: ")
stock = int(input("introduce la cantidad de stock: "))

if(stock<0):
    resultado = "no se acptan numeros negativos"
elif(stock >= 0 and stock < 1):
    resultado = "Agotado" 
elif(stock >= 1 and stock <= 5):
    resultado = "Stock bajo"
elif(stock > 5):
    resultado = "Stock suficiente"
    
print(f"{resultado}")
