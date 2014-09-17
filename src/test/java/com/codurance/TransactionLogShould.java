package com.codurance;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionLogShould {
    TransactionLog transactionLog;
    Transaction deposit;
    Transaction withdrawal;

    @Before
    public void initialise() {
        transactionLog = new TransactionLog();
        deposit = new DepositTransaction();
        withdrawal = new WithdrawalTransaction();
    }

    @Test public void
    add_a_deposit_transaction_to_a_list_of_transactions() {
        transactionLog.storeDeposit(deposit);
        assertThat(transactionLog.containsTransaction(deposit), is(true));
    }

    @Test public void
    add_a_withdrawal_transaction_to_a_list_of_transactions() {
        transactionLog.storeWithdrawal(withdrawal);
        assertThat(transactionLog.containsTransaction(withdrawal), is(true));
        assertThat(transactionLog.containsTransaction(deposit), is(false));
    }
}
