package com.codurance;

public class BankAccount {
    private TransactionLog transactionLog;

    public BankAccount(TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    public void processTransaction(Transaction transaction) {
        transactionLog.store(transaction);
    }

    public void printStatement() {

    }
}
