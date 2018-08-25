package com.superdzen.sorting;

import java.util.Arrays;

/**
 * Created by superdzen@gmail.com on 13.08.2017.
 * Two searching algorithms implementation: Bubble Sort and Selection Sort
 */
public class Main {
    public static void main(String[] args) {

        int[] array = {1, 2, 4, 5, 6, 4, 5, 8, 7, 2, 3, 2, 4, 5, 6, 4, 5, 8, 7, 2, 3};

        if (SortingMethods.ifNotNullAndEmptyArray(array)) {
            SortingMethods.bubbleSortAsc(array);
            System.out.println(Arrays.toString(array));
            SortingMethods.bubbleSortDesc(array);
            System.out.println(Arrays.toString(array));
            SortingMethods.SelectionSortAsc(array);
            System.out.println(Arrays.toString(array));
            SortingMethods.SelectionSortDesc(array);
            System.out.println(Arrays.toString(array));
        }

    }
}
