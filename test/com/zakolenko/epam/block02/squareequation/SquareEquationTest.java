package com.zakolenko.epam.block02.squareequation;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareEquationTest {

    public static final double ACCURACY = 1e-10;

    @Test
    public void testSolveTwoRoots() throws Exception {
        SquareEquation squareEquation = new SquareEquation(1., -5, 6.);
        double[] res = squareEquation.solve();
        assertNotNull(res);
        assertEquals("Have to be 2 roots", res.length, 2);
        double min = res[0] < res[1] ? res[0] : res[1];
        double max = res[0] > res[1] ? res[0] : res[1];
        assertEquals("First root", 2., min, ACCURACY);
        assertEquals("Second root", 3., max, ACCURACY);
    }

    @Test
    public void testSolveOneRoot() {
        SquareEquation squareEquation = new SquareEquation(2, 4, 2);
        double[] res = squareEquation.solve();
        assertArrayEquals(new double[]{-1}, res, ACCURACY);
    }

    @Test
    public void testSolveNoRoots() {
        SquareEquation squareEquation = new SquareEquation(1, 1, 10);
        double[] res = squareEquation.solve();
        assertEquals(0, res.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSolveNotSquareEquation() {
        SquareEquation squareEquation = new SquareEquation(0, 4, 10);
        squareEquation.solve();
    }
}