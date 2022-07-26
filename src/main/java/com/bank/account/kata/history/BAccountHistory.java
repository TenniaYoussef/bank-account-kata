package com.bank.account.kata.history;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BAccountHistory implements Historisable<Statement> {

    private final List<Statement> history = new ArrayList<>();

    @Override
    public List<Statement> getHistory() {
        return history;
    }

    @Override
    public void addRecord(Statement statement) {
        if (!Objects.isNull(statement)) {
            history.add(statement);
        }
    }

    @Override
    public void printHistory() {
        history.forEach(statement -> System.out.println(statement.toString()));
    }
}
