from collections import Counter

def encontrar_mas_frecuente_counter(lista):
    contador = Counter(lista)
    numero_mas_frecuente = contador.most_common(1)[0][0]
    return numero_mas_frecuente

def encontrar_mas_frecuente_diccionario(lista):
    frecuencia_numeros = {}
    for num in lista:
        if num in frecuencia_numeros:
            frecuencia_numeros[num] += 1
        else:
            frecuencia_numeros[num] = 1
    numero_mas_frecuente = max(frecuencia_numeros, key=frecuencia_numeros.get)
    return numero_mas_frecuente

# Lista de ejemplo
lista = [1, 2, 3, 4, 2, 2, 3, 4, 4, 4]

# Utilizando Counter
resultado_counter = encontrar_mas_frecuente_counter(lista)
print("Utilizando Counter, el número más frecuente en la lista es:", resultado_counter)

# Utilizando diccionario
resultado_diccionario = encontrar_mas_frecuente_diccionario(lista)
print("Utilizando diccionario, el número más frecuente en la lista es:", resultado_diccionario)
