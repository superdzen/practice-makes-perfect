package com.superdzen.counters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by superdzen@gmail.com on 26.08.2017.
 */
public class CounterCSC {
    private static int counter = 0;
    private static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static synchronized int nextInt() {
        return counter++;
    }

    public static int nextAtomicInt() {
        return atomicCounter.getAndIncrement();
    }

    public static void main(String[] args) {

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    nextInt();
                    nextAtomicInt();
                }
            });
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Counters final value = " + counter);
        System.out.println("AtomicCounters final value = " + atomicCounter.get());

    }
}
