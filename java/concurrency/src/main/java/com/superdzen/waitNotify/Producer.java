package com.superdzen.waitNotify;

import java.util.List;

/**
 * Producer generates an integer value and add it to the queue
 */
public class Producer implements Runnable {
    private final List<Integer> taskQueue;
    private final int MAX_CAPACITY;

    public Producer(List<Integer> taskQueue, int max_capacity) {
        this.taskQueue = taskQueue;
        MAX_CAPACITY = max_capacity;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                produce(counter++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.size() == MAX_CAPACITY) {
                System.out.println("Queue is full. " + Thread.currentThread().getName() + " is waiting. Size = " + taskQueue.size());
                taskQueue.wait();
            }
            taskQueue.add(i);
            System.out.println("Produced: " + i);
            taskQueue.notifyAll();
            Thread.sleep(500);
        }
    }
}
