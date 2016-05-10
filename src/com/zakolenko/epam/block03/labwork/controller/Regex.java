package com.zakolenko.epam.block03.labwork.controller;

/**
 * This interface contains a regular expression
 * to validate the data in the controller.
 *
 * @author Roman Zakolenko
 */
public interface Regex {
    String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,7}$";
    String FULL_NAME_REGEX = "^[A-Za-z]+\\s[A-Za-z]\\.(\\s[A-Za-z]\\.)?$";
    String GROUP_ID_REGEX = "[123]";
    String LATIN_LETTERS_REGEX = "[A-za-z]+";
    String DIGIT_REGEX = "\\d+";
}
