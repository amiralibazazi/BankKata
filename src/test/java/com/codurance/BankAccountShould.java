package com.codurance;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankAccountShould {

    private static final double ONE_HUNDRED = 100.00;
    private static final double TWO_HUNDRED = 200.00;
    private static final double ZERO = 0.00;
    private BankAccount account1;
    private BankAccount account2;
    private TransactionLog mockedTransactionLog1;
    private TransactionLog mockedTransactionLog2;

    @Before
    public void initialise() {
        mockedTransactionLog1 = mock(TransactionLog.class);
        mockedTransactionLog2 = mock(TransactionLog.class);
        account1 = new BankAccount(mockedTransactionLog1);
        account2 = new BankAccount(mockedTransactionLog2);
    }

    @Test public void
    be_able_to_make_a_deposit() {
        account1.deposit(ONE_HUNDRED);
        assertThat(account1.balance, is(ONE_HUNDRED));
    }

    @Test(expected=RuntimeException.class) public void
    not_let_you_withdraw_more_than_account_balance() {
        account1.withdraw(ONE_HUNDRED);
    }

    @Test public void
    be_able_to_make_a_withdrawal() {
        account1.deposit(TWO_HUNDRED);
        account1.withdraw(ONE_HUNDRED);
        assertThat(account1.balance, is(ONE_HUNDRED));
    }

    @Test(expected=RuntimeException.class) public void
    not_let_you_transfer_more_than_account_balance() {
        account1.transferTo(account2, ONE_HUNDRED);
    }

    @Test public void
    be_able_to_transfer_money_to_another_account() {
        account1.deposit(TWO_HUNDRED);
        account1.transferTo(account2, ONE_HUNDRED);
        account1.transferTo(account2, ONE_HUNDRED);
        assertThat(account2.balance, is(TWO_HUNDRED));
        assertThat(account1.balance, is(ZERO));
    }

    @Test public void
    store_a_deposit_transaction_to_the_transaction_log() {
        account1.deposit(ONE_HUNDRED);
        verify(mockedTransactionLog1).storeDeposit(any(Transaction.class));
    }

    @Test public void
    store_a_withdrawal_transaction_to_the_transaction_log() {
        account1.deposit(TWO_HUNDRED);
        account1.withdraw(ONE_HUNDRED);
        verify(mockedTransactionLog1).storeWithdrawal(any(Transaction.class));
    }

    @Test public void
    store_a_transfer_transaction_to_the_transaction_log() {
        account1.deposit(TWO_HUNDRED);
        account1.transferTo(account2, ONE_HUNDRED);
        verify(mockedTransactionLog1).storeTransfer();
    }

    @Test public void
    store_the_receipt_of_a_transaction_to_the_transaction_log() {
        account1.deposit(TWO_HUNDRED);
        account1.transferTo(account2, ONE_HUNDRED);
        verify(mockedTransactionLog2).storeReceipt();
    }
}
