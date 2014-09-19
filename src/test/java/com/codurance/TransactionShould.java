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

public class TransactionShould {
    private static final double ARBITRARY_AMOUNT = 50.00;
    private static final double ONE_HUNDRED = 100.00;
    private ByteArrayOutputStream transactionContent = new ByteArrayOutputStream();
    private String todaysDate;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
    private Transaction arbitraryTransaction;
    private StatementPrinter statementPrinter;


    @Before
    public void initialise() {
        statementPrinter = new StatementPrinter();
        todaysDate = DATE_FORMAT.format(new Date());
        arbitraryTransaction = new DepositTransaction(ARBITRARY_AMOUNT);
        System.setOut(new PrintStream(transactionContent));
    }

    @Test public void
    print_out_the_date_the_transaction_occured() {
        arbitraryTransaction.print(statementPrinter);
        assertThat(transactionContentContains(DATE_FORMAT.format(todaysDate)), is(true));
    }

    @Test public void
    print_out_the_difference_to_the_balance_caused_by_the_transaction() { //THESE TESTS MIGHT BECOME REDUNDANT WHEN BEHAVIOURS CHANGE
        arbitraryTransaction.print(statementPrinter);
        assertThat(transactionContentContains(""+ARBITRARY_AMOUNT), is(true));
    }

    @Test public void
    print_out_a_negative_transaction_amount_for_withdrawals() {
        Transaction withdrawal = new WithdrawalTransaction(ONE_HUNDRED);
        withdrawal.print(statementPrinter);
        assertThat(transactionContentContains("-"+ONE_HUNDRED), is(true));
    }

    @Test public void
    print_out_a_negative_transaction_amount_for_transfers_out() {
        Transaction transfer = new TransferTransaction(ONE_HUNDRED);
        transfer.print(statementPrinter);
        assertThat(transactionContentContains("-"+ONE_HUNDRED), is(true));
    }

    private boolean transactionContentContains(String string) {
        return transactionContent.toString().contains(string);
    }
}
