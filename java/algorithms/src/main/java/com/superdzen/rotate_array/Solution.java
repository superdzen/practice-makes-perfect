package com.superdzen.rotate_array;

import java.util.Arrays;

public class Solution {

    // Time complexity = O(n), Space complexity = O(n)
    private static void rotateUsingExtraArray(int[] arr, int k) {
        int length = arr.length;
        int[] tmp = new int[length];

        for (int i = 0; i < length; i++) {
            tmp[(i + k) % length] = arr[i];
        }
        System.arraycopy(tmp, 0, arr, 0, length);
    }

    // Time complexity = O(n), Space complexity = O(1)
    private static void rotateUsingReverse(int[] arr, int k) {
        int length = arr.length;
        if (k > length) {
            System.out.println("k cannot be greater than array length!");
            return;
        }
        reverse(arr, 0, length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Initial array : " + Arrays.toString(arr));

        int k = 3;
        rotateUsingExtraArray(arr, k);
        System.out.println("Rotating " + k + " times : " + Arrays.toString(arr)); // [5, 6, 7, 1, 2, 3, 4]

        k = 4;
        rotateUsingReverse(arr, k);
        System.out.println("Rotating " + k + " times : " + Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6, 7]
    }
}
