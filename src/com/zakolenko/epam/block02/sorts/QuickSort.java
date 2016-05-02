package com.zakolenko.epam.block02.sorts;

public class QuickSort {
    public static void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array == null.");
        }
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int begin, int end) {
        if (begin < end) {
            int index = partition(array, begin, end);
            sort(array, begin, index - 1);
            sort(array, index + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin - 1;
        int temp = 0;
        for (int j = begin; j < end; j++) {
            if (array[j] < pivot) {
                temp = array[++i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        temp = array[++i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }
}
