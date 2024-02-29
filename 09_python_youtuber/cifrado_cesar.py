def cifrado_cesar(texto, desplazamiento):
    texto_cifrado = ''
    for caracter in texto:
        # Comprobamos si el caracter es una letra del alfabeto
        if caracter.isalpha():
            # Obtenemos el código ASCII del caracter
            codigo = ord(caracter)
            # Definimos si el caracter es mayúscula o minúscula
            if caracter.islower():
                # Aplicamos el desplazamiento y ajustamos si excede el rango de letras minúsculas
                codigo_cifrado = (codigo - 97 + desplazamiento) % 26 + 97
            elif caracter.isupper():
                # Aplicamos el desplazamiento y ajustamos si excede el rango de letras mayúsculas
                codigo_cifrado = (codigo - 65 + desplazamiento) % 26 + 65
            # Convertimos el código ASCII cifrado a su respectivo caracter
            caracter_cifrado = chr(codigo_cifrado)
            # Agregamos el caracter cifrado al texto cifrado
            texto_cifrado += caracter_cifrado
        else:
            # Si el caracter no es una letra, lo dejamos como está
            texto_cifrado += caracter
    return texto_cifrado

# Solicitar palabra y desplazamiento al usuario
texto_original = input("Introduce una palabra: ")
desplazamiento = int(input("Introduce el número de desplazamiento: "))

# Aplicar cifrado César
texto_cifrado = cifrado_cesar(texto_original, desplazamiento)
print("Texto cifrado:", texto_cifrado)
