package com.codurance.Transactions;

import com.codurance.Money;

public class ReceiptTransaction extends Transaction {

    public ReceiptTransaction(Money transactionAmount) {
        super(transactionAmount);
    }
}
