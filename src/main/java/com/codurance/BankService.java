package com.codurance;

import com.codurance.Transactions.DepositTransaction;
import com.codurance.Transactions.ReceiptTransaction;
import com.codurance.Transactions.TransferTransaction;
import com.codurance.Transactions.WithdrawalTransaction;

public class BankService {

    public StatementPrinter statementPrinter;

    public BankService(StatementPrinter statementPrinter) {
        this.statementPrinter = statementPrinter;
    }

    public BankAccount createAccount() {
        return new BankAccount(new TransactionHistory());
    }

    public void processDeposit(BankAccount account, double amount) {
        account.processTransaction(new DepositTransaction(amount));
    }

    public void processWithdrawal(BankAccount account, double amount) {
        account.processTransaction(new WithdrawalTransaction(amount));
    }

    public void processTransfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        fromAccount.processTransaction(new TransferTransaction(amount));
        toAccount.processTransaction(new ReceiptTransaction(amount));
    }

    public void printStatementFor(BankAccount account) {
        account.printStatement(statementPrinter);
    }
}