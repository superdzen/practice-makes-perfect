package com.superdzen.javapro.Singleton;

/**
 * Created by superdzen@gmail.com on 27.05.2018.
 */
public class Singleton2 {
    private static int counter = 0;
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {
        counter++;
    }

    public static Singleton2 getInstance() {
        return instance;
    }

    public static int getCounter() {
        return counter;
    }
}
