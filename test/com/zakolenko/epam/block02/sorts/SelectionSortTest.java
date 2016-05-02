package com.zakolenko.epam.block02.sorts;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSortException() {
        SelectionSort.sort(null);
    }

    @Test
    public void testSort() {
        int[] testArray = new int[5000];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (int) (Math.random() * 100);
        }
        int[] expected = new int[testArray.length];
        System.arraycopy(testArray, 0, expected, 0, testArray.length);
        Arrays.sort(expected);
        SelectionSort.sort(testArray);
        assertArrayEquals(expected, testArray);
    }

    @Test
    public void testSortNoElements() {
        int[] testArray = new int[0];
        int[] expected = new int[testArray.length];
        SelectionSort.sort(testArray);
        assertArrayEquals(expected, testArray);
    }
}