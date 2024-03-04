import sys
import socket
import netpack as npk

print("This is Client Side ->")

loopback_address = socket.gethostbyname('localhost')

c = npk.create_tcp_socket()
ADDR = (loopback_address, 3000)

try:
    npk.connect_to_tcp_server(c, ADDR)
    print("Connected to server at:", ADDR)
except Exception as e:
    print("Error connecting to server:", e)
    sys.exit(1)


connection_status = True

while connection_status:
        # Get user input for sending message to the server
        message = input("Client: ")
        npk.send_data_to_tcp_server(c, message)

        # Check for incoming messages from the server
        client_data = npk.read_data_from_tcp_server(c)
        if(client_data == 'close_connection'):
            npk.send_data_to_tcp_server(c, client_data)
            print("Connection Closed!")
            npk.close_socket_connection(c)
            connection_status = False
            continue
        print(client_data)