package com.superdzen.ctci_big_o;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 24.10.2017.
 * https://www.hackerrank.com/challenges/ctci-big-o
 * A prime is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * Given p integers, determine the primality of each integer and print whether it is Prime or Not prime on a new line.
 */
public class TimeComplexityPrimality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int n;
        while (p-- > 0) {
            n = scanner.nextInt();
            if (isPrime(n)) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        } else if (n == 1 || (n % 2) == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
