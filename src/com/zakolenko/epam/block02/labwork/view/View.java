package com.zakolenko.epam.block02.labwork.view;

/**
 * An instance of this class is used to represent the user data.
 *
 * @author Roman Zakolenko
 */
public class View {
    //Messages for user interaction
    public static final String CALCULATE_SQUARE_RHOMBUS = "Calculating the square of a rhombus. ";
    public static final String INPUT_INT_SIDE = "Please, input int value of side = ";
    public static final String INPUT_INT_ANGLE = "Please, input int value of angle in degree = ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String SIDE_MUST_BE_POSITIVE = "Side of rhombus must be positive! ";
    public static final String ANGLE_MUST_BE_IN_RANGE = "Angle of rhombus must be in range(0..180)! ";
    public static final String SQUARE_RHOMBUS = "Square of rhombus = ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String... messages) {
        StringBuilder message = new StringBuilder();
        for (String msg : messages) {
            message.append(msg);
        }
        System.out.println(message);
    }
}
