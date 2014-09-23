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

    private static final Money ARBITRARY_AMOUNT = new Money(25.00);
    private static final Money FIFTY = new Money(50.00);
    private static final Money ONE_HUNDRED = new Money(100.00);
    private static final Money TWO_HUNDRED = new Money(200.00);
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
        transactionHistory.store(new DepositTransaction(TWO_HUNDRED));
        transactionHistory.store(new WithdrawalTransaction(FIFTY));
        transactionHistory.store(new ReceiptTransaction(TWO_HUNDRED));
        transactionHistory.store(new TransferTransaction(FIFTY));
        transactionHistory.printStatement(statementPrinter);
        assertThat(consoleContent.toString(), is(
                "DATE\t\tAMOUNT\t\tBALANCE\n" +
                        todaysDate+"\t200.00\t\t200.00\n" +
                        todaysDate+"\t-50.00\t\t150.00\n" +
                        todaysDate+"\t200.00\t\t350.00\n" +
                        todaysDate+"\t-50.00\t\t300.00\n"
        ));
    }
}