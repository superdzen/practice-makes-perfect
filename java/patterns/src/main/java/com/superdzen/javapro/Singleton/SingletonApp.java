package com.superdzen.javapro.Singleton;

/**
 * Created by superdzen@gmail.com on 27.05.2018.
 * Lambda works only in Java 8 or higher
 */
public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000;

        Thread threads[] = new Thread[SIZE];
        for (int s = 1; s <= 4; s++) {
            for (int i = 0; i < SIZE; i++) {
                switch (s) {
                    case 1:
                        threads[i] = new Thread(Singleton1::getInstance);
                        threads[i].start();
                        break;
                    case 2:
                        threads[i] = new Thread(Singleton2::getInstance);
                        threads[i].start();
                        break;
                    case 3:
                        threads[i] = new Thread(Singleton3::getInstance);
                        threads[i].start();
                        break;
                    case 4:
                        threads[i] = new Thread(Singleton4::getInstance);
                        threads[i].start();
                        break;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            threads[i].join();
        }

        System.out.println("Singleton1 doesn't always work in multithreading! Singleton2 Counter = " + Singleton1.getCounter());
        if (Singleton2.getCounter() == 1) {
            System.out.println("Singleton2 works in multithreading! Singleton2 counter = " + Singleton2.getCounter());
        } else {
            System.out.println("Singleton2 doesn't work in multithreading! Singleton2 counter = " + Singleton2.getCounter());
        }
        if (Singleton3.getCounter() == 1) {
            System.out.println("Singleton3 works in multithreading! Singleton3 counter = " + Singleton3.getCounter());
        } else {
            System.out.println("Singleton3 doesn't work in multithreading! Singleton3 counter = " + Singleton3.getCounter());
        }
        if (Singleton4.getCounter() == 1) {
            System.out.println("Singleton4 works in multithreading! Singleton4 counter = " + Singleton4.getCounter());
        } else {
            System.out.println("Singleton4 doesn't work in multithreading! Singleton4 counter = " + Singleton4.getCounter());
        }
    }
}
