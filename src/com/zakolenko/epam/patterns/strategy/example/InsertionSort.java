package com.zakolenko.epam.patterns.strategy.example;

public class InsertionSort implements Sorting {

    @Override
    public void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array == null.");
        }
        for (int i = 1; i < array.length; i++) {
            int pivot = array[i];
            int j = i - 1;
            while (j >= 0 && pivot < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = pivot;
        }
    }
}
