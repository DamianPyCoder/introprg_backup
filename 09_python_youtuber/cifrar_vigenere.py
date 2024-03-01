def cifrar_vigenere(texto, clave):
    texto_cifrado = ''
    longitud_clave = len(clave)

    for i, caracter in enumerate(texto):
        desplazamiento = ord(clave[i % longitud_clave]) - ord('a') if caracter.isalpha() else 0

        if caracter.isalpha():
            base = 'a' if caracter.islower() else 'A'
            cifrado = chr(((ord(caracter) - ord(base) + desplazamiento) % 26) + ord(base))
            texto_cifrado += cifrado
        else:
            texto_cifrado += caracter

    return texto_cifrado

# Solicitar palabra y clave al usuario
texto_original = input("Introduce una palabra: ")
clave = input("Introduce la clave: ")

# Aplicar cifrado Vigenère
texto_cifrado = cifrar_vigenere(texto_original, clave)
print("Texto cifrado:", texto_cifrado)
