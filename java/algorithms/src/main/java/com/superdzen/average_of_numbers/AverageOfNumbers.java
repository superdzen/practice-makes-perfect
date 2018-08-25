package com.superdzen.average_of_numbers;

import java.util.Arrays;

/**
 * Created by superdzen@gmail.com on 02.07.2017.
 * https://www.codewars.com/kata/57d2807295497e652b000139
 *
 * Write a method, that gets an array of integer-numbers and return an array of the averages of each integer-number and his follower, if there is one.
 * Example:
 * Input:  [ 1, 3, 5, 1, -10]
 * Output:  [ 2, 4, 3, -4.5]
 * If the array has 0 or 1 values or is null or None, your method should return an empty array.
 */
public class AverageOfNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(averages(new int[]{1, 3, 5, 1, -10})));
    }
    public static double[] averages(int[] numbers) {
        if (numbers == null || numbers.length == 0 || numbers.length == 1) return new double[0];
        double[] outputNumbers = new double[numbers.length - 1];
        for (int i = 0; i < outputNumbers.length; i++) {
            outputNumbers[i] = (double) (numbers[i] + numbers[i + 1]) / 2;
        }
        return outputNumbers;
    }
}
