package com.codurance;

public class StatementPrinter {
    public static final String STATEMENT_HEADER = "DATE\t\tAMOUNT\t\tBALANCE";
    private Money balanceTotal;

    public StatementPrinter() {
        balanceTotal = new Money(0.00);
    }

    public void printTwoTabs() {
        System.out.print("\t\t");
    }

    public void printBalanceTotal() {
        balanceTotal.printValue();
    }

    public void increaseBalanceTotalBy(Money transactionAmount) {
        balanceTotal.add(transactionAmount);
    }

    public void printNewLine() {
        System.out.print("\n");
    }

    public void printTab() {
        System.out.print("\t");
    }

    public void decreaseBalanceTotalBy(Money amount) {
        balanceTotal.deduct(amount);
    }

    public void printStatementHeader() {
        System.out.print(STATEMENT_HEADER);
    }
}
