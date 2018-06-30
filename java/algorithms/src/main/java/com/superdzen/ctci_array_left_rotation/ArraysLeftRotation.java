package com.superdzen.ctci_array_left_rotation;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 14.08.2017.
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 * A left rotation operation on an array shifts each of the array's elements 1 unit to the left.
 * For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].
 * <p>
 * Given an array a of n integers and a number, d, perform d left rotations on the array.
 * Return the updated array to be printed as a single line of space-separated integers.
 */
public class ArraysLeftRotation {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        for (int i : leftRotationArray2(a, k)) {
            System.out.print(i + " ");
        }

    }

    /*
     * Simple solution - using System.arraycopy function
     * */
    public static int[] leftRotationArray(int[] srcArray, int shift) {

        int arrayLength = srcArray.length;
        int[] resultArray = new int[arrayLength];

        System.arraycopy(srcArray, shift, resultArray, 0, arrayLength - shift);
        System.arraycopy(srcArray, 0, resultArray, arrayLength, shift);

        return resultArray;

    }

    /*
     * Another solution - using modular arithmetic
     * */
    public static int[] leftRotationArray2(int[] srcArray, int shift) {

        int arrayLength = srcArray.length;
        int[] resultArray = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            resultArray[i] = srcArray[(i + shift) % arrayLength];
        }

        return resultArray;

    }
}
