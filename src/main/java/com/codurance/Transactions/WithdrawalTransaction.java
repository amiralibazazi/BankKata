package com.codurance.Transactions;

import com.codurance.StatementPrinter;

public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(double transactionAmount) {
        super(transactionAmount);
    }

    @Override
    public void printTransactionAmount() {
        System.out.print("-"+twoDecimalFormat(transactionAmount));
    }

    @Override
    protected void updateTotalBalance(StatementPrinter statementPrinter) {
        statementPrinter.updateTotalBalance(-transactionAmount);
    }
}
