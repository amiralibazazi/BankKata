package com.codurance.Transactions;

import com.codurance.Transactions.Transaction;

public class TransferTransaction extends Transaction {

    public TransferTransaction(double transactionAmount) {
        super(transactionAmount);
    }

    @Override
    public void print() {
        printDate();
        printTransactionAmount();
    }

    @Override
    public void printTransactionAmount() {
        System.out.print("-"+transactionAmount);
    }
}
