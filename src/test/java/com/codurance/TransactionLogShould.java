package com.codurance;

import com.codurance.Transactions.DepositTransaction;
import com.codurance.Transactions.Transaction;
import com.codurance.Transactions.TransferTransaction;
import com.codurance.Transactions.WithdrawalTransaction;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionLogShould {
    TransactionLog transactionLog;
    Transaction deposit;
    Transaction withdrawal;

    @Before
    public void initialise() {
        transactionLog = new TransactionLog();
        deposit = new DepositTransaction();
        withdrawal = new WithdrawalTransaction();
    }

    @Test public void
    add_a_deposit_transaction_to_a_list_of_transactions() {
        transactionLog.store(deposit);
        assertThat(transactionLog.containsTransaction(deposit), is(true));
    }

    @Test public void
    add_a_withdrawal_transaction_to_a_list_of_transactions() {
        transactionLog.store(withdrawal);
        assertThat(transactionLog.containsTransaction(withdrawal), is(true));
        assertThat(transactionLog.containsTransaction(deposit), is(false));
    }

    @Test public void
    add_a_transfer_transaction_to_a_list_of_transactions() {
        Transaction transfer = new TransferTransaction();
        transactionLog.store(transfer);
        assertThat(transactionLog.containsTransaction(transfer), is(true));
        assertThat(transactionLog.containsTransaction(deposit), is(false));
    }

    @Test public void
    add_the_receipt_of_a_tranfser_to_a_list_of_transactions() {
        Transaction receipt = new ReceiptTransaction();
        transactionLog.store(receipt);
        assertThat(transactionLog.containsTransaction(receipt), is(true));
    }
}
