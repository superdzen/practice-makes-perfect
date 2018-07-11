package com.superdzen.counters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by superdzen@gmail.com on 22.08.2017.
 * This class makes 100 additions in 100000 threads synchronously
 */
public class SyncCounter {
    int counter = 0;

    public static void main(String[] args) {
        SyncCounter syncCounter = new SyncCounter();
        List<CounterThread> threadList = new ArrayList<>();

        //create 10000 threads
        for (int i = 0; i < 10000; i++) {
            threadList.add(new CounterThread(syncCounter));
        }

        //waiting for all threads
        try {
            for (CounterThread counterThread : threadList) {
                counterThread.thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counters = " + syncCounter.counter);
    }
}

class CounterThread implements Runnable {
    Thread thread;
    private final SyncCounter syncCounter;

    CounterThread(SyncCounter syncC) {
        thread = new Thread(this);
        this.syncCounter = syncC;
        thread.start();
    }

    @Override
    public void run() {
        synchronized (syncCounter) {
            for (int i = 0; i < 100; i++) {
                syncCounter.counter++;
            }
        }
    }
}