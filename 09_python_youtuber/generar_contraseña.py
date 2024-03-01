import random
import string

def generar_contraseña(longitud=12):
    caracteres = string.ascii_letters + string.digits + string.punctuation
    contraseña = ''.join(random.choice(caracteres) for _ in range(longitud))
    return contraseña

longitud_contraseña = int(input("Ingrese la longitud de la contraseña deseada: "))
contraseña_generada = generar_contraseña(longitud_contraseña)
print("Contraseña generada:", contraseña_generada)
