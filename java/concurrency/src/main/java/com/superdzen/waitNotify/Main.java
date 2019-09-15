package com.superdzen.waitNotify;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> queue = new ArrayList<>();
        int MAX_CAPACITY = 5;

        Thread producer = new Thread(new Producer(queue, MAX_CAPACITY), "Producer");
        Thread consumer = new Thread(new Consumer(queue), "Consumer");

        producer.start();
        consumer.start();
    }
}
