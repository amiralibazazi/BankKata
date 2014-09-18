package com.codurance.Transactions;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {
    private Date transactionDate = new Date();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");

    public abstract void print();

    public void printDate() {
        System.out.print(format(transactionDate));
    }

    private String format(Date date) {
        return DATE_FORMAT.format(date);
    }
}
