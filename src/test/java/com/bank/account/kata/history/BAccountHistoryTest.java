package com.bank.account.kata.history;

import com.bank.account.kata.operation.Operation;
import com.bank.account.kata.operation.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class BAccountHistoryTest {

    BAccountHistory history;

    @BeforeEach
    public void init() {
        history = new BAccountHistory();
    }

    @Test
    public void whenAddingNewStatementItShouldExistInHistory() {
        Operation operation = new Operation(OperationType.DEPOSIT, new Date(), 100);
        Statement statement = new Statement(operation, 1100);

        history.addRecord(statement);

        assertThat(history.getHistory()).containsExactly(statement);
    }

}