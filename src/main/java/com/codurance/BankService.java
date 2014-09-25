package com.codurance;

public class BankService {

    private TransactionRepository transactionRepository;

    public BankService(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(Money amount) {
        transactionRepository.store(new DepositTransaction(amount));
    }

    public void withdraw(Money amount) {
        transactionRepository.store(new WithdrawalTransaction(amount));
    }

    public void printStatement(StatementPrinter statementPrinter) {
        transactionRepository.printStatement(statementPrinter);
    }
}
