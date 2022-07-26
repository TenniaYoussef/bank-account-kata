package com.bank.account.kata.operation;

import com.bank.account.kata.utils.Fields;
import lombok.Getter;

import java.util.Date;

public class Operation {

    @Getter private final OperationType operationType;
    @Getter private final Date operationDate;
    @Getter private final double amount;

    public Operation(OperationType operationType, Date operationDate, double amount) {
        Fields.notNull(operationType, "OperationType should not be null.");
        Fields.notNull(operationDate, "OperationDate should not be null.");
        this.operationType = operationType;
        this.operationDate = new Date(operationDate.getTime());
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationType=" + operationType +
                ", amount=" + amount +
                ", operationDate=" + operationDate +
                '}';
    }

}
