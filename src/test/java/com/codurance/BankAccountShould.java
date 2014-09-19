package com.codurance;

import com.codurance.Transactions.*;
import org.junit.Before;
import org.junit.Test;

import static com.codurance.AccountBuilder.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankAccountShould {
    private static final double ARBITRARY_AMOUNT = 0.00;
    private Transaction deposit;
    private Transaction receipt;
    private Transaction withdrawal;
    private Transaction transfer;
    private TransactionHistory transactionHistory;
    private StatementPrinter statementPrinter;

    @Before
    public void initialise() {
        transactionHistory = mock(TransactionHistory.class);
        deposit = new DepositTransaction(ARBITRARY_AMOUNT);
        withdrawal = new WithdrawalTransaction(ARBITRARY_AMOUNT);
        transfer = new TransferTransaction(ARBITRARY_AMOUNT);
        receipt = new ReceiptTransaction(ARBITRARY_AMOUNT);
        statementPrinter = new StatementPrinter();
    }

    @Test public void
    store_all_transactions_to_a_transaction_log() { //DONT LIKE THIS CLUTTER
        Transaction[] transactions = {deposit, withdrawal, transfer, receipt};
        BankAccount anAccount = anAccount() //ignore unused warning, instance is indirectly used
                                    .withTransactions(transactions)
                                    .withTransactionLog(transactionHistory)
                                    .build();

        for (Transaction transaction : transactions) {
            verify(transactionHistory).store(transaction);
        }
    }

    @Test public void
    ask_the_transaction_log_to_print_a_bank_statement() {
        BankAccount account = new BankAccount(transactionHistory);
        account.printStatement(statementPrinter);
        verify(transactionHistory).printStatement(statementPrinter);
    }
}
