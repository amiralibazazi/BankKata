package com.codurance;

public class AccountBuilder { //SOMETHING NOT WORKING HERE
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
