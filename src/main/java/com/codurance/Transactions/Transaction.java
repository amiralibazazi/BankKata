package com.codurance.Transactions;

import com.codurance.StatementPrinter;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
    protected static final DecimalFormat TWO_DECIMALS = new DecimalFormat("#.00");
    private Date transactionDate = new Date();
    double transactionAmount;

    public Transaction(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void print(StatementPrinter statementPrinter) {
        printDate();
        statementPrinter.printTab();
        printTransactionAmount();
        updateTotalBalance(statementPrinter);
    }

    protected void updateTotalBalance(StatementPrinter statementPrinter) {
        statementPrinter.updateTotalBalance(transactionAmount);
    }

    protected void printDate() {
        System.out.print(format(transactionDate));
    }

    public void printTransactionAmount() {
        System.out.print(twoDecimalFormat(transactionAmount));
    }

    protected String twoDecimalFormat(double transactionAmount) {
        return TWO_DECIMALS.format(transactionAmount);
    }

    private String format(Date date) {
        return DATE_FORMAT.format(date);
    }
}
