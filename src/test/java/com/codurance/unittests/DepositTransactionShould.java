package com.codurance.unittests;

import com.codurance.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DepositTransactionShould {

    private static final Money ARBITRARY_MONEY = new Money(10.00);
    private TransactionDate transactionDate = new TransactionDate(LocalDate.now());
    private Transaction someDeposit;

    @Mock
    StatementPrinter statementPrinter;

    @Before
    public void initialise() {
    someDeposit = new DepositTransaction(ARBITRARY_MONEY, transactionDate);
    }

    @Test public void
    tell_the_statement_printer_to_add_itself_to_the_statement() {
        someDeposit.addTransactionToStatement(statementPrinter);
        verify(statementPrinter).addDepositToStatement(ARBITRARY_MONEY, transactionDate);
    }

    @Test public void
    tell_the_statement_printer_to_add_the_transaction_amount_to_the_balance() {
        someDeposit.addTransactionToStatement(statementPrinter);
        verify(statementPrinter).addAmountToBalance(ARBITRARY_MONEY);
    }
}
