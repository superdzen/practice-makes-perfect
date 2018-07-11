package com.superdzen.javapro.Singleton;

/**
 * Created by superdzen@gmail.com on 27.05.2018.
 */
public class Singleton1 {
    private static int counter = 0;
    private static Singleton1 instance;

    private Singleton1() {
        counter++;
    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

    public static void resetInstance() {
        if (instance != null) {
            instance = null;
            counter = 0;
        }
    }

    public static int getCounter() {
        return counter;
    }
}
