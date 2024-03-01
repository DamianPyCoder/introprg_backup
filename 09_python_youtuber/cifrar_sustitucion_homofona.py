import random

def cifrar_sustitucion_homofona(texto):
    homofonos = {'a': '42', 'b': '91', 'c': '37', 'd': '13'}  # Agrega más homófonos según sea necesario
    texto_cifrado = ''

    for caracter in texto:
        homofono = homofonos.get(caracter.lower(), None)
        if homofono:
            texto_cifrado += homofono + ' '
        else:
            texto_cifrado += caracter

    return texto_cifrado.strip()

# Solicitar palabra al usuario
texto_original = input("Introduce una palabra: ")

# Aplicar cifrado de sustitución homófona
texto_cifrado = cifrar_sustitucion_homofona(texto_original)
print("Texto cifrado:", texto_cifrado)
