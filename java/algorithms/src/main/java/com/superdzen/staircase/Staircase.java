package com.superdzen.staircase;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 19.11.2017.
 * Input: 5
 * Output:
 * ____#
 * ___##
 * __###
 * _####
 * #####
 */
public class Staircase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        StringBuilder step = new StringBuilder("");

        for (int i = 0; i < n; i++) {
            step.append("_");
        }

        for (int i = 1; i <= n; i++) {
            step.replace(n - i, n - i + 1, "#");
            System.out.println(step.toString());
        }
    }
}
