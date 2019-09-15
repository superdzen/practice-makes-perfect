package com.superdzen.waitNotify;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> queue = new ArrayList<>();
        int MAX_CAPACITY = 10;

        Thread producer1 = new Thread(new Producer(queue, MAX_CAPACITY), "Producer1");
        Thread producer2 = new Thread(new Producer(queue, MAX_CAPACITY), "Producer2");
        Thread consumer1 = new Thread(new Consumer(queue), "Consumer1");
        Thread consumer2 = new Thread(new Consumer(queue), "Consumer2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
