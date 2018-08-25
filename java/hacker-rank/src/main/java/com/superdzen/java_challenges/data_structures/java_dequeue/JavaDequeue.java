package com.superdzen.java_challenges.data_structures.java_dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 22.10.2017.
 * https://www.hackerrank.com/challenges/java-dequeue
 */
public class JavaDequeue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> hashSet = new HashSet<>();

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            deque.addLast(num);
            hashSet.add(num);

            if (deque.size() == m + 1) {
                int out = deque.removeFirst();
                if (!deque.contains(out)) {
                    hashSet.remove(out);
                }
            }
            max = Math.max(hashSet.size(), max);

        }
        System.out.println(max);
    }
}
