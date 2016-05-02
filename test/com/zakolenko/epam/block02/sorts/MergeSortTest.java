package com.zakolenko.epam.block02.sorts;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSortException() {
        MergeSort.sort(null);
    }

    @Test
    public void testSort() {
        int[] testArray = new int[100];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (int) (Math.random() * 100);
        }
        int[] expected = new int[testArray.length];
        System.arraycopy(testArray, 0, expected, 0, testArray.length);
        Arrays.sort(expected);
        MergeSort.sort(testArray);
        assertArrayEquals(expected, testArray);
    }

    @Test
    public void testSortNoElements() {
        int[] testArray = new int[0];
        int[] expected = new int[testArray.length];
        MergeSort.sort(testArray);
        assertArrayEquals(expected, testArray);
    }

}