package com.codurance.unittests;

import com.codurance.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.time.LocalDate.now;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {

    private static final Money ARBITRARY_MONEY = new Money(10.00);

    @Mock
    StatementPrinter statementPrinter;
    @Mock
    DepositTransaction someDeposit;
    @Mock
    WithdrawalTransaction someWithdrawal;

    @InjectMocks
    private TransactionRepository transactionRepository = new TransactionRepository();

    @Test public void
    store_a_transaction() {
        transactionRepository.store(someDeposit);
        assertThat(transactionRepository.hasTransaction(someDeposit), is(true));
    }

    @Test public void
    store_multiple_transactions() {
        Transaction unusedTransaction = new DepositTransaction(ARBITRARY_MONEY, new TransactionDate(now()));
        transactionRepository.store(someDeposit);
        transactionRepository.store(someWithdrawal);
        assertThat(transactionRepository.hasTransaction(someDeposit), is(true));
        assertThat(transactionRepository.hasTransaction(someWithdrawal), is(true));
        assertThat(transactionRepository.hasTransaction(unusedTransaction), is(false));
    }
    
    @Test public void
    print_a_statement_of_transactions() {
        transactionRepository.store(someDeposit);
        transactionRepository.store(someWithdrawal);

        transactionRepository.printStatement(statementPrinter);

        verify(statementPrinter).printStatementHeader();
        verify(someDeposit).addTransactionToStatement(statementPrinter);
        verify(someWithdrawal).addTransactionToStatement(statementPrinter);
    }
}