package com.superdzen.thirty_days_of_code.day29_bitwise_and;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 08.08.2017.
 * https://www.hackerrank.com/challenges/30-bitwise-and
 */
public class Day29BitwiseAND {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int i = 0; i < numTestCases; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int max = 0;
            for (int j = 1; j < N; j++) {
                for (int k = j+1; k <= N; k++) {
                    int tempMax = j & k;
                    if ((tempMax > max) && (tempMax < K)) {
                        max = tempMax;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
