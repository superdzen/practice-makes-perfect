package com.superdzen.thirty_days_of_code.day10_binary_numbers;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 25.06.2017.
 *
 * Given a base-10 integer, n, convert it to binary (base-2).
 * Then find and print the base-10 integer denoting the maximum number of consecutive 1's in n's binary representation.
 */
public class Day10BinaryNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        String str = Integer.toBinaryString(input);
        int maxConsecutive1 = 0;
        int curConsecutive1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='1'){
                curConsecutive1++;
                if (curConsecutive1>maxConsecutive1) maxConsecutive1 = curConsecutive1;
            }
            if (str.charAt(i)=='0'){
                curConsecutive1 = 0;
            }
        }
        System.out.println(str);
        System.out.println(maxConsecutive1);
    }
}
