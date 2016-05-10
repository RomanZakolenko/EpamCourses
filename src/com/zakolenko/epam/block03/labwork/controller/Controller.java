package com.zakolenko.epam.block03.labwork.controller;

import com.zakolenko.epam.block03.labwork.model.Address;
import com.zakolenko.epam.block03.labwork.model.Group;
import com.zakolenko.epam.block03.labwork.model.NoteBook;
import com.zakolenko.epam.block03.labwork.model.Subscriber;
import com.zakolenko.epam.block03.labwork.view.ViewMessages;
import com.zakolenko.epam.block03.labwork.view.View;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * An instance of this class is used to validate user input.
 * On the right is checked email, full name, address.
 * If the data are valid, the subscriber is created and added to the notebook.
 *
 * @author Roman Zakolenko
 */
public class Controller {

    private NoteBook noteBook;
    private View view;

    public Controller(NoteBook noteBook, View view) {
        this.noteBook = noteBook;
        this.view = view;
    }

    /**
     * This method processes the data entered by the user,
     * checks them for correctness and adds subscriber in notebook.
     */
    public void addSubscriberInNoteBook() {
        try (Scanner sc = new Scanner(System.in)) {
            view.printMessage(ViewMessages.INPUT_FULL_NAME);
            String fullName = inputStringValueWithScanner(sc, Regex.FULL_NAME_REGEX);
            view.printMessage(ViewMessages.INPUT_NICKNAME);
            String nickname = sc.nextLine().trim();
            view.printMessage(ViewMessages.SELECT_GROUP);
            int groupId = Integer.parseInt(inputStringValueWithScanner(sc, Regex.GROUP_ID_REGEX)) - 1;
            view.printMessage(ViewMessages.INPUT_MOBILE_PHONE);
            String mobilePhone = sc.nextLine().trim();
            view.printMessage(ViewMessages.INPUT_HOME_PHONE);
            String homePhone = sc.nextLine().trim();
            view.printMessage(ViewMessages.INPUT_EMAIL);
            String email = inputStringValueWithScanner(sc, Regex.EMAIL_REGEX);
            view.printMessage(ViewMessages.INPUT_SKYPE);
            String skype = sc.nextLine().trim();
            Address address = inputAddressWithScanner(sc);
            String[] name = fullName.split("(\\s)|(\\.\\s)|(\\.)");
            Subscriber sbscr = new Subscriber(name[1], name[0], "", nickname, "", Group.getByOrdinal(groupId), mobilePhone, homePhone, email, skype, address);
            if (name.length == 3) {
                sbscr.setMiddleName(name[2]);
            }
            noteBook.addSubscriber(sbscr);
            view.printMessage(ViewMessages.SUBSCRIBER_ADDED);
        }
    }

    /**
     * This method represents a model (notebook) through the view.
     * On the console prints the contents of the notebook.
     */
    public void printNoteBook() {
        view.printNoteBook(noteBook);
    }

    /**
     * Reads a string from the console according to the rule.
     * The rule is a regular expression that is passed as a parameter.
     * If the data is not correct, it is communicated to the user through the view.
     *
     * @param sc    used to enter from the console
     * @param regex used to validate data
     * @return string entered from the console
     */
    public String inputStringValueWithScanner(Scanner sc, String regex) {
        String result = "";
        boolean valid = false;
        while (!valid) {
            result = sc.nextLine().trim();
            valid = Pattern.matches(regex, result);
            if (!valid) {
                view.printMessage(ViewMessages.WRONG_INPUT_DATA);
            }
        }
        return result;
    }

    /**
     * Reads a data from the console for creating Address instance.
     * If the data is not correct, it is communicated to the user through the view.
     *
     * @param sc used to enter from the console
     * @return instance of class Address
     */
    public Address inputAddressWithScanner(Scanner sc) {
        view.printMessage(ViewMessages.INPUT_INDEX);
        String index = inputStringValueWithScanner(sc, Regex.DIGIT_REGEX);
        view.printMessage(ViewMessages.INPUT_CITY);
        String city = inputStringValueWithScanner(sc, Regex.LATIN_LETTERS_REGEX);
        view.printMessage(ViewMessages.INPUT_STREET);
        String street = inputStringValueWithScanner(sc, Regex.LATIN_LETTERS_REGEX);
        view.printMessage(ViewMessages.INPUT_HOUSE_NUMBER);
        String houseNumber = inputStringValueWithScanner(sc, Regex.DIGIT_REGEX);
        view.printMessage(ViewMessages.INPUT_FLAT_NUMBER);
        String flatNumber = inputStringValueWithScanner(sc, Regex.DIGIT_REGEX);
        return new Address(index, city, street, houseNumber, flatNumber);
    }

    /**
     * Introduces an integer from the console.
     * If you enter it incorrectly informs the user about this through view.
     *
     * @param sc used to enter from the console
     * @return integer entered from the console
     */
    public int inputIntValueWithScanner(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printMessage(ViewMessages.WRONG_INPUT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }
}
