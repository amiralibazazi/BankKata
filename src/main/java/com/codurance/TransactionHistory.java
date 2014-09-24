package com.codurance;

import com.codurance.Transactions.Transaction;

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
        statementPrinter.printStatementHeader();
        for(Transaction transaction : transactions) {
            transaction.print(statementPrinter);
            statementPrinter.printTwoTabs();
            statementPrinter.printBalanceTotal();
            statementPrinter.printNewLine();
        }
    }

    public boolean hasTransaction(Transaction transaction) {
        return transactions.contains(transaction);
    }
}
