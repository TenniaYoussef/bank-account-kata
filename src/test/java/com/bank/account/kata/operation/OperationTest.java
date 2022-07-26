package com.bank.account.kata.operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class OperationTest {

    @Test
    void shouldThrowExceptionWhenDateIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Operation(OperationType.DEPOSIT, null, 10));
    }

    @Test
    void shouldThrowExceptionWhenOperationTypeIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Operation(null, new Date(), 10));
    }

}