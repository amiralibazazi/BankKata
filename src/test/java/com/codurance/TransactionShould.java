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
    private ByteArrayOutputStream transactionContent = new ByteArrayOutputStream();
    private Date todaysDate;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");

    @Before
    public void initialise() {
        todaysDate = new Date();
        System.setOut(new PrintStream(transactionContent));
    }

    @Test public void
    print_out_the_date_the_transaction_occured() {
        Transaction arbitraryTransaction = new DepositTransaction();
        arbitraryTransaction.printDate();
        assertThat(transactionContent, is(DATE_FORMAT.format(todaysDate)));
    }
}
