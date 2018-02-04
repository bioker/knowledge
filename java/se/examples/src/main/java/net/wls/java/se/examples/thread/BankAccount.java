package net.wls.java.se.examples.thread;

import lombok.Getter;

public class BankAccount {

    @Getter
    private int balance;

    public BankAccount(int initBalance) {
        balance = initBalance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
