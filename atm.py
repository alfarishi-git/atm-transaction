import getpass
import time

balance = 0

def menu():
	while True:
		print("\n===== ATM =====")
		print("1. Balance")
		print("2. Withdraw")
		print("3. Deposit")
		print("4. Exit")
		choose_menu = int(input("Choose menu : "))
		if choose_menu == 1:
			print("\n===== BALANCE =====")
			print("Your balance is",balance)
		elif choose_menu == 2:
			print("\n===== WITHDRAW =====")
			withdraw()
		elif choose_menu == 3:
			print("\n===== DEPOSIT =====")
			deposit()
		elif choose_menu == 4:
			exit()
		else:
			print("Choose menu correctly!")

def login():
	print("===== LOGIN =====")
	input_pin = getpass.getpass("Enter your pin : ")
	if input_pin == "6661":
		menu()
	else:
		print("Wrong pin!")

def withdraw():
	global balance
	print("Your balance now is",balance)
	if balance != 0:
		input_withdraw = float(input("How much do you want to withdraw?\n> Rp."))
		balance = balance - input_withdraw
		print("Are you sure want to withdraw Rp.",input_withdraw,"?")
		isSure = input("[y/n] > ")
		if isSure == "y":
			print("Please wait...")
			time.sleep(2)
			print("Your withdraw is success!")
			print("Don't forget to check your balance")
		else:
			print("Your withdraw is cancelled")
	else:
		print("You can't withdraw without balance!")
		print("Please deposit your money first.")

def deposit():
	global balance
	input_deposit = float(input("Enter deposit amount : Rp."))
	balance = balance + input_deposit
	print("Are you sure want to deposit Rp.",input_deposit,"?")
	isSure = input("[y/n] > ")
	if isSure == "y":
		print("Please wait...")
		time.sleep(2)
		print("Your deposit is success!")
	else:
		print("Your deposit is cancelled")

login()