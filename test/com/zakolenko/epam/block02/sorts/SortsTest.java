package com.zakolenko.epam.block02.sorts;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortsTest {
    private int[] testArray;

    @Before
    public void initTestArray() {
        testArray = new int[1000];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (int) (Math.random() * 100);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBubbleSortException() {
        Sorts.bubbleSort(null);
    }

    @Test
    public void testBubbleSort() {
        int[] expected = new int[testArray.length];
        System.arraycopy(testArray, 0, expected, 0, testArray.length);
        Arrays.sort(expected);
        Sorts.bubbleSort(testArray);
        assertArrayEquals(expected, testArray);
    }

    @Test
    public void testBubbleSortNoElements() {
        int[] testArray = new int[0];
        int[] expected = new int[testArray.length];
        Sorts.bubbleSort(testArray);
        assertArrayEquals(expected, testArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertionSortException() {
        Sorts.insertionSort(null);
    }

    @Test
    public void testInsertionSort() {
        int[] expected = new int[testArray.length];
        System.arraycopy(testArray, 0, expected, 0, testArray.length);
        Arrays.sort(expected);
        Sorts.insertionSort(testArray);
        assertArrayEquals(expected, testArray);
    }

    @Test
    public void testInsertionSortNoElements() {
        int[] testArray = new int[0];
        int[] expected = new int[testArray.length];
        Sorts.insertionSort(testArray);
        assertArrayEquals(expected, testArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectionSortException() {
        Sorts.selectionSort(null);
    }

    @Test
    public void testSelectionSort() {
        int[] expected = new int[testArray.length];
        System.arraycopy(testArray, 0, expected, 0, testArray.length);
        Arrays.sort(expected);
        Sorts.selectionSort(testArray);
        assertArrayEquals(expected, testArray);
    }

    @Test
    public void testSelectionSortNoElements() {
        int[] testArray = new int[0];
        int[] expected = new int[testArray.length];
        Sorts.selectionSort(testArray);
        assertArrayEquals(expected, testArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuickSortException() {
        Sorts.quickSort(null);
    }

    @Test
    public void testQuickSort() {
        int[] expected = new int[testArray.length];
        System.arraycopy(testArray, 0, expected, 0, testArray.length);
        Arrays.sort(expected);
        Sorts.quickSort(testArray);
        assertArrayEquals(expected, testArray);
    }

    @Test
    public void testQuickSortNoElements() {
        int[] testArray = new int[0];
        int[] expected = new int[testArray.length];
        Sorts.quickSort(testArray);
        assertArrayEquals(expected, testArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMergeSortException() {
        Sorts.mergeSort(null);
    }

    @Test
    public void testMergeSort() {
        int[] expected = new int[testArray.length];
        System.arraycopy(testArray, 0, expected, 0, testArray.length);
        Arrays.sort(expected);
        Sorts.mergeSort(testArray);
        assertArrayEquals(expected, testArray);
    }

    @Test
    public void testMergeSortNoElements() {
        int[] testArray = new int[0];
        int[] expected = new int[testArray.length];
        Sorts.mergeSort(testArray);
        assertArrayEquals(expected, testArray);
    }
}