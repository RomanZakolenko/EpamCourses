package com.zakolenko.epam.block02.sorts;

public class BubbleSort {

    public static void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array == null.");
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
