package com.superdzen.thirty_days_of_code.day11_2d_arrays;

import java.util.Scanner;

/**
 * 2D Array Hour Glass
 * We define an hourglass in array to be a subset of values with indices falling in this pattern in array's graphical representation:
 * a b c
 * d
 * e f g
 *
 * Calculate the hourglass sum for every hourglass in array, then print the maximum hourglass sum.
 */
public class Day112DArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrayLength = 6;
        int arr[][] = new int[arrayLength][arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int maxHourglassSum = Integer.MIN_VALUE;
        for (int i = 1; i < arrayLength - 1; i++) {
            for (int j = 1; j < arrayLength - 1; j++) {
                int curHourglassSum = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1]
                                                        + arr[i][j]
                                    + arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1];
                if (curHourglassSum > maxHourglassSum) maxHourglassSum = curHourglassSum;
            }
        }
        System.out.println(maxHourglassSum);
    }
}
