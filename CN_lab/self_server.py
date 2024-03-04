import sys
import socket
import netpack as npk
import time
import select

print("This is Server Side ->")

loopback_address = socket.gethostbyname('localhost')

s = npk.create_tcp_socket()
ADDR = (loopback_address, 3000)

npk.start_tcp_server(s, ADDR)

start_time = time.time()
duration = 10  # 10 seconds timeout for connection

try:
    while True:
        elapsed_time = time.time() - start_time
        remaining_time = duration - elapsed_time
        if remaining_time <= 0:
            print("\nConnection timeout! No client connected within 10 seconds.")
            sys.exit(1)

        print(f"\rWaiting for connection from client: {int(remaining_time)} seconds", end="")
        sys.stdout.flush()  # Flush the output to ensure it's displayed immediately
        
        # Using select to check if there is any client connection
        rlist, _, _ = select.select([s], [], [], 0.1)  # Check for readability with a timeout of 0.1 seconds
        if rlist:
            c_s, addr = npk.accept_tcp_client(s)
            print("\nConnection accepted from client at: ", addr)
            break  # Break out of the loop once connection is established

except KeyboardInterrupt:
    print("\nServer stopped.")
    
connection_status = True

while connection_status:
    if connection_status == False:
        npk.close_socket_connection(s)
    
    server_data = npk.read_data_from_tcp_client(c_s)
    if(server_data == 'close_connection'):
        npk.send_data_to_tcp_client(c_s, server_data)
        print("Connection Closed!")
        npk.close_socket_connection(c_s)
        connection_status = False
        continue
    print(server_data)

    # Get user input for sending message to the client
    message = input("Server: ")
    npk.send_data_to_tcp_client(c_s, message)
