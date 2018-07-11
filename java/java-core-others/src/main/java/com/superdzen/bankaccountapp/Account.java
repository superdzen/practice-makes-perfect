package com.superdzen.bankaccountapp;

import java.util.Random;

/**
 * Created by superdzen@gmail.com on 29.05.2018.
 */
public abstract class Account implements IBaseRate {
    // List common properties for saving and checking account
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) generateRandomNumber(4);
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    // List common methods
    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued interest: " + accruedInterest);
        printBalance();
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transfering to: " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo() {
        System.out.println("**************");
        System.out.println("NAME: " + name +
                "\nACCOUNT NUMBER: " + accountNumber +
                "\nBALANCE: " + balance +
                "\nRATE: " + rate + "%"
        );
    }

    protected long generateRandomNumber(int size) {
        Random r = new Random();
        if (size <= 0) {
            size = 1;
        }
        long leftLimit = (long) (1L * (Math.pow(10, size - 1)));
        long rightLimit = (long) (10L * (Math.pow(10, size - 1)) - 1);
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }
}