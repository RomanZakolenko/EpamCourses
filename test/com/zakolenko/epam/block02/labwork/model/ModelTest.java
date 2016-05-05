package com.zakolenko.epam.block02.labwork.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {

    public static final double ACCURACY = 1e-10;
    public Model model;

    @Before
    public void initModel() {
        this.model = new Model();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSquareOfRhombNegativeSide() {
        model.getSquareOfRhomb(-1, 90);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSquareOfRhombNegativeAngle() {
        model.getSquareOfRhomb(2, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSquareOfRhombGreaterAngle() {
        model.getSquareOfRhomb(2, Model.MAX_ANGLE);
    }

    @Test
    public void testGetSquareOfRhomb() {
        int side = 2;
        int angle = 90;
        double res = model.getSquareOfRhomb(side, angle);
        assertEquals(4, res, ACCURACY);
    }
}