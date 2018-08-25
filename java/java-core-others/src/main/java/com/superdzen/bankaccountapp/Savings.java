package com.superdzen.bankaccountapp;

/**
 * Created by superdzen@gmail.com on 29.05.2018.
 */
public class Savings extends Account {
    // List properties specific to a Savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize settings for the Savings properties
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        this.rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) generateRandomNumber(3);
        safetyDepositBoxKey = (int) generateRandomNumber(4);
    }

    // List any methods specific to savings account
    public void showInfo() {
        super.showInfo();
        System.out.println(" Your Savings account features:" +
                "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + safetyDepositBoxKey);
    }
}