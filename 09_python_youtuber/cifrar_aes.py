from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes
from Crypto.Util.Padding import pad, unpad

def cifrar_aes(texto, clave):
    cipher = AES.new(clave, AES.MODE_CBC, iv=get_random_bytes(16))
    texto_cifrado = cipher.encrypt(pad(texto.encode(), AES.block_size))
    return texto_cifrado

def descifrar_aes(texto_cifrado, clave):
    cipher = AES.new(clave, AES.MODE_CBC, iv=get_random_bytes(16))
    texto_descifrado = unpad(cipher.decrypt(texto_cifrado), AES.block_size).decode()
    return texto_descifrado

# Solicitar palabra al usuario
texto_original = input("Introduce una palabra: ")
clave = get_random_bytes(16)  # Clave de 16 bytes para AES

# Aplicar cifrado AES
texto_cifrado = cifrar_aes(texto_original, clave)
print("Texto cifrado:", texto_cifrado)

# Descifrar texto cifrado
texto_descifrado = descifrar_aes(texto_cifrado, clave)
print("Texto descifrado:", texto_descifrado)
