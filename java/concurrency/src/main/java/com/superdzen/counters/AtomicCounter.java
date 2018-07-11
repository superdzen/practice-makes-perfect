package com.superdzen.counters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by superdzen@gmail.com on 22.08.2017.
 */
public class AtomicCounter {
    AtomicInteger aCounter = new AtomicInteger();

    public static void main(String[] args) {
        AtomicCounter atomicCounter = new AtomicCounter();
        List<AtomicCounterThread> atomicCounterThreadList = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            atomicCounterThreadList.add(new AtomicCounterThread(atomicCounter));
        }

        try {
            for (AtomicCounterThread atomicCounterThread : atomicCounterThreadList) {
                atomicCounterThread.thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counters = " + atomicCounter.aCounter.get());

    }
}

class AtomicCounterThread implements Runnable {
    AtomicCounter atomicCounter;
    Thread thread;

    public AtomicCounterThread(AtomicCounter atomicCounter) {
        thread = new Thread(this);
        this.atomicCounter = atomicCounter;
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            atomicCounter.aCounter.getAndIncrement();
        }
    }
}