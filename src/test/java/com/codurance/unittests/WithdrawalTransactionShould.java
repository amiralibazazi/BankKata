package com.codurance.unittests;

import com.codurance.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.time.LocalDate.now;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WithdrawalTransactionShould {

    private static final Money ARBITRARY_MONEY = new Money(10.00);
    private TransactionDate transactionDate = new TransactionDate(now());

    @Mock
    StatementPrinter statementPrinter;

    @Test public void
    tell_the_statement_printer_to_add_itself_to_the_statement() {
        Transaction someWithdrawal = new WithdrawalTransaction(ARBITRARY_MONEY, transactionDate);
        someWithdrawal.addTransactionToStatement(statementPrinter);
        verify(statementPrinter).addWithdrawalToStatement(ARBITRARY_MONEY, transactionDate);
    }
}
