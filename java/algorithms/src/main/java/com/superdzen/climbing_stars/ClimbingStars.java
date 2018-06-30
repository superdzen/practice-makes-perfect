package com.superdzen.climbing_stars;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 08.07.2017.
 * This solution corresponds to the Fibonacci numbers
 * For n = 1, the output should be F(1) = 1;
 * For n = 2, the output should be F(2) = 2.
 * For another n>2 the answer should be sum of F(n-1) and F(n-2), but it is very slow
 * There is another way to calculate it.
 */
public class ClimbingStars {
    private static ArrayList<Long> fiboArray = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "You are climbing a stair case. It takes N steps to reach to the top. " +
                        "Each time you can either climb 1 or 2 steps." +
                        "In how many distinct ways can you climb to the top?");
        System.out.print("Enter the number of stair steps (positive): ");
        int n = scanner.nextInt();

        //calculating first solution
        long startTime = System.currentTimeMillis();
        System.out.print("Bad Implementation: The number of distinct ways is: " + climbingStairsRec(n) + ". ");
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " miliseconds");

        //calculating solution with another function (quicker)
        startTime = System.currentTimeMillis();
        System.out.print("Good Implementation: The number of distinct ways is: " + climbingStairs(n) + ". ");
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " miliseconds");
    }

    static long climbingStairsRec(int n) {

        if (n == 0 || n == 1) {
            return n;
        } else {
            return climbingStairsRec(n - 1) + climbingStairsRec(n - 2);
        }

    }

    static long climbingStairs(int n) {

        if (n == 0 || n == 1) {
            return n;
        } else {
            long result = 0;
            long a = 0;
            long b = 1;
            for (int i = 1; i < n; i++) {
                result = a + b;
                a = b;
                b = result;
            }
            return result;
        }

    }
}
