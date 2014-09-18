package com.codurance;

import org.junit.Before;
import org.junit.Test;

import static com.codurance.AccountBuilder.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankAccountShould {
    private Transaction deposit;
    private Transaction receipt;
    private Transaction withdrawal;
    private Transaction transfer;
    private TransactionLog transactionLog;

    @Before
    public void initialise() {
        transactionLog = mock(TransactionLog.class);
        deposit = new DepositTransaction();
        withdrawal = new WithdrawalTransaction();
        transfer = new TransferTransaction();
        receipt = new ReceiptTransaction();
    }
    @Test public void
    store_all_transactions_to_a_transaction_log() { //DONT LIKE THIS CLUTTER
        BankAccount anAccount = anAccount()
                                    .withTransactions(deposit, withdrawal, transfer, receipt)
                                    .withTransactionLog(transactionLog)
                                    .build();

        verify(transactionLog).store(deposit);
        verify(transactionLog).store(withdrawal);
        verify(transactionLog).store(transfer);
        verify(transactionLog).store(receipt);
    }

}
