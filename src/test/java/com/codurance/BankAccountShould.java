package com.codurance;

import com.codurance.Transactions.*;
import org.junit.Before;
import org.junit.Test;

import static com.codurance.AccountBuilder.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankAccountShould {

    @Before
    public void initialise() {
        transactionHistory = mock(TransactionHistory.class);
        depositTransaction = new DepositTransaction(ARBITRARY_AMOUNT);
        withdrawalTransaction = new WithdrawalTransaction(ARBITRARY_AMOUNT);
        transferTransaction = new TransferTransaction(ARBITRARY_AMOUNT);
        receiptTransaction = new ReceiptTransaction(ARBITRARY_AMOUNT);
        statementPrinter = new StatementPrinter();
    }

    @SuppressWarnings("UnusedDeclaration")
    @Test public void
    store_all_transactions_to_a_transaction_log() {
        Transaction[] transactions = {depositTransaction, withdrawalTransaction, transferTransaction, receiptTransaction};
        BankAccount anAccount = anAccount()
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

    private static final Money ARBITRARY_AMOUNT = new Money(0.00);
    private Transaction depositTransaction;
    private Transaction receiptTransaction;
    private Transaction withdrawalTransaction;
    private Transaction transferTransaction;
    private TransactionHistory transactionHistory;
    private StatementPrinter statementPrinter;
}
