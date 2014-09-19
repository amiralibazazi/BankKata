package com.codurance.Transactions;

import com.codurance.StatementPrinter;

public class TransferTransaction extends Transaction {

    public TransferTransaction(double transactionAmount) {
        super(transactionAmount);
    }

    @Override
    public void print(StatementPrinter statementPrinter) {
        printDate();
        printTransactionAmount();
    }

    @Override
    public void printTransactionAmount() {
        System.out.print("-"+transactionAmount);
    }
}
