package com.superdzen.emailapp;

/**
 * Created by superdzen@gmail.com on 20.05.2018.
 */
public class EmailApp {
    public static void main(String[] args) {
        Email eml = new Email("John", "Smith");

        System.out.println(eml.showInfo());
    }
}
