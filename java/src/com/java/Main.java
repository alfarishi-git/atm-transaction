package com.java;

import java.util.Scanner;
import java.io.Console;

public class Main{

	public static float balance = 0;

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		Console console = System.console();

		int chooseMenu;
		boolean isTrue = true;
		String pin;

		System.out.print("Enter your PIN number : ");
		pin = new String (console.readPassword());
		switch (pin) {
			case "14045":
				while (isTrue){
					System.out.println("\n===== ATM =====");
					System.out.println("1. Balance");
					System.out.println("2. Withdraw");
					System.out.println("3. Deposit");
					System.out.println("4. Exit");
					System.out.print("Choose menu : ");
					chooseMenu = userInput.nextInt();
					switch (chooseMenu) {
						case 1:
							System.out.println("\n===== BALANCE =====");
							if (balance < 0){
								System.out.println("You're broke :((");
							} else {
								System.out.println("Your balance is " + balance);
							}
							break;
						case 2:
							System.out.println("\n===== WITHDRAW =====");
							withdraw();
							break;
						case 3:
							System.out.println("\n===== DEPOSIT =====");
							deposit();
							break;
						case 4:
							System.out.println("\nThank you for using ATM.\nHave a good day! Bye...");
							isTrue = false;
							break;
						default:
							System.out.println("Choose menu correctly!");
					}
				}
				break;
			default:
				System.out.println("Wrong PIN!");	
		}
	}

	static void withdraw(){

		Scanner userInput = new Scanner(System.in);

		float inputWithdraw;
		String isSure;
		
		System.out.println("Your balance is " + balance);
		if (balance != 0) {
			System.out.print("How much money do you want to withdraw : Rp.");
			inputWithdraw = userInput.nextFloat();
			System.out.print("Are you sure want to withdraw Rp."+ inputWithdraw + "?\n[y/n] > ");
			isSure = userInput.next();
			if (isSure.equalsIgnoreCase("y")) {
				System.out.println("Please wait...");
				try{
					Thread.sleep(3000);
				} catch (Exception e) {}

				System.out.println("Your withdraw is success!");
				System.out.println("Don't forget to check your balance");
				balance -= inputWithdraw;
			} else{
				System.out.println("Your withdraw is cancelled");
			}
		} else {
			System.out.println("You can't withdraw without balance!");
			System.out.println("Please deposit your money first.");
		}
	}

	static void deposit(){

		Scanner userInput = new Scanner(System.in);

		float inputDeposit;
		String isSure;

		System.out.print("Enter deposit amount : Rp.");
		inputDeposit = userInput.nextFloat();
		System.out.print("Are you sure want to deposit Rp." + inputDeposit + "?\n[y/n] > ");
		isSure = userInput.next();
		if (isSure.equalsIgnoreCase("y")) {
			System.out.println("Please wait...");
			try{
				Thread.sleep(3000);
			} catch (Exception e) {}

			System.out.println("Your deposit is success!");
			System.out.println("Check your balance.");
			balance += inputDeposit;
		} else {
			System.out.println("Your deposit is canceled.");
		}
	}
}