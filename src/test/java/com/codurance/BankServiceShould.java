package com.codurance;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BankServiceShould {

    private final ByteArrayOutputStream statementContent = new ByteArrayOutputStream();

    @Before
    public void initialise() {
        System.setOut(new PrintStream(statementContent));
    }

    @Ignore public void
    print_a_statement_of_an_accounts_transactions() {
        BankService bankService = new BankService();
        BankAccount account1 = bankService.createAccount();
        BankAccount account2 = bankService.createAccount();
        account1.deposit(500.00);
        account1.transferTo(account2, 74.50);
        account1.withdraw(150.00);
        account1.printStatement();
        assertThat(statementContent.toString(), is(
                "DATE      AMOUNT      BALANCE\n" + //6 spaces inbetween
                "17/09/14  500.00      500.00\n" +  //2 spaces from date to amount
                "17/09/14  -74.50      425.50\n" +  //
                "17/09/14  -150.00     275.60\n"
        ));
    }
}