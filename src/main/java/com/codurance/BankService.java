package com.codurance;

public class BankService {

    public BankAccount createAccount() {
        return new BankAccount();
    }

    public void processDeposit(BankAccount account, double amount) {
        account.processTransaction(new DepositTransaction());
    }

    public void processWithdrawal(BankAccount account, double amount) {
        account.processTransaction(new WithdrawalTransaction());
    }

    public void processTransfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        fromAccount.processTransaction(new TransferTransaction());
        toAccount.processTransaction(new ReceiptTransaction());
    }

    public void printStatementFor(BankAccount account) {

    }
}