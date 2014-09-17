package com.codurance;

import com.codurance.Transactions.*;

public class BankAccount {
    private static final Double ZERO = 0.00;
    public Double balance;
    private TransactionLog transactionLog;

    public BankAccount(TransactionLog transactionLog) {
        this.balance = ZERO;
        this.transactionLog = transactionLog;
    }
    //REFACTOR THESE TO MAKE A SINGLE METHOD WITH CONSTANTS/ACCOUNT PASSED
    public void deposit(double amount) {
        increaseBalanceBy(amount);
        transactionLog.store(new DepositTransaction());
    }

    public void withdraw(double amount) {
        validateTransaction(amount);
        decreaseBalanceBy(amount);
        transactionLog.store(new WithdrawalTransaction());
    }

    public void transferTo(BankAccount receiver, double amount) {
        validateTransaction(amount);
        decreaseBalanceBy(amount);
        receiver.receive(amount);
        transactionLog.store(new TransferTransaction());
    }

    public void receive(double amount) {
        increaseBalanceBy(amount);
        transactionLog.store(new ReceiptTransaction());
    }

    public void printStatement() {
        transactionLog.print();
    }

    private void validateTransaction(double amount) {
        if (amount > balance){
            throw new RuntimeException("Not enough money in balance to make this transaction" );
        }
    }

    private void decreaseBalanceBy(double amount) {
        balance -= amount;
    }

    private void increaseBalanceBy(double amount) {
        balance += amount;
    }
}
