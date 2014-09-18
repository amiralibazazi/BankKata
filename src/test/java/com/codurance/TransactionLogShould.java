package com.codurance;

import com.codurance.Transactions.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionLogShould {

    Transaction deposit;
    Transaction withdrawal;
    TransactionLog transactionLog;

    @Before
    public void initialise() {
        deposit = new DepositTransaction();
        withdrawal = new WithdrawalTransaction();
        transactionLog = new TransactionLog();
    }

    @Test
    public void
    store_a_transaction() {
        transactionLog.store(deposit);
        assertThat(transactionLog.hasTransaction(deposit), is(true));
        assertThat(transactionLog.hasTransaction(withdrawal), is(false));
    }

    @Test
    public void
    store_multiple_transactions() {
        transactionLog.store(deposit);
        transactionLog.store(withdrawal);
        assertThat(transactionLog.hasTransaction(deposit), is(true));
        assertThat(transactionLog.hasTransaction(withdrawal), is(true));
    }
}