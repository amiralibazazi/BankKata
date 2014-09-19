package com.codurance.Transactions;

import com.codurance.StatementPrinter;

public class ReceiptTransaction extends Transaction {

    public ReceiptTransaction(double transactionAmount) {
        super(transactionAmount);
    }

    @Override
    public void print(StatementPrinter statementPrinter) {

    }
}
