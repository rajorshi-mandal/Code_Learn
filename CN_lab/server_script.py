import netpack

def server():
    # Create a TCP socket
    server_socket = netpack.create_tcp_socket()

    # Define the server address
    ADDR = ('localhost', 12345)

    # Start the TCP server
    netpack.start_tcp_server(server_socket, ADDR)
    
    # Accept client connection
    client_socket, _ = netpack.accept_tcp_client(server_socket)
    
    while True:
        # Receive data from client
        received_data = netpack.read_data_from_tcp_client(client_socket)
        print("Client:", received_data)

        # Send data to client
        message = input("Server: ")
        netpack.send_data_to_tcp_client(client_socket, message)

if __name__ == "__main__":
    server()

