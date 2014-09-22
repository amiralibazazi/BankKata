package com.codurance.Transactions;

import com.codurance.StatementPrinter;

public class TransferTransaction extends Transaction {

    public TransferTransaction(double transactionAmount) {
        super(transactionAmount);
    }

    @Override
    protected void updateTotalBalance(StatementPrinter statementPrinter) {
        statementPrinter.updateTotalBalance(-transactionAmount);
    }

    @Override
    public void printTransactionAmount() {
        System.out.print("-"+twoDecimalFormat(transactionAmount));
    }

}
