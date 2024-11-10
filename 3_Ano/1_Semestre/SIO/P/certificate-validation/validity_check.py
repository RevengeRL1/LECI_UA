import argparse
import datetime
from utils import load_cert
from cryptography import x509


def valid(cert: x509.Certificate) -> bool:
    """This function verifies validity of the certificate given as argument, according to the current date


    Args:
        cert (x509.Certificate): the certificate to validate

    Returns:
        bool: True if the certificate is valid, False otherwise
    """
    
    # Code with the necessary logic
    current_time = datetime.datetime.now(tz=datetime.timezone.utc)

    if (cert.not_valid_before_utc >= current_time) or (cert.not_valid_after_utc <= current_time):
        return False 
    
    return True


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--certificate-file", "-f", required=True, help="File name of the certificate to validate")
    args = parser.parse_args()

    cert = load_cert(args.certificate_file)
    
    print(f"The given certificate was {'valid' if valid(cert) else 'invalid'}")


if __name__ == "__main__":
    main()

