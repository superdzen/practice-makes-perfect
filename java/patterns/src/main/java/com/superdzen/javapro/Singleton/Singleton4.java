package com.superdzen.javapro.Singleton;

/**
 * Created by superdzen@gmail.com on 27.05.2018.
 */
public class Singleton4 {
    private static int counter = 0;
    private static volatile Singleton4 instance = null;

    private Singleton4() {
        counter++;
    }

    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

    public static int getCounter() {
        return counter;
    }
}
