package com.codurance;

import org.junit.Test;

public class MoneyShould {

    private static final double NEGATIVE_AMOUNT = -100.00;

    @Test(expected=RuntimeException.class) public void
    throw_an_exception_when_handling_a_negative_value() {
        Money negativeMoney = new Money(NEGATIVE_AMOUNT);
    }
}
