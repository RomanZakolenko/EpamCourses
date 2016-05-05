package com.zakolenko.epam.block01.randnumber;

/**
 * An instance of this class is used to represent the user data.
 *
 * @author Roman Zakolenko
 */
public class View {
    //Messages for user interaction
    public static final String INPUT_INT_DATA = "Please, input INT value = ";
    public static final String CURRENT_DIAPASON = "Range: ";
    public static final String WRONG_DIAPASON = "Your answer is not included in the range.";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please!";
    public static final String ANSWER_INT = "Your answer = ";
    public static final String USER_WIN = "Congratulations! You won!";
    public static final String NUMBER_OF_ATTEMPTS = "Number of attempts = ";

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
