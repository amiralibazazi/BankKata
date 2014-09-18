package com.codurance;

import com.codurance.Transactions.DepositTransaction;
import com.codurance.Transactions.ReceiptTransaction;
import com.codurance.Transactions.TransferTransaction;
import com.codurance.Transactions.WithdrawalTransaction;

public class BankService {

    public BankAccount createAccount() {
        return new BankAccount(new TransactionLog());
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
        account.printStatement();
    }
}