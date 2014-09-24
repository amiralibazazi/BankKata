package com.codurance.Transactions;

import com.codurance.Money;
import com.codurance.StatementPrinter;

public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(Money transactionAmount) {
        super(transactionAmount);
    }

    @Override
    public void printTransactionAmount() {
        System.out.print("-");
        transactionAmount.printValue();
    }

    @Override
    protected void updateTotalBalance(StatementPrinter statementPrinter) {
        statementPrinter.decreaseBalanceTotalBy(transactionAmount);
    }
}
