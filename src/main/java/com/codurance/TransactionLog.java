package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class TransactionLog {

    private List<Transaction> transactions;

    public TransactionLog() {
        transactions = new ArrayList<>();
    }

    public void storeDeposit(Transaction deposit) {
        transactions.add(deposit);
    }

    public void storeWithdrawal(Transaction withdrawal) {
        transactions.add(withdrawal);
    }

    public void storeTransfer() {

    }

    public void storeReceipt() {

    }

    public boolean containsTransaction(Transaction transaction) {
        return transactions.contains(transaction);
    }
}
