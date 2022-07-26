package com.bank.account.kata;

import com.bank.account.kata.account.BankAccount;
import com.bank.account.kata.exception.AmountException;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);

        try {
            bankAccount.deposit(200);
            bankAccount.withdraw(400);
            bankAccount.printHistory();
        } catch (AmountException e) {
            Logger.getLogger("Main")
                    .warning(e.getMessage());
        }

    }
}
