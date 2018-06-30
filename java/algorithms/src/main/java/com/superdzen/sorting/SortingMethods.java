package com.superdzen.sorting;

/**
 * Created by superdzen@gmail.com on 09.08.2017.
 */

public class SortingMethods {

    public static void bubbleSortAsc(int[] array) {

        boolean swapped;
        do {
            swapped = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
        } while (swapped);

    }

    public static void bubbleSortDesc(int[] array) {

        boolean swapped;
        do {
            swapped = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
        } while (swapped);

    }

    public static void SelectionSortAsc(int[] array) {

        for (int j = 0; j < array.length - 1; j++) {
            int indexMinElement = getIndexOfMinElement(array, j, array.length - 1);
            if (array[j] != array[indexMinElement]) {
                swap(array, j, indexMinElement);
            }
        }

    }

    public static void SelectionSortDesc(int[] array) {

        for (int j = 0; j < array.length - 1; j++) {
            int indexMaxElement = getIndexOfMaxElement(array, j, array.length - 1);
            if (array[j] != array[indexMaxElement]) {
                swap(array, j, indexMaxElement);
            }
        }

    }


    public static boolean ifNotNullAndEmptyArray(int[] array) {

        if (array != null) {
            if (array.length == 0) {
                System.out.println("Error: Empty Array");
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("Error: Null pointer of array");
            return false;
        }

    }

    private static void swap(int[] array, int i, int j) {

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    private static int getIndexOfMinElement(int[] array, int start, int end) {

        int minElementIndex = start;
        for (int i = start; i <= end; i++) {
            if (array[minElementIndex] > array[i]) {
                minElementIndex = i;
            }
        }
        return minElementIndex;

    }

    private static int getIndexOfMaxElement(int[] array, int start, int end) {

        int minElementIndex = start;
        for (int i = start; i <= end; i++) {
            if (array[minElementIndex] < array[i]) {
                minElementIndex = i;
            }
        }
        return minElementIndex;

    }

}
