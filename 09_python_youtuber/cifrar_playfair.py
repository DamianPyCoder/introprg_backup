def cifrar_playfair(texto, clave):
    # Implementación del cifrado de Playfair aquí
    return texto

# Solicitar palabra y clave al usuario
texto_original = input("Introduce una palabra: ")
clave = input("Introduce la clave: ")

# Aplicar cifrado de Playfair
texto_cifrado = cifrar_playfair(texto_original, clave)
print("Texto cifrado:", texto_cifrado)
