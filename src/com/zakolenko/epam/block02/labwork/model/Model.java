package com.zakolenko.epam.block02.labwork.model;

/**
 * This class contains logic for the calculating square of rhombus.
 *
 * @author Roman Zakolenko
 */
public class Model {
    public static final int MAX_ANGLE = 180;
    public static final int MIN_ANGLE = 0;

    /**
     * Returns square of the rhombus with the given parameters.
     * If the passed parameters are not correct then an IllegalArgumentException is thrown.
     *
     * @param side  value of the side of the rhombus
     * @param angle value of the angle of the rhombus
     * @return
     */
    public double getSquareOfRhomb(int side, int angle) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive, side = " + side);
        }
        if (angle <= MIN_ANGLE || angle >= MAX_ANGLE) {
            throw new IllegalArgumentException("Angle must be in range 0..180, angle = " + angle);
        }
        double angleInRadians = Math.toRadians(angle);
        return side * side * Math.sin(angleInRadians);
    }
}
