package com.superdzen.thirty_days_of_code.day25_running_time_and_complexity;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 15.07.2017.
 * https://www.hackerrank.com/challenges/30-running-time-and-complexity/
 * A prime is a natural number greater than 1 that has no positive divisors other than  and itself.
 * Given a number, n, determine and print whether it's Prime or Not prime.
 */
public class Day25RunningTimeandComplexity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        int n;
        while (numOfCases-- > 0) {
            n = scanner.nextInt();
            if (isPrime(n)) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
