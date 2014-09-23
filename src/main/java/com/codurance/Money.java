package com.codurance;

public class Money {

    public Money(double value) {
        if (value < 0) {
            throw new RuntimeException("Currency can not hold negative value");
        }
    }

    public Money add(Money transactionAmount) {
        return null;
    }

    public void printValue() {

    }
}
