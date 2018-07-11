package com.superdzen.bankaccountapp;

/**
 * Created by superdzen@gmail.com on 29.05.2018.
 */
public class Checking extends Account {
    // List properties specific to a checking account
    private long debitCardNumber;
    private int debitCardPIN;

    // Constructor to initialize Checking account properties
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate() {
        this.rate = getBaseRate() * 0.15;
    }

    private void setDebitCard() {
        debitCardNumber = generateRandomNumber(12);
        debitCardPIN = (int) generateRandomNumber(4);
    }

    // List any methods specific to the Checking account
    public void showInfo() {
        super.showInfo();
        System.out.println(" Your Checking account features:" +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card PIN: " + debitCardPIN);
    }

}