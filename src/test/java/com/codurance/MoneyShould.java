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
    private static final double TWO_HUNDRED = 200.00;
    private ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
    private Money someMoney;

    @Before
    public void initialise() {
        System.setOut(new PrintStream(consoleOutput));
        someMoney = new Money(ONE_HUNDRED);
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
        someMoney.printValue();
        assertThat(consoleOutput.toString(), is("100.00"));
    }

    @Test public void
    perform_an_addition() {
        Money someOtherMoney = new Money(TWO_HUNDRED);
        someMoney.add(someOtherMoney);
        someMoney.printValue();
        assertThat(consoleOutput.toString(), is("300.00"));
    }

    @Test public void
    perform_a_subtraction() {
        Money someOtherMoney = new Money(TWO_HUNDRED);
        someOtherMoney.deduct(someMoney);
        someOtherMoney.printValue();
        assertThat(consoleOutput.toString(), is("100.00"));
    }
}
