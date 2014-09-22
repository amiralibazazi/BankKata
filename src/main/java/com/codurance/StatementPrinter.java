package com.codurance;

import java.text.DecimalFormat;

public class StatementPrinter {
    private static final DecimalFormat TWO_DECIMALS = new DecimalFormat("#.00");
    private double runningBalanceTotal;

    public StatementPrinter() {
        this.runningBalanceTotal = 0;
    }

    public void printTwoTabs() {
        System.out.print("\t\t");
    }

    public void printBalanceTotal() {
        System.out.print(TWO_DECIMALS.format(runningBalanceTotal));
    }

    public void updateTotalBalance(double transactionAmount) {
        runningBalanceTotal += transactionAmount;
    }

    public void printNewLine() {
        System.out.print("\n");
    }

    public void printTab() {
        System.out.print("\t");
    }
}
