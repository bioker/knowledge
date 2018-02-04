package net.wls.java.se.examples;

import net.wls.java.se.examples.thread.BankAccount;
import org.junit.Test;


public class ThreadTest {

    public static void transfer(BankAccount bankAccount1, BankAccount bankAccount2, int amount) {
        if (bankAccount1.getBalance() < amount) {
            throw new RuntimeException("amount more than balance");
        }
        bankAccount1.withdraw(amount);
        bankAccount2.deposit(amount);
    }

    @Test
    public void test() {
        final BankAccount a = new BankAccount(1000);
        final BankAccount b = new BankAccount(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                transfer(a, b, 500);
            }
        }).start();
    }
}
