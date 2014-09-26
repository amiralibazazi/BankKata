package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private List<Transaction> transactions;

    public TransactionRepository() {
        transactions = new ArrayList<>();
    }

    public void store(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printStatement(StatementPrinter statementPrinter) {
        statementPrinter.printStatementHeader();
        for (Transaction t : transactions) {
            t.addTransactionToStatement(statementPrinter);
        }
    }

    public boolean hasTransaction(Transaction transaction) {
        return transactions.contains(transaction);
    }
}
