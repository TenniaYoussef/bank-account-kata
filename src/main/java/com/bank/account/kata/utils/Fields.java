package com.bank.account.kata.utils;

import com.bank.account.kata.exception.AmountException;

import java.util.Objects;

public class Fields {

    public static <T> void notNull(T arg, String errorMessage) {
        if (Objects.isNull(arg)) {
            throw new NullPointerException(errorMessage);
        }
    }

    public static void strictPositive(double value) {
        if (value == 0) {
            throw new AmountException("No operation could be performed with amount = "+value);
        } else if(value < 0) {
            throw new AmountException("No operation could be performed with negative amount");
        }
    }
}
