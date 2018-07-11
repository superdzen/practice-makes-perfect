package com.superdzen.thirty_days_of_code.day19_interfaces;

import java.util.*;

/**
 * Created by superdzen@gmail.com on 09.07.2017.
 * https://www.hackerrank.com/challenges/30-interfaces/
 * Find the sum of number`s divisors.
 * Interface below is just for example of interface.
 */

interface AdvancedArithmetic {
    int divisorSum(int n);
}

class Calculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int sqrtOfN = (int) Math.sqrt(n);
        int sum = 0;

        //we can count from 1 to sqrt(n), because we add 2 divisors at a time
        for (int i = 1; i <= sqrtOfN; i++) {
            if (n % i == 0) {
                sum += i + n / i;   //if we found i as divisor for n, we can sum i and (int n / int i)
            }
        }

        //if the condition is true, sqrtOfN added twice, and we need to subtract it
        if (sqrtOfN * sqrtOfN == n) {
            sum -= sqrtOfN;
        }
        return sum;
    }
}

public class Day19Interfaces {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myCalculator = new Calculator();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
        System.out.println(sum);
    }
}
