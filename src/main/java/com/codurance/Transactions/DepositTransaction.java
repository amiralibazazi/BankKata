package com.codurance.Transactions;

import com.codurance.StatementPrinter;

public class DepositTransaction extends Transaction {

    public DepositTransaction(double transactionAmount) {
        super(transactionAmount);
    }

    @Override
    public void print(StatementPrinter statementPrinter) {
        printDate();
        printTransactionAmount();
    }
}
