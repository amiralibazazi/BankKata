package com.codurance;

public class BankAccount {
    private static final Double ZERO = 0.00;
    public Double balance;

    public BankAccount() {
        this.balance = ZERO;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void transferTo(BankAccount receiver, double amount) {
        validateTransaction(amount);
        withdraw(amount);
        receiver.deposit(amount);
    }

    public void withdraw(double amount) {
        validateTransaction(amount);
        balance -= amount;
    }

    public void printStatement() {

    }

    private void validateTransaction(double amount) {
        if (amount > balance){
            throw new RuntimeException("Not enough money in balance to make this transaction" );
        }
    }
}
