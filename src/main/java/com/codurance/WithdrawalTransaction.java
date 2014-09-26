package com.codurance;

public class WithdrawalTransaction implements Transaction {
    private final Money amount;
    private final TransactionDate transactionDate;

    public WithdrawalTransaction(Money amount, TransactionDate transactionDate) {
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Override
    public void addTransactionToStatement(StatementPrinter statementPrinter) {
        statementPrinter.addWithdrawalToStatement(amount, transactionDate);
    }
}
