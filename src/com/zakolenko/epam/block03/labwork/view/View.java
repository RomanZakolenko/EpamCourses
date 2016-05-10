package com.zakolenko.epam.block03.labwork.view;

import com.zakolenko.epam.block03.labwork.model.NoteBook;

/**
 * An instance of this class is used to represent the user data.
 *
 * @author Roman Zakolenko
 */
public class View {

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

    public void printNoteBook(NoteBook noteBook) {
        System.out.println(noteBook);
    }
}
