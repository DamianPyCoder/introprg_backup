def cifrar_hill(texto, clave):
    longitud_bloque = len(clave)
    texto_cifrado = ''

    for i in range(0, len(texto), longitud_bloque):
        bloque = texto[i:i + longitud_bloque]
        vector = [ord(letra) - ord('a') for letra in bloque]

        for k in range(longitud_bloque):
            suma = sum(clave[k][l] * vector[l] for l in range(longitud_bloque))
            texto_cifrado += chr((suma % 26) + ord('a'))

    return texto_cifrado

# Solicitar palabra al usuario
texto_original = input("Introduce una palabra: ")

# Definir la clave (matriz)
clave = [[1, 2], [3, 4]]  # Ejemplo de una matriz de clave 2x2

# Aplicar cifrado de Hill
texto_cifrado = cifrar_hill(texto_original, clave)
print("Texto cifrado:", texto_cifrado)
