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

    @Before
    public void initialise() {
        statementPrinter = new StatementPrinter();
        todaysDate = DATE_FORMAT.format(new Date());
        arbitraryTransaction = new DepositTransaction(ARBITRARY_AMOUNT);
        System.setOut(new PrintStream(consoleContent));
    }

    @Test public void
    print_out_the_date_the_transaction_occured() {
        arbitraryTransaction.print(statementPrinter);
        assertThat(wasPrinted(todaysDate), is(true));
    }

    @Test public void
    print_out_the_difference_to_the_balance_caused_by_the_transaction() {
        arbitraryTransaction.print(statementPrinter);
        assertThat(wasPrinted("50.00"), is(true));
    }

    @Test public void
    print_out_a_negative_transaction_amount_for_withdrawals() {
        Transaction withdrawal = new WithdrawalTransaction(ONE_HUNDRED);
        withdrawal.print(statementPrinter);
        assertThat(wasPrinted("-100.00"), is(true));
    }

    @Test public void
    print_out_a_negative_transaction_amount_for_transfers_out() {
        Transaction transfer = new TransferTransaction(ONE_HUNDRED);
        transfer.print(statementPrinter);
        assertThat(wasPrinted("-100.00"), is(true));
    }

    private boolean wasPrinted(String stringToCheck) {
        return consoleContent.toString().contains(stringToCheck);
    }

    private static final Money ARBITRARY_AMOUNT = new Money(50.00);
    private static final Money ONE_HUNDRED = new Money(100.00);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    private String todaysDate;
    private Transaction arbitraryTransaction;
    private StatementPrinter statementPrinter;
}
