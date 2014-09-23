package com.codurance.Transactions;

import com.codurance.Money;

public class DepositTransaction extends Transaction {

    public DepositTransaction(Money transactionAmount) {
        super(transactionAmount);
    }
}
