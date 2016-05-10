package com.zakolenko.epam.block03.labwork;

import com.zakolenko.epam.block03.labwork.controller.Controller;
import com.zakolenko.epam.block03.labwork.model.NoteBook;
import com.zakolenko.epam.block03.labwork.view.View;

/**
 * This class provides an entry point into the program
 * to add a subscriber in the notebook.
 *
 * @author Roman Zakolenko
 */
public class Main {
    public static void main(String[] args) {
        NoteBook noteBook = new NoteBook();
        View view = new View();
        Controller controller = new Controller(noteBook, view);
        controller.addSubscriberInNoteBook();
        controller.printNoteBook();
    }
}
