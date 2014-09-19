package com.codurance.Transactions;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
    private Date transactionDate = new Date();
    private double transactionAmount;

    public Transaction(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public abstract void print();

    public void printDate() {
        System.out.print(format(transactionDate));
    }

    public void printTransactionAmount() {
        System.out.print(transactionAmount);
    }

    private String format(Date date) {
        return DATE_FORMAT.format(date);
    }
}
