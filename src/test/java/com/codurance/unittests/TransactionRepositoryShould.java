package com.codurance.unittests;

import com.codurance.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionRepositoryShould {

    private static final Money ARBITRARY_MONEY = new Money(10.00);
    private DepositTransaction someDeposit;
    private TransactionRepository transactionRepository;
    private WithdrawalTransaction someWithdrawal;

    @Before
    public void initialise() {
        someDeposit = new DepositTransaction(ARBITRARY_MONEY);
        someWithdrawal = new WithdrawalTransaction(ARBITRARY_MONEY);
        transactionRepository = new TransactionRepository();
    }

    @Test public void
    store_a_transaction() {
        transactionRepository.store(someDeposit);
        assertThat(transactionRepository.hasTransaction(someDeposit), is(true));
    }

    @Test public void
    store_multiple_transactions() {
        Transaction unusedTransaction = new DepositTransaction(ARBITRARY_MONEY);
        transactionRepository.store(someDeposit);
        transactionRepository.store(someWithdrawal);
        assertThat(transactionRepository.hasTransaction(someDeposit), is(true));
        assertThat(transactionRepository.hasTransaction(someWithdrawal), is(true));
        assertThat(transactionRepository.hasTransaction(unusedTransaction), is(false));
    }
}
