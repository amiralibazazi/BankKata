package com.codurance;

import com.codurance.Transactions.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionHistoryShould {

    private static final double ARBITRARY_AMOUNT = 25.00;
    private static final double FIFTY = 50.00;
    private static final double ONE_HUNDRED = 100.00;
    private static final double TWO_HUNDRED = 200.00;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    private Transaction deposit;
    private Transaction withdrawal;
    private TransactionHistory transactionHistory;
    private StatementPrinter statementPrinter;
    private String todaysDate;

    @Before
    public void initialise() {
        todaysDate = DATE_FORMAT.format(new Date());
        statementPrinter = new StatementPrinter();
        System.setOut(new PrintStream(consoleContent));
        deposit = new DepositTransaction(ARBITRARY_AMOUNT);
        withdrawal = new WithdrawalTransaction(ARBITRARY_AMOUNT);
        transactionHistory = new TransactionHistory();
    }

    @Test
    public void
    store_a_transaction() {
        transactionHistory.store(deposit);
        assertThat(transactionHistory.hasTransaction(deposit), is(true));
        assertThat(transactionHistory.hasTransaction(withdrawal), is(false));
    }

    @Test
    public void
    store_multiple_transactions() {
        transactionHistory.store(deposit);
        transactionHistory.store(withdrawal);
        assertThat(transactionHistory.hasTransaction(deposit), is(true));
        assertThat(transactionHistory.hasTransaction(withdrawal), is(true));
    }

    @Test
    public void
    print_a_statement_of_transactions() {
        transactionHistory.store(deposit);
        transactionHistory.store(withdrawal);
        transactionHistory.store(new ReceiptTransaction(TWO_HUNDRED));
        transactionHistory.printStatement(statementPrinter);
        assertThat(consoleContent.toString(), is(
                "DATE\t\tAMOUNT\t\tBALANCE\n" +
                        todaysDate+"\t400.00\t\t400.00\n" +
                        todaysDate+"\t-100.00\t\t300.00\n" +
                        todaysDate+"\t-100.00\t\t200.00\n" +
                        todaysDate+"\t100.00\t\t300.00\n"
        ));
    }
}