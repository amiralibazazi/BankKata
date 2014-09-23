package com.codurance;

import cucumber.api.java.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoneyShould {

    private static final double NEGATIVE_AMOUNT = -100.00;
    private static final double ONE_HUNDRED = 100.00;
    private ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();

    @Before
    public void initialise() {
        System.setOut(new PrintStream(consoleOutput));
    }

    @After
    public void breakDownStream() {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    @Test(expected=RuntimeException.class) public void
    throw_an_exception_when_handling_a_negative_value() {
        Money negativeMoney = new Money(NEGATIVE_AMOUNT);
    }
    
    @Test public void
    print_its_value() {
        Money someMoney = new Money(ONE_HUNDRED);
        someMoney.printValue();
        assertThat(consoleOutput.toString(), is("100.00"));
    }
}
