lista = [8, 3, 6, 1, 2, 7, 4, 5]
n = len(lista)
for i in range(n):
    for j in range(0, n - i - 1):
        if lista[j] > lista[j + 1]:
            lista[j], lista[j + 1] = lista[j + 1], lista[j]

print("Lista ordenada:", lista)  # Resultado: [1, 2, 3, 4, 5, 6, 7, 8]
