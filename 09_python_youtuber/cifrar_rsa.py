from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP

def cifrar_rsa(texto, clave_publica):
    cipher_rsa = PKCS1_OAEP.new(clave_publica)
    texto_cifrado = cipher_rsa.encrypt(texto.encode())
    return texto_cifrado

def descifrar_rsa(texto_cifrado, clave_privada):
    cipher_rsa = PKCS1_OAEP.new(clave_privada)
    texto_descifrado = cipher_rsa.decrypt(texto_cifrado).decode()
    return texto_descifrado

# Generar claves RSA
clave_privada = RSA.generate(2048)
clave_publica = clave_privada.publickey()

# Solicitar palabra al usuario
texto_original = input("Introduce una palabra: ")

# Aplicar cifrado RSA
texto_cifrado = cifrar_rsa(texto_original, clave_publica)
print("Texto cifrado:", texto_cifrado)

# Descifrar texto cifrado
texto_descifrado = descifrar_rsa(texto_cifrado, clave_privada)
print("Texto descifrado:", texto_descifrado)
