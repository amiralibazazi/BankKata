package com.codurance;

import java.text.DecimalFormat;

public class Money {

    private double value;
    private final DecimalFormat TWO_DECIMAL_FORMAT = new DecimalFormat("#.00");

    public Money(double value) {
        if (value < 0) {
            throw new RuntimeException("Currency can not hold negative value");
        }
        this.value = value;
    }

    public Money add(Money amountToAdd) {
        value += amountToAdd.value;
        return this;
    }

    public Money deduct(Money amountToDeduct) {
        value -= amountToDeduct.value;
        return this;
    }

    private String toTwoDecimals(double value) {
        return TWO_DECIMAL_FORMAT.format(value);
    }

    public void printValue() {
        System.out.print(toTwoDecimals(value));
    }
}
