package com.codurance;

public class BankService {
    /*
        Next time, I would do this differently by having the
        bank service do something like .process(new DepositTransaction(account1, account2, 200.00)/
        rather than calling methods on the actual account, actually maybe I can still implement that.
        '-> using a TransactionProcessor or something to process the transaction
     */
    public BankAccount createAccount() {
        return new BankAccount(new TransactionLog());
    }
}