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
    not_let_you_withdraw_more_than_account_balance() {
        account1.withdraw(100.00);
    }

    @Test public void
    be_able_to_make_a_withdrawal() {
        account1.deposit(200.00);
        account1.withdraw(100.00);
        assertThat(account1.balance, is(100.00));
    }

    @Test(expected=RuntimeException.class) public void
    not_let_you_transfer_more_than_account_balance() {
        BankAccount account2 = new BankAccount();
        account1.transferTo(account2, 100.00);
    }

    @Test public void
    be_able_to_transfer_money_to_another_account() {
        BankAccount account2 = new BankAccount();
        account1.deposit(200);
        account1.transferTo(account2, 100.00);
        account1.transferTo(account2, 50.00);
        assertThat(account2.balance, is(150.00));
    }
}
