package com.codurance;

import com.codurance.Transactions.DepositTransaction;
import com.codurance.Transactions.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StatementPrinterShould {

    private static final Money ARBITRARY_AMOUNT = new Money(120.00);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    private String todaysDate;

    @Before
    public void initialise() {
        todaysDate = DATE_FORMAT.format(new Date());
    }

    @Test public void
    print_out_a_transaction() {
        System.setOut(new PrintStream(consoleContent));
        Transaction deposit = new DepositTransaction(ARBITRARY_AMOUNT);
        StatementPrinter statementPrinter = new StatementPrinter();
        deposit.print(statementPrinter);
        assertThat(consoleContent.toString(), is(
                todaysDate+"\t"+"120.00"
        ));
    }
}
