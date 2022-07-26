package com.bank.account.kata.history;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StatementTest {


    @Test
    void whenOperationIsNullThenShouldThrowException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Statement(null, 0));
    }

}