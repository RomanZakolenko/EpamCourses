package com.zakolenko.epam.block01.randnumber;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {

    @Test(expected = IllegalArgumentException.class)
    public void testRandException() {
        new Model().rand(30, -10);
    }

    @Test
    public void testRand() {
        int expected = 10;
        assertEquals(expected, new Model().rand(expected - 1, expected + 1));
    }

    @Test
    public void testCompareWithRandNumber() {
        Model model = new Model();
        int rand = 10;
        model.setRandNumber(rand);
        assertTrue(model.compareWithRandNumber(rand));
        assertFalse(model.compareWithRandNumber(rand + 1));
    }
}