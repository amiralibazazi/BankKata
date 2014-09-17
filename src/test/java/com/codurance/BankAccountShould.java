package com.codurance;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankAccountShould {

    BankAccount account1;

    @Before
    public void initialise() {
        account1 = new BankAccount();
    }

    @Test public void
    be_able_to_make_a_deposit() {
        account1.deposit(100.00);
        assertThat(account1.balance, is(100.00));
    }

    @Test(expected=RuntimeException.class) public void
    throw_an_exception_when_trying_to_withdraw_more_than_account_balance() {
        account1.withdraw(100.00);
    }

    @Test public void
    be_able_to_make_a_withdrawal() {
        account1.deposit(200.00);
        account1.withdraw(100.00);
        assertThat(account1.balance, is(100.00));
    }
}
