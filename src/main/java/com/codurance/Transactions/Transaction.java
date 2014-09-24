package com.codurance.Transactions;

import com.codurance.Money;
import com.codurance.StatementPrinter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
    private Date transactionDate = new Date();
    Money transactionAmount;

    public Transaction(Money transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void print(StatementPrinter statementPrinter) {
        printDate();
        statementPrinter.printTab();
        printTransactionAmount();
        updateTotalBalance(statementPrinter);
    }

    protected void updateTotalBalance(StatementPrinter statementPrinter) {
        statementPrinter.increaseBalanceTotalBy(transactionAmount);
    }

    protected void printDate() {
        System.out.print(format(transactionDate));
    }

    public void printTransactionAmount() {
        transactionAmount.printValue();
    }

    private String format(Date date) {
        return DATE_FORMAT.format(date);
    }
}
