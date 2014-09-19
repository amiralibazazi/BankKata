package com.codurance.Transactions;

import com.codurance.StatementPrinter;

public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(double transactionAmount) {
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
