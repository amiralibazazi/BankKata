package com.codurance.Transactions;

import com.codurance.Transactions.Transaction;

public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(double transactionAmount) {
        super(transactionAmount);
    }

    @Override
    public void print() {

    }
}
