package com.zakolenko.epam.project2.view;

/**
 * An instance of this class is used to represent data.
 *
 * @author Roman Zakolenko
 */
public class View {

    /**
     * Print string message in console.
     *
     * @param message string to be printed in the console
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Print string messages in console.
     *
     * @param messages enumeration of string that will be printed in the console
     */
    public void printMessage(String... messages) {
        StringBuilder message = new StringBuilder();
        for (String m : messages) {
            message.append(m);
        }
        printMessage(message.toString());
    }
}
