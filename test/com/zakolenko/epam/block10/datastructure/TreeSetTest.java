package com.zakolenko.epam.block10.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TreeSetTest {
    private TreeSet<Integer> treeSet;

    @Before
    public void setTreeSet() {
        treeSet = new TreeSet<>();
    }

    @Test
    public void testSize() {
        assertEquals("Set is not empty.", 0, treeSet.size());
        treeSet.add(1);
        assertEquals("Set has not one element.", 1, treeSet.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Set is not empty", treeSet.isEmpty());
        treeSet.add(1);
        assertFalse("Set is empty", treeSet.isEmpty());
    }

    @Test
    public void testContains() {
        Integer integer = 1;
        assertFalse(treeSet.contains(integer));
        treeSet.add(integer);
        assertTrue(treeSet.contains(integer));
        treeSet.add(2);
        assertTrue(treeSet.contains(2));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsException() {
        treeSet.contains(null);
    }

    @Test
    public void testAdd() {
        assertTrue(treeSet.add(1));
        assertTrue(treeSet.contains(1));
        assertFalse(treeSet.add(1));
    }

    @Test(expected = NullPointerException.class)
    public void testAddException() {
        treeSet.add(null);
    }

    @Test
    public void testRemove() {
        assertFalse(treeSet.remove(1));
        treeSet.add(1);
        treeSet.add(2);
        assertTrue(treeSet.remove(2));
        assertTrue(treeSet.remove(1));
        assertTrue(treeSet.isEmpty());
        assertFalse(treeSet.contains(1));
        assertFalse(treeSet.contains(2));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveException() {
        treeSet.remove(null);
    }
}