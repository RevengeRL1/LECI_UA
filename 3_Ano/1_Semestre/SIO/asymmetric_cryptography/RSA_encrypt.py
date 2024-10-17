from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import padding
from RSA_gen import create_private_rsa

def encrypt_file(fin, fout, size):
    private_key, public_key = create_private_rsa(size)

    with open(fin, "rb") as f:
        message = f.read()

    ciphertext = public_key.encrypt(message, padding.PKCS1v15())

    with open(fout, "wb") as f:
        ciphertext = f.write(ciphertext)