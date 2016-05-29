package com.zakolenko.epam.patterns.strategy.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArraySort arraySort = new ArraySort();
        //Set bubble sort
        int[] array = {1, 10, -2, 3, 23, 19, 32};
        arraySort.setSort(new BubbleSort());
        System.out.println("Before: " + Arrays.toString(array));
        arraySort.sort(array);
        System.out.println("After: " + Arrays.toString(array));
        //Set insertion sort
        array = new int[]{-4, 1, -2, 3, 23, 12, 321};
        arraySort.setSort(new InsertionSort());
        System.out.println("Before: " + Arrays.toString(array));
        arraySort.sort(array);
        System.out.println("After: " + Arrays.toString(array));
        //Set selection sort
        array = new int[]{-100, 200, -2, 10, 22, 12, -1};
        arraySort.setSort(new SelectionSort());
        System.out.println("Before: " + Arrays.toString(array));
        arraySort.sort(array);
        System.out.println("After: " + Arrays.toString(array));
    }
}
