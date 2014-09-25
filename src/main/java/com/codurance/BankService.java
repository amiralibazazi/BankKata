package com.codurance;

public class BankService {

    private TransactionRepository transactionRepository;

    public BankService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(Money amount) {
        transactionRepository.store(new DepositTransaction(amount));
    }

    public void withdraw(Money amount) {

    }

    public void printStatement() {

    }
}
