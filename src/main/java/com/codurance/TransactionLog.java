package com.codurance;

import com.codurance.Transactions.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionLog {
    private List<Transaction> transactions;

    public TransactionLog() {
        transactions = new ArrayList<>();
    }

    public void store(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printStatement() {

    }

    public boolean hasTransaction(Transaction transaction) {
        return transactions.contains(transaction);
    }
}
