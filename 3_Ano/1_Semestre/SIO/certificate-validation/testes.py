import os
from cryptography import x509

with open("cert.cer", "rb") as f:
    data = f.read()
    cert = x509.load_pem_x509_certificate(data)
    print(data)
    print(cert)

