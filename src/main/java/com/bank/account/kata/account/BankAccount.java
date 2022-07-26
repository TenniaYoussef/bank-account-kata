package com.bank.account.kata.account;

import com.bank.account.kata.history.BAccountHistory;
import com.bank.account.kata.history.Statement;
import com.bank.account.kata.operation.Operation;
import com.bank.account.kata.operation.OperationType;
import com.bank.account.kata.utils.Fields;
import lombok.extern.java.Log;

import java.util.Date;

@Log
public class BankAccount {

    private double balance;
    private BAccountHistory history;

    public BankAccount(double balance) {
        this.balance = balance;
        this.history = new BAccountHistory();
    }

    public BankAccount(double balance, BAccountHistory history) {
        Fields.notNull(history, "History should not be null.");
        this.balance = balance;
        this.history = history;
    }

    public void deposit(double depositAmount) {
        Fields.strictPositive(depositAmount);
        executeOperation(OperationType.DEPOSIT, depositAmount);
    }

    public double withdraw(double withdrawAmount) {
        Fields.strictPositive(withdrawAmount);
        if(withdrawAmount > balance) {
            log.warning(String.format("Withdraw operation could not be processed : amount %s is greater than current balance %s",
                    withdrawAmount,
                    balance));
        } else {
            executeOperation(OperationType.WITHDRAW, -withdrawAmount);
        }
        return withdrawAmount;
    }

    public void printHistory() {
        history.printHistory();
    }

    private synchronized void executeOperation(OperationType operationType, double amount) {
        balance += amount;
        addOperationToHistory(operationType, amount);
    }

    private void addOperationToHistory(OperationType operationType, double amount) {
        Operation operation = new Operation(operationType, new Date(), Math.abs(amount));
        Statement statement = new Statement(operation, this.getBalance());

        history.addRecord(statement);
    }

    public double getBalance() {
        return balance;
    }

    public BAccountHistory getHistory() {
        return history;
    }
}
