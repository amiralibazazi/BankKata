package com.codurance;

public class BankAccount {
    private static final Double ZERO = 0.00;
    public Double balance;
    private TransactionLog transactionLog;

    public BankAccount(TransactionLog transactionLog) {
        this.balance = ZERO;
        this.transactionLog = transactionLog;
    }

    public void deposit(double amount) {
        increaseBalanceBy(amount);
        transactionLog.storeDeposit(new DepositTransaction());
    }

    public void withdraw(double amount) {
        validateTransaction(amount);
        decreaseBalanceBy(amount);
        transactionLog.storeWithdrawal(new WithdrawalTransaction());
    }

    public void transferTo(BankAccount receiver, double amount) {
        validateTransaction(amount);
        decreaseBalanceBy(amount);
        receiver.receive(amount);
        transactionLog.storeTransfer();
    }

    public void receive(double amount) {
        increaseBalanceBy(amount);
        transactionLog.storeReceipt();
    }

    public void printStatement() {

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
