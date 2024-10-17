from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import serialization
import sys

def create_private_rsa(size):
    private_key = rsa.generate_private_key(public_exponent=65537, key_size=size)
    public_key = private_key.public_key()

    pem = private_key.private_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PrivateFormat.TraditionalOpenSSL,
        encryption_algorithm=serialization.NoEncryption()
    )

    pubic_pem = public_key.public_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PublicFormat.SubjectPublicKeyInfo
    )

    with open("private.pem", "wb") as f:
        f.write(pem)

    with open("public.pem", "wb") as f:
        f.write(pubic_pem)

    return private_key, public_key



sizes = [1024, 2048, 3070, 4096]

while True:
    try:
        size = int(input("Key size (1024, 2048, 3072 or 4096): "))
        if size in sizes:
            break 
        else:
            print("Please use a valid key size\n")
    except ValueError:
        print("Invalid input! Please enter a number.\n")

create_private_rsa(size)
    

