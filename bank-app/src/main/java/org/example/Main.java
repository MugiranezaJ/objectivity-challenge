package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = createAccount(scanner);

        while (true) {
            showMenu();
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter deposit amount: RWF");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    }
                    case 2 -> {
                        System.out.print("Enter withdrawal amount: RWF");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                    }
                    case 3 -> account.checkBalance();
                    case 4 -> {
                        System.out.println("Thank you for using our service!");
                        System.exit(0);
                    }
                    default ->
                            System.out.println("[Warning] Invalid choice. Please choose a valid option from the menu.");
                }
            }catch (InputMismatchException e){
                System.out.println("\n[Warning] Your input must be a number");
                scanner.next();
            }
        }
    }

    private static BankAccount createAccount(Scanner scanner) {
        int accountNumber;
        double initialDeposit;
        System.out.println("---------------- Welcome to the Objectivity bank ---------------- !");
        do{
            System.out.print("[+] Enter account number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("[Warning] Account number must be a valid number.");
                scanner.next();
            }
            accountNumber = scanner.nextInt();
        }while (accountNumber < 0);

        System.out.print("[+] Enter account holder name: ");
        scanner.nextLine();
        String accountHolderName = scanner.nextLine();

        do{
            System.out.print("[+] Enter initial deposit amount: RWF ");
            while (!scanner.hasNextInt()) {
                System.out.println("[Warning] Initial deposit must be a valid number.");
                scanner.next();
            }
            initialDeposit = scanner.nextDouble();
            if(initialDeposit < 0){
                System.out.println("[Warning] Initial deposit can not be negative");
            }

        }while (initialDeposit < 0);


        return new BankAccount(accountNumber, accountHolderName, initialDeposit);
    }

    private static void showMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Deposit money");
        System.out.println("2. Withdraw money");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
        System.out.print("[+] Enter your choice: ");
    }
}
