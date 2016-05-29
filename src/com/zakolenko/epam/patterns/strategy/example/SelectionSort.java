package com.zakolenko.epam.patterns.strategy.example;

public class SelectionSort implements Sorting {

    @Override
    public void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array == null.");
        }
        for (int i = 0; i < array.length - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexMin]) {
                    indexMin = j;
                }
            }
            int temp = array[i];
            array[i] = array[indexMin];
            array[indexMin] = temp;
        }
    }
}

