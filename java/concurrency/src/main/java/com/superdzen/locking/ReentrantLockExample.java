package com.superdzen.locking;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        Thread[] threads = new Thread[15];

        PrinterQueue printerQueue = new PrinterQueue();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new PrintingJob(printerQueue));
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}


class PrintingJob implements Runnable {
    private PrinterQueue printerQueue;

    PrintingJob(PrinterQueue printerQueue) {
        this.printerQueue = printerQueue;
    }

    @Override
    public void run() {
        printerQueue.printJob(new Object());
    }
}

class PrinterQueue {
    private final Lock lock = new ReentrantLock();

    void printJob(Object document) {
        lock.lock();
        try {
            long duration = (long) (Math.random() * 5000);
            System.out.println(LocalDateTime.now() + ": " + Thread.currentThread().getName() + ": printing started. Object: " + document);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(LocalDateTime.now() + ": " + Thread.currentThread().getName() + ": printing finished");
            lock.unlock();
        }
    }
}