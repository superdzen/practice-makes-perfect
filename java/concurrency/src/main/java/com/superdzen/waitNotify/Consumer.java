package com.superdzen.waitNotify;

import java.util.List;

/**
 * Consumer tries to get one value from queue and print it
 */
public class Consumer implements Runnable {
    private final List<Integer> taskQueue;

    public Consumer(List<Integer> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.isEmpty()) {
                System.out.println("Task queue is empty. " + Thread.currentThread().getName() + " is waiting. Size = " + taskQueue.size());
                taskQueue.wait();
            }
            int e = taskQueue.remove(0);
            System.out.println("Consumed: " + e);
            taskQueue.notifyAll();
            Thread.sleep(500);
        }
    }
}
