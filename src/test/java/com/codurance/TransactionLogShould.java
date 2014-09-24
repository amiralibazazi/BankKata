package com.codurance;

import com.codurance.Transactions.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionLogShould {

    private static final double ARBITRARY_AMOUNT = 25.00;
    private static final double FIFTY = 50.00;
    private static final double ONE_HUNDRED = 100.00;
    private static final double TWO_HUNDRED = 200.00;
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    private Transaction deposit;
    private Transaction withdrawal;
    private TransactionLog transactionLog;

    @Before
    public void initialise() {
        System.setOut(new PrintStream(consoleContent));
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

    @Test public void
    calculate_and_print_the_current_balance_from_the_stored_transactions() {
        transactionLog.store(new DepositTransaction(ONE_HUNDRED));
        transactionLog.store(new DepositTransaction(TWO_HUNDRED));
        transactionLog.store(new WithdrawalTransaction(FIFTY));
        transactionLog.printBalance();
        assertThat(consoleContent.toString(), is("350.00"));
    }
}