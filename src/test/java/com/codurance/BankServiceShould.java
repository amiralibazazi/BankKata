package com.codurance;

import com.codurance.Transactions.DepositTransaction;
import com.codurance.Transactions.ReceiptTransaction;
import com.codurance.Transactions.TransferTransaction;
import com.codurance.Transactions.WithdrawalTransaction;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankServiceShould {

    @Before
    public void initialise() {
        todaysDate = DATE_FORMAT.format(new Date());
        statementPrinter = new StatementPrinter();
        System.setOut(new PrintStream(statementContent));
        bankService = new BankService(statementPrinter);
        mockedAccount1 = mock(BankAccount.class);
    }

    @Test //Acceptance Test
    public void
    print_a_bank_statement_to_the_console() {
        BankAccount account1 = bankService.createAccount();
        BankAccount account2 = bankService.createAccount();
        bankService.processDeposit(account1, FOUR_HUNDRED_MONEY);
        bankService.processWithdrawal(account1, ONE_HUNDRED_MONEY);
        bankService.processTransfer(account1, account2, ONE_HUNDRED_MONEY);
        bankService.processTransfer(account2, account1, ONE_HUNDRED_MONEY);
        bankService.printStatementFor(account1);
        assertThat(statementContent.toString(), is(
                    "DATE\t\tAMOUNT\t\tBALANCE\n" +
               todaysDate+"\t400.00\t\t400.00\n" +
               todaysDate+"\t-100.00\t\t300.00\n" +
               todaysDate+"\t-100.00\t\t200.00\n" +
               todaysDate+"\t100.00\t\t300.00\n"
        ));
    }

    @Test public void
    process_a_deposit_transaction() {
        bankService.processDeposit(mockedAccount1, ONE_HUNDRED_MONEY);
        verify(mockedAccount1).processTransaction(any(DEPOSIT_TRANSACTION));
    }

    @Test public void
    process_a_withdrawal_transaction() {
        bankService.processWithdrawal(mockedAccount1, ONE_HUNDRED_MONEY);
        verify(mockedAccount1).processTransaction(any(WITHDRAWAL_TRANSACTION));
    }

    @Test public void
    process_a_transfer_between_two_accounts() {
        BankAccount mockedAccount2 = mock(BankAccount.class);
        bankService.processTransfer(mockedAccount1, mockedAccount2, ONE_HUNDRED_MONEY);
        verify(mockedAccount1).processTransaction(any(TRANSFER_TRANSACTION));
        verify(mockedAccount2).processTransaction(any(RECEIPT_TRANSACTION));
    }

    @Test public void
    ask_an_account_to_print_its_statement() {
        bankService.printStatementFor(mockedAccount1);
        verify(mockedAccount1).printStatement(statementPrinter);
    }

    private static final Money ONE_HUNDRED_MONEY = new Money(100.00);
    private static final Money FOUR_HUNDRED_MONEY = new Money(400.00);
    private static final Class<DepositTransaction> DEPOSIT_TRANSACTION = DepositTransaction.class;
    private static final Class<WithdrawalTransaction> WITHDRAWAL_TRANSACTION = WithdrawalTransaction.class;
    private static final Class<TransferTransaction> TRANSFER_TRANSACTION = TransferTransaction.class;
    private static final Class<ReceiptTransaction> RECEIPT_TRANSACTION = ReceiptTransaction.class;
    private final ByteArrayOutputStream statementContent = new ByteArrayOutputStream();
    private BankService bankService;
    private BankAccount mockedAccount1;
    private StatementPrinter statementPrinter;
    private String todaysDate;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
}
