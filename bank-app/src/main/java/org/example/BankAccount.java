package org.example;

public class BankAccount {
    private int accountNumber;
    private String name;
    private double balance;

    public BankAccount(int accountNumber, String name, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("[Warning] Invalid deposit amount. Amount can not be less than zero.");
            return;
        }
        balance += amount;
        System.out.println("[Info] RWF " + amount + " deposited. New balance is: RWF" + balance);
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("[Warning] Insufficient funds. Please enter a valid amount.");
            return;
        }
        balance -= amount;
        System.out.println("[Info] RWF " + amount + " withdrawn. Your new balance is: RWF " + balance);
    }

    public void checkBalance() {
        System.out.println("[Info] Your balance is RWF " + balance);
    }
}
