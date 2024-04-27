import os
from random import randint

SAVINGS_WITHDRAW_LIMIT = 50000
INTEREST_RATE = 0.04
MIN_BALANCE_CURRENT = 5000
MIN_BALANCE_SAVINGS = 2000

# Function to generate a unique account number
def generate_account_number():
    min_length = 11
    max_length = 16
    length = randint(min_length, max_length)
    account_number = ''.join([str(randint(0, 9)) for _ in range(length)])
    return account_number

# Function to open a bank account
def open_account():
    account_type = input("Choose account type (1 for Current, 2 for Savings): ")
    username = input("Enter username: ")
    password = input("Enter password: ")

    account_type = "Current" if account_type == "1" else "Savings"
    account_number = generate_account_number()

    if account_type == "Current":
        initial_balance = MIN_BALANCE_CURRENT
    else:
        initial_balance = MIN_BALANCE_SAVINGS

    with open("accounts.txt", "a") as file:
        file.write(f"{account_number} {username} {password} {account_type} {initial_balance}\n")
    print("Account created successfully! Account Number:", account_number)
    print("Initial Balance:", initial_balance)

# Function to login
def login():
    username = input("Enter username: ")
    password = input("Enter password: ")

    with open("accounts.txt", "r") as file:
        for line in file:
            parts = line.split()
            acc_number, user, pwd, acc_type, _ = parts
            if user == username and pwd == password:
                return acc_number, username, acc_type
    print("Invalid username or password")
    return None, None, None

# Function to show account details
def show_account_details(username, account_type):
    print("Account Details:")
    print("Username:", username)
    print("Account Type:", account_type)
    with open("accounts.txt", "r") as file:
        for line in file:
            parts = line.split()
            if parts[1] == username:
                print("Account Number:", parts[0])
                print("Balance:", parts[4])

# Function to deposit money
def deposit(username):
    amount = float(input("Enter amount to deposit: "))
    with open("accounts.txt", "r") as file:
        lines = file.readlines()

    with open("accounts.txt", "w") as file:
        for line in lines:
            parts = line.split()
            if parts[1] == username:
                balance = float(parts[4]) + amount
                parts[4] = str(balance)
                line = ' '.join(parts) + '\n'
            file.write(line)

    with open("transactions.txt", "a") as file:
        file.write(f"{username} deposited {amount}\n")

    print("Deposit successful!")

# Function to withdraw money
def withdraw(username, acc_type):
    amount = float(input("Enter amount to withdraw: "))
    if acc_type == "Savings" and amount > SAVINGS_WITHDRAW_LIMIT:
        print("Withdrawal amount exceeds daily limit for Savings account")
        return

    with open("accounts.txt", "r") as file:
        lines = file.readlines()

    with open("accounts.txt", "w") as file:
        for line in lines:
            parts = line.split()
            if parts[1] == username:
                balance = float(parts[4])
                if acc_type == "Savings":
                    if balance >= amount:
                        balance -= amount
                    else:
                        print("Insufficient balance")
                        return
                elif acc_type == "Current":
                    if balance - amount >= MIN_BALANCE_CURRENT:
                        balance -= amount
                    else:
                        print(f"Minimum balance of {MIN_BALANCE_CURRENT} must be maintained in Current account.")
                        return
                parts[4] = str(balance)
                line = ' '.join(parts) + '\n'
            file.write(line)

    with open("transactions.txt", "a") as file:
        file.write(f"{username} withdrew {amount}\n")

    print("Withdrawal successful!")

# Function to transfer money
def transfer(username):
    recipient = input("Enter recipient username: ")
    amount = float(input("Enter amount to transfer: "))
    with open("accounts.txt", "r") as file:
        lines = file.readlines()

    sender_balance = None
    recipient_balance = None

    with open("accounts.txt", "w") as file:
        for line in lines:
            parts = line.split()
            if parts[1] == username:
                sender_balance = float(parts[4])
                if sender_balance >= amount:
                    sender_balance -= amount
                else:
                    print("Insufficient balance")
                    return
            elif parts[1] == recipient:
                recipient_balance = float(parts[4])
                recipient_balance += amount
            file.write(line)

    if sender_balance is not None and recipient_balance is not None:
        with open("accounts.txt", "a") as file:
            file.write(f"{recipient} {recipient_balance}\n")
        with open("transactions.txt", "a") as file:
            file.write(f"{username} transferred {amount} to {recipient}\n")
        print("Transfer successful!")
    else:
        print("Recipient username not found")

# Function to display passbook
def passbook(username):
    with open("transactions.txt", "r") as file:
        for line in file:
            if username in line:
                print(line.strip())

# Function to calculate interest and update balances
def calculate_interest():
    with open("accounts.txt", "r") as file:
        lines = file.readlines()

    with open("accounts.txt", "w") as file:
        for line in lines:
            parts = line.split()
            if parts[3] == "Savings":
                balance = float(parts[4]) * (1 + INTEREST_RATE/12)
                parts[4] = str(balance)
            file.write(' '.join(parts) + '\n')

# Main function
def main():
    while True:
        print("\nWelcome to the banking system")
        print("1. Open Account")
        print("2. Login")
        print("3. Update Savings Account Balances with Interest")
        print("4. Exit")
        choice = input("Enter your choice: ")

        if choice == "1":
            open_account()
        elif choice == "2":
            acc_number, username, account_type = login()
            if username:
                while True:
                    print(f"\nWelcome {username} ({account_type})")
                    print("1. Deposit")
                    print("2. Withdraw")
                    print("3. Transfer")
                    print("4. Passbook")
                    print("5. Show Account Details")
                    print("6. Logout")
                    choice = input("Enter your choice: ")

                    if choice == "1":
                        deposit(username)
                    elif choice == "2":
                        withdraw(username, account_type)
                    elif choice == "3":
                        transfer(username)
                    elif choice == "4":
                        passbook(username)
                    elif choice == "5":
                        show_account_details(username, account_type)
                    elif choice == "6":
                        break
                    else:
                        print("Invalid choice")
        elif choice == "3":
            calculate_interest()
            print("Savings account balances updated with interest.")
        elif choice == "4":
            print("Exiting...")
            break
        else:
            print("Invalid choice")

if __name__ == "__main__":
    main()
