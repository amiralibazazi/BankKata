package com.codurance;

import static java.time.LocalDate.now;

public class BankService {

    private TransactionRepository transactionRepository;

    public BankService(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(Money amount) {
        transactionRepository.store(new DepositTransaction(amount, new TransactionDate(now())));
    }

    public void withdraw(Money amount) {
        transactionRepository.store(new WithdrawalTransaction(amount, new TransactionDate(now())));
    }

    public void printStatement(StatementPrinter statementPrinter) {
        transactionRepository.printStatement(statementPrinter);
    }
}
