package com.codurance;

import com.codurance.Transactions.Transaction;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private List<Transaction> transactions;

    public TransactionHistory() {
        transactions = new ArrayList<>();
    }

    public void store(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printStatement(StatementPrinter statementPrinter) {
        printStatementHeader();
        for(Transaction transaction : transactions) {
            transaction.print(statementPrinter);
            statementPrinter.printTwoTabs();
            statementPrinter.printBalanceTotal();
            statementPrinter.printNewLine();
        }
    }

    private void printStatementHeader() {
        System.out.println("DATE\t\tAMOUNT\t\tBALANCE");
    }

    public boolean hasTransaction(Transaction transaction) {
        return transactions.contains(transaction);
    }
}
