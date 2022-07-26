package com.bank.account.kata.account;

import com.bank.account.kata.exception.AmountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

class BankAccountTest {

    BankAccount bankAccount;

    @BeforeEach
    void init() {
        bankAccount = new BankAccount(1000);
    }

    @Test
    void depositWithNegativeAmountThrowAmountException() {
        Assertions.assertThrows(AmountException.class, () -> bankAccount.deposit(-50));
    }

    @Test
    void depositWithAmountZeroThrowAmountException() {
        Assertions.assertThrows(AmountException.class, () -> bankAccount.deposit(0));
    }

    @Test
    void depositWithPositiveAmount() {
        double depositAmount = 1000;
        double initialBalance = bankAccount.getBalance();
        bankAccount.deposit(depositAmount);
        assertThat(bankAccount.getBalance()-depositAmount).isEqualTo(initialBalance);
    }

    @Test
    void withdrawWithNegativeAmountThrowAmountException() {
        Assertions.assertThrows(AmountException.class, () -> bankAccount.withdraw(-50));
    }

    @Test
    void withdrawWithAmountZeroThrowAmountException() {
        Assertions.assertThrows(AmountException.class, () -> bankAccount.withdraw(0));
    }

    @Test
    void withdrawWithAmountBiggerThanBalanceReturnLogInf() {
        bankAccount.withdraw(1500);
        assertThat(Logger.getLogger(bankAccount.getClass().getName())).isNotNull();
    }

    @Test
    void withdrawWithAmountLessOrEqualToBalance() {
        double withdrawAmount = 1000;
        double initialBalance = bankAccount.getBalance();
        bankAccount.withdraw(withdrawAmount);
        assertThat(bankAccount.getBalance()+withdrawAmount).isEqualTo(initialBalance);
    }

    @Test
    void historyContainsDepositRecord() {
        bankAccount.deposit(1000);
        assertThat(bankAccount.getHistory().getHistory().size()).isEqualTo(1);
    }

    @Test
    void historyContainsWithdrawRecord() {
        bankAccount.withdraw(1000);
        assertThat(bankAccount.getHistory().getHistory().size()).isEqualTo(1);
    }

    @Test
    void givenSystemOutRedirectionWhenInvokePrintlnThenOutputCaptorSuccess() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        bankAccount.deposit(1000);

        bankAccount.printHistory();

        assertThat(bankAccount.getHistory().getHistory().get(0).toString())
                .isEqualTo(outputStreamCaptor.toString()
                .trim());

    }
}