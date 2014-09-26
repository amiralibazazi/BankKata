package com.codurance;

public class DepositTransaction implements Transaction {
    private Money amount;
    private TransactionDate transactionDate;

    public DepositTransaction(Money amount, TransactionDate transactionDate) {
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Override
    public void addTransactionToStatement(StatementPrinter statementPrinter) {
        statementPrinter.addWithdrawalToStatement(amount, transactionDate);
        statementPrinter.addAmountToBalance(amount);
    }
}
