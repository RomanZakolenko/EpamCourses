package com.zakolenko.epam.block02.sorts;

public class MergeSort {

    public static void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("input array is null.");
        }
        int[] tempArray = new int[array.length];
        sort(array, tempArray, 0, array.length);
    }

    private static void sort(int[] array, int[] tempArray, int begin, int end) {
        if (begin < end - 1) {
            int mid = begin + (end - begin) / 2;
            sort(array, tempArray, begin, mid);
            sort(array, tempArray, mid, end);
            merge(array, tempArray, begin, mid, end);
        }
    }

    private static void merge(int[] array, int[] tempArray, int begin, int mid, int end) {
        System.arraycopy(array, begin, tempArray, begin, end - begin);
        int j = begin;
        int k = mid;
        for (int i = begin; i < end; i++) {
            if (j >= mid) {
                array[i] = tempArray[k++];
            } else {
                if (k >= end) {
                    array[i] = tempArray[j++];
                } else {
                    if (tempArray[j] < tempArray[k]) {
                        array[i] = tempArray[j++];
                    } else {
                        array[i] = tempArray[k++];
                    }
                }
            }
        }
    }
}
