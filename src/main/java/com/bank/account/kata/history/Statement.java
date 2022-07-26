package com.bank.account.kata.history;

import com.bank.account.kata.operation.Operation;
import com.bank.account.kata.utils.Fields;
import lombok.Data;
import lombok.Getter;

@Data
public class Statement {


    @Getter private Operation operation;
    @Getter private double balance;

    public Statement(Operation operation, double balance) {
        Fields.notNull(operation, "Operation should not be null");
        this.operation = operation;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "operation=" + operation.toString() +
                ", balance=" + balance +
                '}';
    }


}
