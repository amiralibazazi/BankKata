package com.codurance.Transactions;

import com.codurance.Transactions.Transaction;

public class DepositTransaction extends Transaction {

    public DepositTransaction(double transactionAmount) {
        super(transactionAmount);
    }

    @Override
    public void print() {
        printDate();
    }
}
