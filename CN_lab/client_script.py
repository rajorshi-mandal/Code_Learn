import netpack

def client():
    # Create a TCP socket
    client_socket = netpack.create_tcp_socket()

    # Define the server address
    SERVER_ADDR = ('localhost', 12345)

    # Connect to the server
    netpack.connect_to_tcp_server(client_socket, SERVER_ADDR)
    
    while True:
        # Send data to server
        message = input("Client: ")
        netpack.send_data_to_tcp_server(client_socket, message)

        # Receive data from server
        received_data = netpack.read_data_from_tcp_server(client_socket)
        print("Server:", received_data)

if __name__ == "__main__":
    client()

