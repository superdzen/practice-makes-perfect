package com.superdzen.bankaccountapp;

/**
 * Created by superdzen@gmail.com on 29.05.2018.
 */
public interface IBaseRate {
    // Write a method that returns the base rate
    default double getBaseRate() {
        return 2.5;
    }
}
