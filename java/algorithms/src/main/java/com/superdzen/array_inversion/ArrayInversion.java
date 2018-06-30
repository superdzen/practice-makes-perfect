package com.superdzen.array_inversion;

import java.util.Arrays;
import com.superdzen.sorting.SortingMethods;

/**
 * Created by superdzen@gmail.com on 13.08.2017.
 * This class implements two methods of array inversion:
 * 1. from first element to middle element
 * 2. from middle element to first
 */
public class ArrayInversion {
    public static void main(String[] args) {

        int[] array = {1, 2, 4, 5, 6, 4, 5, 8, 7, 2, 3, 2, 4, 5, 6, 4, 5, 8, 7, 2, 3};

        if (SortingMethods.ifNotNullAndEmptyArray(array)) {
            System.out.println(Arrays.toString(array));

            invertArray2(array);
            invertArray(array);

            System.out.println(Arrays.toString(array));
        }

    }

    public static void invertArray(int[] array) {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength / 2; i++) {
            swap(array, i, arrayLength - i - 1);
        }
    }

    public static void invertArray2(int[] array) {
        int arrayLength = array.length;
        int j = arrayLength / 2;
        if (arrayLength % 2 > 0) {
            j++;
        }
        for (int i = arrayLength / 2 - 1; i >= 0; i--, j++) {
            swap(array, i, j);
        }
    }

    private static void swap(int[] array, int i, int j) {
        //  System.out.println(array[i] + " <-> " + array[j]);
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
