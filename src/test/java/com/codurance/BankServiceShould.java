package com.codurance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BankServiceShould {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private BankService bankService = new BankService(transactionRepository);

    @Test public void
    process_a_deposit_transaction() {
        Money money_to_deposit = new Money(20.00);
        bankService.deposit(money_to_deposit);
        verify(transactionRepository).store(any(DepositTransaction.class));
    }

    @Test public void
    process_a_withdrawal_transaction() {
        Money money_to_withdraw = new Money(30.00);
        bankService.withdraw(money_to_withdraw);
        verify(transactionRepository).store(any(WithdrawalTransaction.class));
    }
}