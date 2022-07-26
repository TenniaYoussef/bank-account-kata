package com.bank.account.kata.history;

import java.util.List;

public interface Historisable<E> {

    List<E> getHistory();

    void addRecord(E record);

    void printHistory();
}
