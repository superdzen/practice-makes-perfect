package com.superdzen.first_duplicate;

/**
 * Created by superdzen@gmail.com on 02.07.2017.
 * https://codefights.com/interview-practice/task/pMvymcahZ8dY4g75q
 * <p>
 * Given an array a that contains only numbers in the range from 1 to a.length,
 * find the first duplicate number for which the second occurrence has the minimal index.
 * In other words, if there are more than 1 duplicated numbers, return the number for which the second occurrence
 * has a smaller index than the second occurrence of the other number does. If there are no such elements, return -1.
 */
public class FirstDuplicate {
    public static void main(String[] args) {
        System.out.println(firstDuplicate(new int[]{2, 3, 3, 1, 5, 2}));
    }

    private static int firstDuplicate(int[] a) {
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < j; i++) {
                if (a[j] == a[i]) {
                    return (a[j]);
                }
            }
        }
        return -1;
    }
}
