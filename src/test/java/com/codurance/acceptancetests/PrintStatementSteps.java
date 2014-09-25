package com.codurance.acceptancetests;

import com.codurance.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;

public class PrintStatementSteps {

    private BankService bankService;
    private StatementPrinter statementPrinter;
    private TransactionRepository transactionRepository;

    @Before
    public void initialise() {
        bankService = new BankService(transactionRepository, statementPrinter);
    }

    @Given("^a client makes a deposit of (\\d+) on \"(.*?)\"$")
    public void a_client_makes_a_deposit_of_on(double amount, TransactionDate date) throws Throwable {
        Money someMoney = new Money(amount);
        bankService.deposit(someMoney);
        throw new PendingException();
    }

    @Given("^a withdrawal of (\\d+) on \"(.*?)\"$")
    public void a_withdrawal_of_on(double amount, TransactionDate date) throws Throwable {
        Money someMoney = new Money(amount);
        bankService.withdraw(someMoney);
        throw new PendingException();
    }

    @Given("^a deposit of (\\d+) on \"(.*?)\"$")
    public void a_transfer_of_on(double amount, TransactionDate date) throws Throwable {
        Money someMoney = new Money(amount);
        bankService.deposit(someMoney);
        throw new PendingException();
    }

    @When("^she prints her bank statement$")
    public void she_prints_her_bank_statement() throws Throwable {
        bankService.printStatement(statementPrinter);
        throw new PendingException();
    }

    @Then("^she would see$")
    public void she_would_see(Statement statement) throws Throwable {
        Console.print(statement);
        throw new PendingException();
    }

}
