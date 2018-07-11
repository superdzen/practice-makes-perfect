package com.superdzen.javapro.Singleton;

/**
 * Created by superdzen@gmail.com on 27.05.2018.
 */
public class Singleton3 {
    private static int counter = 0;
    private static Singleton3 instance = null;

    private Singleton3() {
        counter++;
    }

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }

    public static int getCounter() {
        return counter;
    }
}
