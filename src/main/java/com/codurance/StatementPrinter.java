package com.codurance;

import java.text.DecimalFormat;

public class StatementPrinter {
    private static final DecimalFormat TWO_DECIMALS = new DecimalFormat("#.00");
    private Money balanceTotal;

    public StatementPrinter() {
        balanceTotal = new Money(0.00);
    }

    public void printTwoTabs() {
        System.out.print("\t\t");
    }

    public void printBalanceTotal() {
        System.out.print(TWO_DECIMALS.format(balanceTotal));
    }

    public void increaseBalanceTotalBy(Money transactionAmount) {
        balanceTotal = balanceTotal.add(transactionAmount);
    }

    public void printNewLine() {
        System.out.print("\n");
    }

    public void printTab() {
        System.out.print("\t");
    }

    public void decreaseBalanceTotalBy(Money transactionAmount) {

    }
}
