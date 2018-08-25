package com.superdzen.thirty_days_of_code.day20_sorting;

import java.util.*;

/**
 * Created by superdzen@gmail.com on 10.07.2017.
 * https://www.hackerrank.com/challenges/30-sorting
 * Just Bubble Sorting
 */
public class Day20Sorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int sumOfSwaps = 0;
        for (int i = 0; i < a.length; i++) {
            int numberOfSwaps = 0;
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                }
            }
            sumOfSwaps += numberOfSwaps;
            if (numberOfSwaps == 0) {
                break;
            }
        }

        System.out.println("Array is sorted in " + sumOfSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

    public static void swap(int[] arr, int j, int k) {
        int t = arr[j];
        arr[j] = arr[k];
        arr[k] = t;
    }
}
