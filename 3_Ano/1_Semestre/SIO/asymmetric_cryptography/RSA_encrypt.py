from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import padding

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





def encrypt_file(fin, fout, size):
    private_key, public_key = create_private_rsa(size)

    with open(fin, "rb") as f:
        message = f.read()

    ciphertext = public_key.encrypt(message, padding.PKCS1v15())

    with open(fout, "wb") as f:
        ciphertext = f.write(ciphertext)

encrypt_file("teste.txt", "resultado.txt", 2048)
