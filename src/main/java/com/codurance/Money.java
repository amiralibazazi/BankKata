package com.codurance;

import java.text.DecimalFormat;

public class Money {

    private final double value;
    private final DecimalFormat TWO_DECIMAL_FORMAT = new DecimalFormat("#.00");

    public Money(double value) {
        if (value < 0) {
            throw new RuntimeException("Currency can not hold negative value");
        }
        this.value = value;
    }

    public Money add(Money transactionAmount) {
        return null;
    }

    public void printValue() {
        System.out.print(toTwoDecimals(value));
    }

    private String toTwoDecimals(double value) {
        return TWO_DECIMAL_FORMAT.format(value);
    }
}
