import socket

def main():
    udp_s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    udp_s.bind(("127.0.0.1", 1234))

    while True:
        b_data, addr = udp_s.recvfrom(4096)
        b_data = b_data.decode('utf-8')
        if b_data == "1":
            response = 'Um'
            b_data = response.encode('utf-8')
            udp_s.sendto(b_data, addr)
        else:
            response = 'Dois'
            b_data = response.encode('utf-8')
            udp_s.sendto(b_data, addr)

    udp_s.close()

main()