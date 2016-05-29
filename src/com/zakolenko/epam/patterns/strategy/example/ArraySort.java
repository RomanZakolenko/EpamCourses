package com.zakolenko.epam.patterns.strategy.example;

public class ArraySort {
    private Sorting sorting;

    public void setSort(Sorting sorting) {
        this.sorting = sorting;
    }

    public void sort(int[] array) {
        sorting.sort(array);
    }
}
