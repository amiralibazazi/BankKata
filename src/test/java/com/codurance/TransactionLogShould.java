package com.codurance;

import com.codurance.Transactions.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionLogShould {

    private static final double ARBITRARY_AMOUNT = 0.00;
    private Transaction deposit;
    private Transaction withdrawal;
    private TransactionLog transactionLog;

    @Before
    public void initialise() {
        deposit = new DepositTransaction(ARBITRARY_AMOUNT);
        withdrawal = new WithdrawalTransaction(ARBITRARY_AMOUNT);
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