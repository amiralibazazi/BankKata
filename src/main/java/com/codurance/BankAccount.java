package com.codurance;

import com.codurance.Transactions.Transaction;

public class BankAccount {
    private TransactionHistory transactionHistory;

    public BankAccount(TransactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void processTransaction(Transaction transaction) {
        transactionHistory.store(transaction);
    }

    public void printStatement(StatementPrinter statementPrinter) {
        transactionHistory.printStatement(statementPrinter);
    }
}
