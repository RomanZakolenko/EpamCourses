package com.zakolenko.epam.block02.sorts;

public class Sorts {

    public static void bubbleSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array == null.");
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
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

    public static void selectionSort(int[] array) {
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
            swap(array, i, indexMin);
        }
    }

    public static void quickSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array == null.");
        }
        quickSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array == null.");
        }
        int[] tempArray = new int[array.length];
        mergeSort(array, tempArray, 0, array.length);
    }

    private static void mergeSort(int[] array, int[] tempArray, int begin, int end) {
        if (begin < end - 1) {
            int mid = begin + (end - begin) / 2;
            mergeSort(array, tempArray, begin, mid);
            mergeSort(array, tempArray, mid, end);
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

    private static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int index = partition(array, begin, end);
            quickSort(array, begin, index - 1);
            quickSort(array, index + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (array[j] < pivot) {
                swap(array, ++i, j);
            }
        }
        swap(array, ++i, end);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}