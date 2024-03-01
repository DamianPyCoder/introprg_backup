def cifrar_transposicion(texto):
    texto_cifrado = texto[::-1]
    return texto_cifrado

# Solicitar palabra al usuario
texto_original = input("Introduce una palabra: ")

# Aplicar cifrado de transposición
texto_cifrado = cifrar_transposicion(texto_original)
print("Texto cifrado:", texto_cifrado)
