package com.codurance.Transactions;

public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(double transactionAmount) {
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
