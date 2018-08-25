package com.superdzen.bankaccountapp;

import com.superdzen.bankaccountapp.utilities.CSV;

import java.util.LinkedList;
import java.util.List;
/**
 * Created by superdzen@gmail.com on 29.05.2018.
 */
public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<>();
        String file = "src/main/java/com/superdzen/others/bankaccountapp/resources/NewBankAccounts.csv";
        // Read a CSV file then create new accounts based on the file
        List<String[]> newCustomers = CSV.read(file);
        for (String[] newCustomer : newCustomers) {
            String name = newCustomer[0];
            String sSN = newCustomer[1];
            String accountType = newCustomer[2];
            double initDeposit = Double.parseDouble(newCustomer[3]);
            switch (accountType) {
                case "Savings":
                    accounts.add(new Savings(name, sSN, initDeposit));
                    break;
                case "Checking":
                    accounts.add(new Checking(name, sSN, initDeposit));
                    break;
                default:
                    System.out.println("ERROR READING ACCOUNT TYPE");
                    break;
            }
        }
        for (Account acc : accounts) {
            acc.showInfo();
        }
    }
}