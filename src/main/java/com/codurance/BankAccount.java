package com.codurance;

import com.codurance.Transactions.Transaction;

public class BankAccount {
    private TransactionLog transactionLog;

    public BankAccount(TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    public void processTransaction(Transaction transaction) {
        transactionLog.store(transaction);
    }

    public void printStatement() {
        transactionLog.printStatement();
    }
}
