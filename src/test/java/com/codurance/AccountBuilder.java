package com.codurance;

import com.codurance.Transactions.Transaction;

public class AccountBuilder {
    public TransactionLog transactionLog;
    private Transaction[] transactions;

    public static AccountBuilder anAccount() {
        return new AccountBuilder();
    }

    public AccountBuilder withTransactions(Transaction... transactions) {
        this.transactions = transactions;
        return this;
    }

    public AccountBuilder withTransactionLog(TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
        return this;
    }

    public BankAccount build() {
        BankAccount account = new BankAccount(transactionLog);
        processTransactions(account);
        return account;
    }

    private void processTransactions(BankAccount account) {
        for (Transaction transaction : transactions) {
            account.processTransaction(transaction);
        }
    }

}
