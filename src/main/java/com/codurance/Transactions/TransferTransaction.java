package com.codurance.Transactions;

import com.codurance.Money;
import com.codurance.StatementPrinter;

public class TransferTransaction extends Transaction {

    public TransferTransaction(Money transactionAmount) {
        super(transactionAmount);
    }

    @Override
    protected void updateTotalBalance(StatementPrinter statementPrinter) {
        statementPrinter.decreaseBalanceTotalBy(transactionAmount);
    }

    @Override
    public void printTransactionAmount() {
        System.out.print("-");
        transactionAmount.printValue();
    }

}
